package com.locationlabs.stuff;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by manjeet.singh on 5/26/19.
 */
public class KClosestToOrigin {
   private static int[][] kClosest(int[][] points, int k) {
      if (points == null || points.length == 0) {
         return new int[0][0];
      }

      Queue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
         @Override
         public int compare(int[] p1, int[] p2) {
            return getDistance(p2) - getDistance(p1);
         }
      });

      for (int[] point : points) {
         heap.offer(point);
         if (heap.size() > k) {
            heap.poll();
         }
      }

      int[][] result = new int[k][2];
      for (int i = k - 1; i >= 0; i--) {
         result[i] = heap.poll();
      }

      return result;
   }

   private static int getDistance(int[] point) {
      return (point[0] * point[0]) + (point[1] * point[1]);
   }

   public static void main(String[] args) {
      int[][] result = kClosest(new int[][]{{1, 3}, {-2, -2}, {-1, -1}, {1, 1}}, 2);
      for (int[] res : result) {
         System.out.println(Arrays.toString(res));
      }
   }
}
