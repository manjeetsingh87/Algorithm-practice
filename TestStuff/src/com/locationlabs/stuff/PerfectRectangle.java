package com.locationlabs.stuff;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by manjeet.singh on 10/1/19.
 */
public class PerfectRectangle {
   private static boolean isRectangleCover(int[][] rectangles) {
      if (rectangles.length == 0 || rectangles[0].length == 0) {
         return false;
      }

      int x1 = Integer.MAX_VALUE;
      int x2 = Integer.MIN_VALUE;
      int y1 = Integer.MAX_VALUE;
      int y2 = Integer.MIN_VALUE;

      final Set<String> set = new HashSet<>();
      int area = 0;

      for (int[] rectangle : rectangles) {
         x1 = Math.min(rectangle[0], x1);
         y1 = Math.min(rectangle[1], y1);
         x2 = Math.max(rectangle[2], x2);
         y2 = Math.max(rectangle[3], y2);

         area += (rectangle[2] - rectangle[0]) * (rectangle[3] - rectangle[1]);

         final String s1 = rectangle[0] + " " + rectangle[1];
         final String s2 = rectangle[0] + " " + rectangle[3];
         final String s3 = rectangle[2] + " " + rectangle[3];
         final String s4 = rectangle[2] + " " + rectangle[1];

         if (!set.add(s1)) {
            set.remove(s1);
         }
         if (!set.add(s2)) {
            set.remove(s2);
         }
         if (!set.add(s3)) {
            set.remove(s3);
         }
         if (!set.add(s4)) {
            set.remove(s4);
         }
      }

      if (!set.contains(x1 + " " + y1) || !set.contains(x1 + " " + y2)
              || !set.contains(x2 + " " + y1) || !set.contains(x2 + " " + y2)
              || set.size() != 4) {
         return false;
      }

      return area == (x2-x1) * (y2-y1);
   }

   public static void main(String[] args) {
      int[][] rectangles = new int[][]{{1, 1, 3, 3},
              {3, 1, 4, 2},
              {3, 2, 4, 4},
              {1, 3, 2, 4},
              {2, 3, 3, 4}};
      System.out.println(isRectangleCover(rectangles));
   }
}
