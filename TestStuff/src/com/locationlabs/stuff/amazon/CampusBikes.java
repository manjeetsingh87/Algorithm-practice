package com.locationlabs.stuff.amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by manjeet.singh on 5/8/20.
 */
public class CampusBikes {
   private static class Tuple {
      private int worker;
      private int bike;
      private int distance;

      protected Tuple(int worker, int bike, int distance) {
         this.worker = worker;
         this.bike = bike;
         this.distance = distance;
      }

      @Override
      public String toString() {
         return worker + "-" + bike + "-" + distance;
      }
   }

   private static int[] assignBikes(int[][] workers, int[][] bikes) {
      if (workers == null || workers.length == 0 || bikes == null || bikes.length == 0) {
         return new int[0];
      }

      final int n = workers.length;

      final PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> {
         final int cmp = Integer.compare(a.distance, b.distance);
         if (cmp == 0) {
            if (a.worker == b.worker) {
               return Integer.compare(a.bike, b.bike);
            }
            return Integer.compare(a.worker, b.worker);
         }
         return cmp;
      });

      for (int i = 0; i < n; i++) {
         final int[] worker = workers[i];
         for (int j = 0; j < bikes.length; j++) {
            final int[] bike = bikes[j];
            final int manhattanDist = Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
            pq.offer(new Tuple(i, j, manhattanDist));
         }
      }

      final int[] result = new int[n];
      Arrays.fill(result, -1);
      final Set<Integer> bikeAssigned = new HashSet<>();
      while (bikeAssigned.size() < n) {
         Tuple workerBike = pq.poll();
         if (result[workerBike.worker] == -1 && !bikeAssigned.contains(workerBike.bike)) {
            result[workerBike.worker] = workerBike.bike;
            bikeAssigned.add(workerBike.bike);
         }
      }

      return result;
   }

   public static void main(String[] args) {
      final int[][] workers = {{0, 0}, {1, 1}, {2, 0}};
      final int[][] bikes = {{1, 0}, {2, 2}, {2, 1}};
      System.out.println(Arrays.toString(assignBikes(workers, bikes)));
   }
}
