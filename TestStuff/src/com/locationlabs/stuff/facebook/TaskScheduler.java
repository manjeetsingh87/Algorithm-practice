package com.locationlabs.stuff.facebook;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 8/11/19.
 */
public class TaskScheduler {

   private static int leastInterval(char[] tasks, int n) {
      if (tasks == null || tasks.length == 0 || n <= 0) {
         return 0;
      }

      final int[] taskCount = new int[26];
      for (int task : tasks) {
         taskCount[task - 'A']++;
      }

      System.out.println(Arrays.toString(taskCount));
      int maxFrequency = 0, maxTaskCount = 1;
      for (int count : taskCount) {
         if (count == 0) {
            continue;
         }

         if (maxFrequency < count) {
            maxFrequency = count;
            maxTaskCount = 1;
         } else if (maxFrequency == count) {
            maxTaskCount++;
         }
      }

      //AAABB -> AXXAXXA
      //AAABBB -> ABXABXAB
      int emptySlots = (maxFrequency - 1) * (n - (maxTaskCount - 1));
      int availableTasks = tasks.length - (maxFrequency * maxTaskCount);
      int idles = Math.max(0, emptySlots - availableTasks);
      return idles + tasks.length;
   }

   public static void main(String[] args) {
      System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
   }
}
