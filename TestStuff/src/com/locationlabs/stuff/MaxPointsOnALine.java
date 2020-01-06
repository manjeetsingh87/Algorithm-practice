package com.locationlabs.stuff;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 7/16/19.
 */
public class MaxPointsOnALine {
   private static int maxPoints(int[][] points) {
      if (points == null || points.length == 0) {
         return 0;
      }

      if (points.length == 1) {
         return 1;
      }

      int result = 0;
      for (int i = 0; i < points.length; i++) {
         final Map<BigDecimal, Integer> map = new HashMap<>();
         int samePoint = 0;
         int sameCoordinate = 1;
         int bestDistance = 0;
         for (int j = i + 1; j < points.length; j++) {
            if (points[j][0] == points[i][0] && points[j][1] == points[i][1]) {
               samePoint++;
            }

            if (points[j][0] == points[i][0] || points[j][1] == points[i][1]) {
               sameCoordinate++;
               continue;
            }

            BigDecimal distance = getSlope(points[j], points[i]);
            int count = map.getOrDefault(distance, 1);
            map.put(distance, count + 1);
            bestDistance = Math.max(bestDistance, map.get(distance));
         }
         result = Math.max(result, Math.max(sameCoordinate, bestDistance + samePoint));
      }

      return result;
   }

   private static BigDecimal getSlope(int[] point1, int[] point2){
      return BigDecimal.valueOf(point2[1] - point1[1]).divide(BigDecimal.valueOf(point2[0] - point1[0]), new MathContext(20));
   }

   public static void main(String[] args) {
      /*System.out.println(maxPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
      System.out.println(maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}));
      System.out.println(maxPoints(new int[][]{{0, 0}, {1, 1}, {0, 0}}));
      System.out.println(maxPoints(new int[][]{{0, 0}, {0, 0}}));*/
      System.out.println(maxPoints(new int[][]{{0,0},{94911151,94911150},{94911152,94911151}}));
   }
}
