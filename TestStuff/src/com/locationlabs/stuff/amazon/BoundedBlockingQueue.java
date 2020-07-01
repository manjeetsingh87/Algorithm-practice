package com.locationlabs.stuff.amazon;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by manjeet.singh on 5/11/20.
 */
public class BoundedBlockingQueue {
   private ConcurrentLinkedQueue<Integer> queue;
   private volatile int capacity;
   private ReentrantLock lock;
   private Condition read;
   private Condition write;

   public BoundedBlockingQueue(int capacity) {
      this.queue = new ConcurrentLinkedQueue<>();
      this.capacity = capacity;
      this.lock = new ReentrantLock();
      this.read = lock.newCondition();
      this.write = lock.newCondition();
   }

   public void enqueue(int element) throws InterruptedException {
      lock.lock();
      try {
         while (this.capacity == this.queue.size()) {
            System.out.println("Queue full");
            write.await();
         }
         queue.offer(element);
         System.out.println("Enuqueued " + element);
         read.signal();
      } finally {
         lock.unlock();
      }
   }

   public int dequeue() throws InterruptedException {
      lock.lock();
      try {
         while (queue.isEmpty()) {
            System.out.println("Queue empty");
            read.await();
         }
         final int val = queue.poll();
         System.out.println("Dequed " + val);
         write.signal();
         return val;
      } finally {
         lock.unlock();
      }
   }

   public int size() {
      lock.lock();
      try {
         return this.queue.size();
      } finally {
         lock.unlock();
      }
   }

   protected static class TestBlockingQueue {
      private BoundedBlockingQueue boundedBlockingQueue;

      protected TestBlockingQueue() {
         this.boundedBlockingQueue = new BoundedBlockingQueue(10);
      }

      Thread t1 = new Thread(new Runnable() {
         public void run() {
            try {
               for (int i = 0; i < 10; i++) {
                  boundedBlockingQueue.enqueue(i);
               }
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      });

      Thread t2 = new Thread(new Runnable() {
         public void run() {
            try {
               for (int i = 0; i < 10; i++) {
                  boundedBlockingQueue.dequeue();
               }
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      });
   }

   public static void main(String[] args) throws InterruptedException {
      TestBlockingQueue test = new TestBlockingQueue();
      test.t2.start();
      test.t2.join(1000);
      test.t1.start();
      test.t1.join(1000);
   }
}
