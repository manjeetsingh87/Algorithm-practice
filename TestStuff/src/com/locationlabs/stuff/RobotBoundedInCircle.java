package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 4/28/20.
 */
public class RobotBoundedInCircle {
   private static boolean isRobotBounded(String instructions) {
      if (instructions == null || instructions.isEmpty()) {
         return false;
      }

      int x = 0, y = 0, i = 0;
      final int[][] d = {{0, 1}, {1, 0}, {0, -1}, { -1, 0}};
      for (int j = 0; j < instructions.length(); ++j) {
         final char ch = instructions.charAt(j);
         if (ch == 'R') {
            i = (i + 1) % 4;
         } else if (ch == 'L') {
            i = (i + 3) % 4;
         } else {
            x += d[i][0];
            y += d[i][1];
         }
      }

      return x == 0 && y == 0 || i > 0;
   }

   public static void main(String[] args) {
      System.out.println(isRobotBounded("GGLLGG"));
      System.out.println(isRobotBounded("GG"));
      System.out.println(isRobotBounded("GL"));
   }
}
