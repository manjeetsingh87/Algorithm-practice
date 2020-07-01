package com.locationlabs.stuff.apple;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Created by manjeet.singh on 5/21/20.
 */
public class LoggerRateLimiter {
   private int[] bucket;
   private Set[] sets;

   /** Initialize your data structure here. */
   public LoggerRateLimiter() {
      this.bucket = new int[10];
      this.sets = new Set[10];
      for (int i = 0; i < 10; i++) {
         sets[i] = new HashSet();
      }
   }

   /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
    If this method returns false, the message will not be printed.
    The timestamp is in seconds granularity. */
   public boolean shouldPrintMessage(int timestamp, String message) {
      final int idx = timestamp % 10;
      if (timestamp != bucket[idx]) {
         sets[idx].clear();
         bucket[idx] = timestamp;
      }

      for (int i = 0; i < bucket.length; i++) {
         if (timestamp - bucket[i] < 10) {
            if (sets[i].contains(message)) {
               return false;
            }
         }
      }

      sets[idx].add(message);
      return true;
   }

   public static void main(String[] args) {
      final LoggerRateLimiter limiter = new LoggerRateLimiter();
      System.out.println(limiter.shouldPrintMessage(1, "foo"));
      System.out.println(limiter.shouldPrintMessage(2, "bar"));
      System.out.println(limiter.shouldPrintMessage(3, "foo"));
      System.out.println(limiter.shouldPrintMessage(8, "bar"));
      System.out.println(limiter.shouldPrintMessage(10, "foo"));
      System.out.println(limiter.shouldPrintMessage(11, "foo"));
   }
}
