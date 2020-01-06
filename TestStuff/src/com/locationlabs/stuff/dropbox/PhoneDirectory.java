package com.locationlabs.stuff.dropbox;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by manjeet.singh on 7/22/19.
 */
public class PhoneDirectory {

   private Set<Integer> recycle;
   private volatile int maxNumber;
   private AtomicInteger nextNumber;

   /** Initialize your data structure here
    @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
   public PhoneDirectory(int maxNumbers) {
      recycle = new HashSet<>();
      nextNumber = new AtomicInteger();
      maxNumber = maxNumbers;
   }

   /** Provide a number which is not assigned to anyone.
    @return - Return an available number. Return -1 if none is available. */
   public int get() {
      synchronized (this) {
         if (!recycle.isEmpty()) {
            return getRecycledNumber();
         }

         if (nextNumber.get() < maxNumber) {
            return nextNumber.getAndIncrement();
         }

         return -1;
      }
   }

   /** Check if a number is available or not. */
   public boolean check(int number) {
      synchronized (this) {
         return isLegal(number) && !isAssigned(number);
      }
   }

   /** Recycle or release a number. */
   public void release(int number) {
      synchronized (this) {
         if (isLegal(number) && isAssigned(number)) {
            recycle.add(number);
         }
      }
   }

   private boolean isLegal(int number) {
      return number >= 0 && number < maxNumber;
   }

   private boolean isAssigned(int number) {
      return number < nextNumber.get() && !recycle.contains(number);
   }

   private int getRecycledNumber() {
      Iterator<Integer> itr = recycle.iterator();
      int number = itr.next();
      itr.remove();
      return number;
   }

   public static void main(String[] args) {
      PhoneDirectory directory = new PhoneDirectory(3);
      System.out.println(directory.get());
      System.out.println(directory.get());
      System.out.println(directory.check(2));
      System.out.println(directory.get());
      System.out.println(directory.check(2));
      directory.release(2);
      System.out.println(directory.check(2));
   }
}
