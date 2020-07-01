package com.locationlabs.stuff.apple;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by manjeet.singh on 5/26/20.
 */
public class MinimumKnightMoves {
   private static int minKnightMoves(int x, int y) {
      x = Math.abs(x);
      y = Math.abs(y);

      final Queue<int[]> queue = new LinkedList<>();
      queue.offer(new int[]{0, 0}); // always starts as (0, 0)

      final Set<String> visited = new HashSet<>();
      visited.add("0,0");

      int moves = 0;
      final int[][] dirs = new int[][]{{2, 1}, {1, 2}, {-2, 1}, {2, -1}, {-1, 2}, {1, -2}, {-1, -2}, {-2, -1}};
      while (!queue.isEmpty()) {
         final int size = queue.size();
         for (int i = 0; i < size; i++) {
            final int[] cell = queue.poll();
            final int currX = cell[0];
            final int currY = cell[1];
            if (currX == x && currY == y) {
               return moves;
            }

            for (int [] dir : dirs) {
               int nextX = currX + dir[0];
               int nextY = currY + dir[1];
               final String point = String.format("%s,%s", nextX, nextY);
               if (nextX < -1 || nextY < -1 || visited.contains(point)) {
                  continue;
               }

               visited.add(point);
               queue.offer(new int[]{nextX, nextY});
            }
         }
         moves++;
      }

      return -1;
   }

   public static void main(String[] args) {
      System.out.println(minKnightMoves(2, 1));
      System.out.println(minKnightMoves(5, 5));
      System.out.println(minKnightMoves(1, 1));
   }
}
