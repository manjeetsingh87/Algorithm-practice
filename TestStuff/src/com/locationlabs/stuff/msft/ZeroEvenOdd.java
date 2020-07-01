package com.locationlabs.stuff.msft;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * Created by manjeet.singh on 4/22/20.
 */
public class ZeroEvenOdd {
   private int n;
   private volatile int count = 0;
   private final ReentrantLock lock = new ReentrantLock();
   private final Condition zeroCond = lock.newCondition();
   private final Condition evenCond = lock.newCondition();
   private final Condition oddCond = lock.newCondition();

   public ZeroEvenOdd(int n) {
      this.n = n;
   }

   // printNumber.accept(x) outputs "x", where x is an integer.
   public void zero(IntConsumer printNumber) throws InterruptedException {
      while (count <= n) {
         try {
            lock.lock();
            count++;
            if (count % 2 == 0) {
               evenCond.signalAll();
            } else {
               oddCond.signalAll();
            }
            printNumber.accept(0);

            if (count == n) {
               return;
            }
            zeroCond.await();
         } finally {
            lock.unlock();
         }
      }
   }

   public void even(IntConsumer printNumber) throws InterruptedException {
      while (count <= n && n != 1) {
         try {
            lock.lock();
            if (count == 0 || count % 2 != 0) {
               evenCond.await();
            }
            printNumber.accept(count);
            zeroCond.signal();
            if (count + 2 > n) {
               return;
            }
            evenCond.await();
         } finally {
            lock.unlock();
         }
      }
   }

   public void odd(IntConsumer printNumber) throws InterruptedException {
      while (count <= n) {
         try {
            lock.lock();
            if (count == 0 || count % 2 == 0) {
               oddCond.await();
            }
            printNumber.accept(count);
            zeroCond.signal();
            if (count + 2 > n) {
               return;
            }
            oddCond.await();
         } finally {
            lock.unlock();
         }
      }
   }
}
