package com.locationlabs.stuff.dropbox;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by manjeet.singh on 7/23/19.
 */
public class ReentrantReaderWriterLock {
   private ConcurrentMap<Thread, Integer> readingThreads = new ConcurrentHashMap<>();
   private AtomicInteger writeAccess = new AtomicInteger(0);
   private AtomicInteger writeRequests = new AtomicInteger(0);
   private volatile Thread writingThread = null;

   public synchronized void readLock() throws InterruptedException {
      final Thread callingThread = Thread.currentThread();

      while (!canGrantReadAccess(callingThread)) {
         wait();
      }

      this.readingThreads.put(callingThread, getReadAccessCount(callingThread) + 1);
   }

   private boolean canGrantReadAccess(final Thread callingThread) {
      if (isWriter(callingThread) || isReader(callingThread)) {
         return true;
      }

      if (hasWriter() || hasWriteRequests()) {
         return false;
      }

      return true;
   }

   public synchronized void unlockRead() throws InterruptedException {
      final Thread callingThread = Thread.currentThread();

      if (!isReader(callingThread)) {
         throw new IllegalMonitorStateException("");
      }

      int accessCount = getReadAccessCount(callingThread);

      if (accessCount == 1) {
         this.readingThreads.remove(callingThread);
      } else {
         this.readingThreads.put(callingThread, accessCount - 1);
      }

      notifyAll();
   }

   public synchronized void lockWrite() throws InterruptedException {
      this.writeRequests.getAndIncrement();
      final Thread callingThread = Thread.currentThread();

      while (!canGrantWriteAccess(callingThread)) {
         wait();
      }

      this.writeRequests.getAndDecrement();
      this.writeAccess.getAndIncrement();
      this.writingThread = callingThread;
   }

   public synchronized void unlockWrite() throws InterruptedException {
      final Thread callingThread = Thread.currentThread();

      if (!isWriter(callingThread)) {
         throw new IllegalMonitorStateException("");
      }

      this.writeAccess.getAndDecrement();

      if (this.writeAccess.get() == 0) {
         this.writingThread = null;
      }

      notifyAll();
   }

   private boolean canGrantWriteAccess(final Thread callingThread) {
      if (isOnlyReader(callingThread)) {
         return true;
      }

      if (hasReaders()) {
         return false;
      }

      if (this.writingThread == null) {
         return true;
      }

      if (!isWriter(callingThread)) {
         return false;
      }

      return true;
   }

   private int getReadAccessCount(Thread callingThread) {
      Integer accessCount = this.readingThreads.get(callingThread);

      if (accessCount == null) {
         return 0;
      }

      return accessCount;
   }

   private boolean isWriter(final Thread callingThread) {
      return callingThread == this.writingThread;
   }

   private boolean hasWriter() {
      return this.writingThread != null;
   }

   private boolean hasReaders() {
      return readingThreads.size() > 0;
   }

   private boolean hasWriteRequests() {
      return this.writeRequests.get() > 0;
   }

   private boolean isReader(final Thread callingThread) {
      return this.readingThreads.get(callingThread) != null;
   }

   private boolean isOnlyReader(final Thread callingThread) {
      return !this.readingThreads.isEmpty() && this.readingThreads.get(callingThread) != null;
   }
}
