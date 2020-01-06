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
         int count = getLessEqual(matrix, mid);
         if (count < k) {
            low = mid + 1;
         } else {
            high = mid - 1;
         }
      }
      return low;
   }

   private static int getLessEqual(int[][] matrix, int val) {
      int result = 0;
      int n = matrix.length, i = n - 1, j = 0;
      while (i >= 0 && j < n) {
         if (matrix[i][j] > val) {
            i--;
         } else {
            result += i + 1;
            j++;
         }
      }
      return result;
   }

   private static int kthSmallestApproach2(int[][] matrix, int k) {
      int n = matrix.length;

      final PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();

      for(int j = 0; j <= n-1; j++) {
         pq.offer(new Tuple(0, j, matrix[0][j]));
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
