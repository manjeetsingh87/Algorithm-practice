package com.locationlabs.stuff.facebook;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by manjeet.singh on 7/26/19.
 */
public class KClosestPointsToOrigin {
   private static int[][] kClosest(int[][] points, int K) {
      final int[][] result = new int[K][2];

      if (points == null || points.length == 0) {
         return result;
      }

      int len = points.length;
      if (len < K) {
         return points;
      }

      final Queue<int[]> pq = new PriorityQueue<>(((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]));

      for (int[] point : points) {
         pq.offer(point);
         if (pq.size() > K) {
            pq.poll();
         }
      }

      if (pq.isEmpty()) {
         return result;
      }

      while (K-- > 0) {
         int[] point = pq.poll();
         result[K][0] = point[0];
         result[K][1] = point[1];
      }

      for (int[] point : result) {
         System.out.println(Arrays.toString(point));
      }

      return result;
   }

   public static void main(String[] args) {
      kClosest(new int[][]{{1, 3}, {-2, 2}}, 1);
      System.out.println("-------------------------");
      kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);
   }
}
