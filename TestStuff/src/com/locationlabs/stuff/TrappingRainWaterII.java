package com.locationlabs.stuff;

import java.util.PriorityQueue;

/**
 * Created by manjeet.singh on 9/28/19.
 */
public class TrappingRainWaterII {
   private static class Cell {
      int row;
      int column;
      int height;
      private Cell(int row, int column, int height) {
         this.row = row;
         this.column = column;
         this.height = height;
      }
   }

   private static int trapRainWater(int[][] heights) {
      if (heights == null || heights.length == 0 || heights[0].length == 0) {
         return 0;
      }

      final PriorityQueue<Cell> queue = new PriorityQueue<>((a, b) -> a.height - b.height);
      int rows = heights.length;
      int columns = heights[0].length;
      boolean[][] visited = new boolean[rows][columns];

      // Initially, add all the Cells which are on borders to the queue.
      for (int i = 0; i < rows; i++) {
         visited[i][0] = true;
         visited[i][columns - 1] = true;
         queue.offer(new Cell(i, 0, heights[i][0]));
         queue.offer(new Cell(i, columns - 1, heights[i][columns - 1]));
      }

      for (int i = 0; i < columns; i++) {
         visited[0][i] = true;
         visited[rows - 1][i] = true;
         queue.offer(new Cell(0, i, heights[0][i]));
         queue.offer(new Cell(rows - 1, i, heights[rows - 1][i]));
      }

      // from the borders, pick the shortest cell visited and check its neighbors:
      // if the neighbor is shorter, collect the water it can trap and update its height as its height plus the water trapped
      // add all its neighbors to the queue.
      int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
      int result = 0;

      while (!queue.isEmpty()) {
         final Cell cell = queue.poll();
         for (int[] dir : dirs) {
            int row = cell.row + dir[0];
            int col = cell.column + dir[1];
            if (row < 0 || row >= rows || col < 0 || col >= columns || visited[row][col]) {
               continue;
            }
            visited[row][col] = true;
            result += Math.max(0, cell.height - heights[row][col]);
            queue.offer(new Cell(row, col, Math.max(heights[row][col], cell.height)));
         }
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(trapRainWater(new int[][]{{1,4,3,1,3,2}, {3,2,1,3,2,4}, {2,3,3,2,3,1}}));
   }
}
