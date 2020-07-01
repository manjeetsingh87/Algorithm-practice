package com.locationlabs.stuff.amazon;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by manjeet.singh on 5/16/20.
 */
public class PathWithMaxMinValue {
   private static class Cell {
      private int row, col, val;

      protected Cell(int row, int col, int val) {
         this.row = row;
         this.col = col;
         this.val = val;
      }
   }

   private static final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

   private static int maximumMinimumPath(int[][] A) {
      if (A == null || A.length == 0) {
         return -1;
      }

      final int rows = A.length, columns = A[0].length;
      final PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.val, a.val));
      final boolean[][] visited = new boolean[rows][columns];

      pq.offer(new Cell(0, 0, A[0][0]));
      visited[0][0] = true;

      int min = A[0][0];

      while (!pq.isEmpty()) {
         final Cell cell = pq.poll();

         min = Math.min(min, cell.val);

         if (cell.row == rows - 1 && cell.col == columns - 1) {
            return min;
         }

         for (int[] dir : dirs) {
            final int nextRow = dir[0] + cell.row;
            final int nextCol = dir[1] + cell.col;

            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= columns || visited[nextRow][nextCol]) {
               continue;
            }

            pq.offer(new Cell(nextRow, nextCol, A[nextRow][nextCol]));
            // mark this current as visited
            visited[nextRow][nextCol] = true;
         }
      }

      return -1;
   }

   public static void main(String[] args) {
      System.out.println(maximumMinimumPath(new int[][]{{5, 4, 5}, {1, 2, 6}, {7, 4, 6}}));

      System.out.println(maximumMinimumPath(new int[][]{{2, 2, 1, 2, 2, 2}, {1, 2, 2, 2, 1, 2}}));

      System.out.println(maximumMinimumPath(new int[][]{{3,4,6,3,4}, {0,2,1,1,7}, {8,8,3,2,7}, {3,2,4,9,8}, {4,1,2,0,0}, {4,6,5,4,3}}));
   }
}
