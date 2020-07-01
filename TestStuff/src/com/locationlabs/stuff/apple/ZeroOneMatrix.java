package com.locationlabs.stuff.apple;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by manjeet.singh on 5/22/20.
 */
public class ZeroOneMatrix {
   private static int[][] updateMatrix(int[][] matrix) {
      if (matrix == null || matrix.length == 0) {
         return matrix;
      }

      final int rows = matrix.length, columns = matrix[0].length;

      final Queue<int[]> queue = new LinkedList<>();
      final boolean[][] visited = new boolean[rows][columns];
      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < columns; j++) {
            if (matrix[i][j] == 0) {
               queue.offer(new int[]{i, j});
               visited[i][j] = true;
            }
         }
      }

      final int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
      while (!queue.isEmpty()) {
         final int[] cell = queue.poll();
         for (int[] dir : dirs) {
            final int row = dir[0] + cell[0];
            final int col = dir[1] + cell[1];

            if (row < 0 || row >= rows || col < 0 || col >= columns || visited[row][col]) {
               continue;
            }

            queue.offer(new int[]{row, col});
            visited[row][col] = true;
            matrix[row][col] = matrix[cell[0]][cell[1]] + 1;
         }
      }

      return matrix;
   }

   public static void main(String[] args) {
      int[][] result = updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
      for (int[] row : result) {
         System.out.println(Arrays.toString(row));
      }
   }
}
