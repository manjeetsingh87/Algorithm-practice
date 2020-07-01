package com.locationlabs.stuff.msft;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by manjeet.singh on 4/11/20.
 */
public class PacificAtlanticWaterFlow {

   private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

   private static List<List<Integer>> pacificAtlantic(int[][] matrix) {
      List<List<Integer>> result = new LinkedList<>();

      if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
         return result;
      }

      final int rows = matrix.length, columns = matrix[0].length;
      final boolean[][] pacific = new boolean[rows][columns];
      final boolean[][] atlantic = new boolean[rows][columns];

      final Queue<int[]> pacificQueue = new LinkedList<>();
      final Queue<int[]> atlanticQueue = new LinkedList<>();

      // water flowing vertically
      for (int i = 0; i < rows; i++) {
         pacificQueue.offer(new int[]{i, 0});
         atlanticQueue.offer(new int[]{i, columns - 1});
         pacific[i][0] = true;
         atlantic[columns - 1][i] = true;
      }

      // water flowing horizontally
      for (int i = 0; i < columns; i++) {
         pacificQueue.offer(new int[]{0, i});
         atlanticQueue.offer(new int[]{rows - 1, i});
         pacific[0][i] = true;
         atlantic[rows - 1][i] = true;
      }

      bfs(matrix, pacificQueue, pacific, rows, columns);
      bfs(matrix, atlanticQueue, atlantic, rows, columns);

      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < columns; j++) {
            if (pacific[i][j] && atlantic[i][j]) {
               result.add(Arrays.asList(i, j));
            }
         }
      }

      return result;
   }

   private static void bfs(int[][] matrix,
                           Queue<int[]> queue,
                           boolean[][] visited,
                           int rows,
                           int columns) {
      while (!queue.isEmpty()) {
         int[] current = queue.poll();
         for (int[] dir : dirs) {
            int x = current[0] + dir[0];
            int y = current[1] + dir[1];

            if (x < 0 || x >= rows || y < 0 || y >= columns
                    || visited[x][y] || matrix[x][y] < matrix[current[0]][current[1]]) {
               continue;
            }

            visited[x][y] = true;
            queue.offer(new int[]{x, y});
         }
      }
   }

   public static void main(String[] args) {
      int[][] matrix = {{1, 2, 2, 3, 5},
                        {3, 2, 3, 4, 4},
                        {2, 4, 5, 3, 1},
                        {6, 7, 1, 4, 5},
                        {5, 1, 1, 2, 4}};
      System.out.println(pacificAtlantic(matrix));
   }
}
