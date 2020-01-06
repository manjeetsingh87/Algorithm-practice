package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by manjeet.singh on 6/24/19.
 */
public class TaskScheduler {
   // There is one crucial point for you:
   // the ONLY thing you need to care is the max number of one task!
   // We set apart each max task with interval n,
   // and we hope to put all other tasks into those intervals.
   // If the number of those tasks exceeds the interval space,
   // then we don't need any idle interval at all.
   // If not, the interval space plus the max tasks will be the least interval.
   // Be care for the existent of multiple max tasks.
   private static int leastInterval(char[] tasks, int n) {
      if (tasks == null || tasks.length == 0 || n < 0) {
         return 0;
      }

      int[] taskCount = new int[26];
      for (char ch : tasks) {
         taskCount[ch - 'A']++;
      }

      int max = 0, count = 1;
      for (int num : taskCount) {
         if (num == 0) {
            continue;
         }
         if (max < num) {
            max = num;
            count = 1;
         } else if (max == num) {
            count++;
         }
      }

      int space = (n + 1) * (max - 1) + count;
      return space < tasks.length ? tasks.length : space;
   }

   private static int leastIntervalWithPQ(char[] tasks, int n) {
      if (tasks == null || tasks.length == 0 || n < 0) {
         return 0;
      }

      final Map<Character, Integer> taskCountMap = new HashMap<>();
      for (char task : tasks) {
         taskCountMap.put(task ,taskCountMap.getOrDefault(task, 0) + 1);
      }

      final Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
      taskCountMap.values().forEach(queue::offer);

      int time = 0;
      while (!queue.isEmpty()) {
         int i = 0;
         final List<Integer> temp = new ArrayList<>();
         while (i <= n) {
            if (!queue.isEmpty()) {
               int curr = queue.poll();
               if (curr > 1) {
                  temp.add(curr - 1);
               }
            }
            time++;
            if (queue.isEmpty() && temp.size() == 0) {
               break;
            }
            i++;
         }
         for (int left : temp) {
            queue.offer(left);
         }
      }

      return time;
   }

   public static void main(String[] args) {
      System.out.println(leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
      System.out.println(leastInterval(new char[]{'A','A','A','B','B','B', 'C', 'D'}, 3));
      System.out.println(leastIntervalWithPQ(new char[]{'A','A','A','B','B','B'}, 2));
   }
}
