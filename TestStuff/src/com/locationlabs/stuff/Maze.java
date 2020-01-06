package com.locationlabs.stuff;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by manjeet.singh on 7/8/19.
 */
public class Maze {
   private static boolean hasPath(int[][] maze, int[] start, int[] destination) {
      if (maze == null || maze.length == 0) {
         return false;
      }

      if (maze[start[0]][start[1]] == 1 || maze[destination[0]][destination[1]] == 1) {
         return false;
      }

      int rows = maze.length, columns = maze[0].length;

      final Queue<int[]> queue = new LinkedList<>();
      queue.offer(start);

      int[][] dirs = new int[][]{{0,1},{-1,0},{0,-1},{1,0}};

      boolean[][] visited = new boolean[rows][columns];
      visited[start[0]][start[1]] = true;

      while (!queue.isEmpty()) {
         int[] currentPos = queue.poll();

         if (Arrays.equals(currentPos, destination)) {
            return true;
         }

         for (int[] dir : dirs) {
            int xPos = currentPos[0];
            int yPos = currentPos[1];
            while (xPos >= 0 && xPos < rows && yPos >= 0
                    && yPos < columns && maze[xPos][yPos] == 0) {
               xPos += dir[0];
               yPos += dir[1];
            }

            xPos -= dir[0];
            yPos -= dir[1];

            if (!visited[xPos][yPos]) {
               visited[xPos][yPos] = true;
               queue.offer(new int[]{xPos, yPos});
            }
         }
      }

      return false;
   }

   private static int shortestDistance(int[][] maze, int[] start, int[] destination) {
      if (maze == null || maze.length == 0) {
         return 0;
      }

      if (maze[start[0]][start[1]] == 1 || maze[destination[0]][destination[1]] == 1) {
         return 0;
      }

      int rows = maze.length, columns = maze[0].length;

      int[][] distance = new int[rows][columns];
      for (int[] dist : distance) {
         Arrays.fill(dist, -1);
      }

      final Queue<int[]> queue = new LinkedList<>();
      queue.offer(start);
      distance[start[0]][start[1]] = 0;

      int[][] dirs = new int[][]{{0,1},{-1,0},{0,-1},{1,0}};

      while (!queue.isEmpty()) {
         int[] currentPos = queue.poll();
         for (int[] dir : dirs) {
            int xPos = currentPos[0];
            int yPos = currentPos[1];
            int count = distance[xPos][yPos];
            while (xPos >= 0 && xPos < rows && yPos >= 0
                    && yPos < columns && maze[xPos][yPos] == 0) {
               xPos += dir[0];
               yPos += dir[1];
               count++;
            }

            xPos -= dir[0];
            yPos -= dir[1];
            count--;

            if (distance[xPos][yPos] == -1 || distance[xPos][yPos] > count) {
               distance[xPos][yPos] = count;
               queue.offer(new int[]{xPos, yPos});
            }
         }
      }

      return distance[destination[0]][destination[1]];
   }

   public static void main(String[] args) {
      int[][] maze = new int[][]{
              {0, 0, 1, 0, 0},
              {0, 0, 0, 0, 0},
              {0, 0, 0, 1, 0},
              {1, 1, 0, 1, 1},
              {0, 0, 0, 0, 0}
      };
      System.out.println(hasPath(maze, new int[]{0, 4}, new int[]{4, 4}));
      System.out.println(shortestDistance(maze, new int[]{0, 4}, new int[]{4, 4}));
   }
}
