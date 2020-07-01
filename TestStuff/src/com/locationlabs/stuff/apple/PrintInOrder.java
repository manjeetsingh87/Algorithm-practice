package com.locationlabs.stuff.apple;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by manjeet.singh on 5/25/20.
 */
public class PrintInOrder {
   private ReentrantLock lock;
   private Condition second;
   private Condition third;
   private AtomicBoolean firstPrinted;
   private AtomicBoolean secondPrinted;

   public PrintInOrder() {
      lock = new ReentrantLock();
      second = lock.newCondition();
      third = lock.newCondition();
      firstPrinted = new AtomicBoolean(false);
      secondPrinted = new AtomicBoolean(false);
   }

   public void first(Runnable printFirst) throws InterruptedException {
      lock.lock();
      try {
         // printFirst.run() outputs "first". Do not change or remove this line.
         printFirst.run();

         firstPrinted.set(true);
         secondPrinted.set(false);
         second.signal();
      } finally {
         lock.unlock();
      }
   }

   public void second(Runnable printSecond) throws InterruptedException {
      lock.lock();
      while (!firstPrinted.get()) {
         second.await();
      }
      // printSecond.run() outputs "second". Do not change or remove this line.
      printSecond.run();
      secondPrinted.set(true);
      third.signal();
      lock.unlock();
   }

   public void third(Runnable printThird) throws InterruptedException {
      lock.lock();
      try {
         while (!secondPrinted.get()) {
            third.await();
         }
         // printThird.run() outputs "third". Do not change or remove this line.
         printThird.run();
      } finally {
         lock.unlock();
      }
   }
}
