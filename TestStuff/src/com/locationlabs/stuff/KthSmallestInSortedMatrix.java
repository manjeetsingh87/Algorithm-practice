package com.locationlabs.stuff;

import java.util.PriorityQueue;

/**
 * Created by manjeet.singh on 9/30/19.
 */
public class KthSmallestInSortedMatrix {
   private static int kthSmallest(int[][] matrix, int k) {
      if (matrix == null || matrix.length == 0 || k <= 0) {
         return 0;
      }

      int len = matrix.length;
      int low = matrix[0][0], high = matrix[len - 1][len - 1];
      while (low <= high) {
         int mid = (low + high) / 2;
         int count = getLessEqual(matrix, mid, len);

         if (count < k) {
            low = mid + 1;
         } else {
            high = mid - 1;
         }
      }
      return low;
   }

   private static int getLessEqual(int[][] matrix, int val, int len) {
      int count = 0;
      int left = len - 1, right = 0;

      while (left >= 0 && right < len) {
         if (matrix[left][right] > val) {
            left--;
         } else {
            count += left + 1;
            right++;
         }
      }

      return count;
   }

   private static int kthSmallestApproach2(int[][] matrix, int k) {
      int n = matrix.length;

      final PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();

      // start with all elements in first row
      for(int col = 0; col <= n-1; col++) {
         pq.offer(new Tuple(0, col, matrix[0][col]));
      }

      for(int i = 0; i < k-1; i++) {
         Tuple tuple = pq.poll();
         if(tuple.x == n-1) {
            continue;
         }
         pq.offer(new Tuple(tuple.x + 1, tuple.y, matrix[tuple.x + 1][tuple.y]));
      }

      return pq.poll().val;
   }

   private static class Tuple implements Comparable<Tuple> {
      int x, y, val;

      public Tuple(int x, int y, int val) {
         this.x = x;
         this.y = y;
         this.val = val;
      }

      @Override
      public int compareTo(Tuple that) {
         return this.val - that.val;
      }
   }

   public static void main(String[] args) {
      System.out.println(kthSmallest(new int[][]{{1,  5,  9},{10, 11, 13}, {12, 13, 15}}, 8));
      System.out.println(kthSmallestApproach2(new int[][]{{1,  5,  9},{10, 11, 13}, {12, 13, 15}}, 8));
   }
}
