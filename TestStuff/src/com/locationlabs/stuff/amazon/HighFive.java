package com.locationlabs.stuff.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by manjeet.singh on 3/26/20.
 */
public class HighFive {
   private static int[][] highFive(int[][] items) {
      if (items == null || items.length == 0) {
         return items;
      }

      final Map<Integer, Student> map = new HashMap<>();

      for (int[] item : items) {
         int studentId = item[0];
         if (map.containsKey(studentId)) {
            map.get(studentId).updateRecord(item[1]);
         } else {
            map.put(studentId, new Student(studentId, item[1]));
         }
      }

      final int[][] result = new int[map.size()][2];

      int i = 0;
      for (int studentId : map.keySet()) {
         final Student student = map.get(studentId);
         result[i++] = new int[]{studentId, student.getAverage()};
      }

      return result;
   }

   public static void main(String[] args) {
      final int[][] items = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
      for (int[] res : highFive(items)) {
         System.out.println(Arrays.toString(res));
      }
   }

   private static class Student {
      private Integer id;
      private PriorityQueue<Integer> scores = new PriorityQueue<>();

      private Student(int id, int score) {
         this.id = id;
         scores.offer(score);
      }

      private void updateRecord(int score) {
         scores.offer(score);
         if (scores.size() > 5) {
            scores.poll();
         }
      }

      private int getAverage() {
         int totalScore = 0;
         int subjects = scores.size();
         while (!scores.isEmpty()) {
            totalScore += scores.poll();
         }
         return (int) (totalScore / subjects);
      }

      @Override
      public boolean equals(Object obj) {
         if (obj == null) {
            return false;
         }

         return (obj instanceof Student) && ((Student) obj).id.equals(this.id);
      }

      @Override
      public int hashCode() {
         return id;
      }
   }
}
