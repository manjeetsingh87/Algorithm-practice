package com.locationlabs.stuff.facebook;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by manjeet.singh on 8/13/19.
 */
public class ShortestDistanceFromAllBuildings {
   private static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

   private int shortestDistance(int[][] grid) {
      if (grid == null || grid.length == 0) {
         return -1;
      }

      int rows = grid.length, columns = grid[0].length;
      //accumulated distance of each house (1) to each 0
      int[][] distance = new int[rows][columns];
      //count reachable house for each 0
      int[][] reachCount = new int[rows][columns];
      int houseCount = 0;

      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < columns; j++) {
            if (grid[i][j] == 1) {
               houseCount++;
            }
         }
      }

      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < columns; j++) {
            if (grid[i][j] == 1) {
               if (!bfs(grid, distance, reachCount, houseCount, i, j , rows, columns)) {
                  return -1; // found a point from which atleast one house is not reachable
               }
            }
         }
      }

      int minDistance = Integer.MAX_VALUE;
      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < columns; j++) {
            if (grid[i][j] == 0 && reachCount[i][j] == houseCount) {
               minDistance = Math.min(minDistance, distance[i][j]);
            }
         }
      }

      return minDistance == Integer.MAX_VALUE? -1 : minDistance;
   }

   private boolean bfs(int[][] grid, int[][] distance, int[][] reachCount, int houseCount,
                              int row, int col, int rows, int columns) {

      boolean[][] visited = new boolean[rows][columns];
      Queue<int[]> queue = new LinkedList<>();
      queue.offer(new int[]{row, col});
      int level = 0, count = 0;

      while (!queue.isEmpty()) {
         int size = queue.size();
         level++;
         for (int i = 0; i < size; i++) { //level by level
            int[] curr = queue.poll();
            for (int[] dir : dirs) { //visit all neighbors & accumulate distance
               int x = curr[0] + dir[0];
               int y = curr[1] + dir[1];

               if (x < 0 || x >= rows || y < 0 || y >= columns || visited[x][y]) {
                  continue;
               }

               if (grid[x][y] == 0) {
                  distance[x][y] += level;
                  reachCount[x][y]++;
                  queue.offer(new int[]{x, y});
               } else if (grid[x][y] == 1) {
                  count++;
               }
               visited[x][y] = true;
            }
         }
      }

      return count == houseCount;
   }

   public static void main(String[] args) {
      int[][] grid = {{1,0,2,0,1}, {0,0,0,0,0}, {0,0,1,0,0}};
      System.out.println(new ShortestDistanceFromAllBuildings().shortestDistance(grid));
   }
}
