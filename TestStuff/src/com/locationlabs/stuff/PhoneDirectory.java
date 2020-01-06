package com.locationlabs.stuff;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

/**
 * Created by manjeet.singh on 6/20/19.
 */
public class PhoneDirectory {
   /** Initialize your data structure here
    @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
   private Deque<Integer> directory;
   private Set<Integer> provisioned;
   private int max;

   public PhoneDirectory(int maxNumbers) {
      this.directory = new LinkedList<>();
      this.provisioned = new HashSet<>();
      this.max = maxNumbers;

      for (int i = 0; i < maxNumbers; i++) {
         this.directory.offer(i);
      }
   }

   /** Provide a number which is not assigned to anyone.
    @return - Return an available number. Return -1 if none is available. */
   public int get() {
      if (this.directory.isEmpty()) {
         return -1;
      }

      Integer next = this.directory.poll();
      this.provisioned.add(next);
      return next;
   }

   /** Check if a number is available or not. */
   public boolean check(int number) {
      if (number >= this.max || number < 0) {
         return false;
      }

      return !this.provisioned.contains(number);
   }

   /** Recycle or release a number. */
   public void release(int number) {
      if (this.provisioned.remove(number)) {
         this.directory.offer(number);
      }
   }

   public static void main(String[] args) {
      final PhoneDirectory directory = new PhoneDirectory(1);
      System.out.println(directory.check(0));
      System.out.println(directory.get());
      System.out.println(directory.check(0));
      System.out.println(directory.get());
      directory.release(0);
      System.out.println(directory.check(0));
      System.out.println(directory.get());
      System.out.println(directory.get());
   }
}
