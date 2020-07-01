package com.locationlabs.stuff.amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by manjeet.singh on 5/13/20.
 */
public class RottingOranges {
   private static int orangesRotting(int[][] grid) {
      if (grid == null || grid.length == 0) {
         return 0;
      }

      final int rows = grid.length, columns = grid[0].length;

      final Queue<int[]> queue = new LinkedList<>();
      int freshOranges = 0;
      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < columns; j++) {
            if (grid[i][j] == 2) {
               queue.offer(new int[]{i, j});
            } else if (grid[i][j] == 1) {
               freshOranges++;
            }
         }
      }

      // all oranges are rotten, can't do better
      if (freshOranges == 0) {
         return 0;
      }

      int numMinutesNeeded = 0;
      final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

      while (!queue.isEmpty() && freshOranges > 0) {
         numMinutesNeeded++;
         final int size = queue.size();
         for (int i = 0; i < size; i++) {
            final int[] point = queue.poll();
            for (int[] dir : dirs) {
               int x = dir[0] + point[0];
               int y = dir[1] + point[1];

               // if row or colum overflow or cell is empty (0) or rotten (2), skip
               if (x < 0 || x >= rows || y < 0 || y >= columns || grid[x][y] == 0 || grid[x][y] == 2) {
                  continue;
               }

               grid[x][y] = 2; // mark as rotten
               queue.offer(new int[]{x, y});
               freshOranges--;
            }
         }
      }

      return freshOranges == 0 ? numMinutesNeeded: -1;
   }

   public static void main(String[] args) {
      System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
      System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
   }
}
