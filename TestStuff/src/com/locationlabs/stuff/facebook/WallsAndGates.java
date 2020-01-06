package com.locationlabs.stuff.facebook;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 8/7/19.
 */
public class WallsAndGates {
   private static void wallsAndGates(int[][] rooms) {
      if (rooms == null || rooms.length == 0) {
         return;
      }

      for (int i = 0; i < rooms.length; i++) {
         for (int j = 0; j < rooms[0].length; j++) {
            if (rooms[i][j] == 0) {
               dfs(rooms, i, j, 0);
            }
         }
      }
   }

   private static void dfs(int[][] rooms, int row, int col, int distance) {
      if (row < 0 || row >= rooms.length || col < 0 || col >= rooms[0].length
              || rooms[row][col] == -1 || rooms[row][col] < distance) {
         return;
      }

      rooms[row][col] = distance;
      dfs(rooms, row - 1, col, distance + 1);
      dfs(rooms, row + 1, col, distance + 1);
      dfs(rooms, row, col - 1, distance + 1);
      dfs(rooms, row, col + 1, distance + 1);
   }


   public static void main(String[] args) {
      int[][] rooms = {{Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
              {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
              {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
              {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}};

      wallsAndGates(rooms);

      for (int i = 0; i < rooms.length; i++) {
         System.out.println(Arrays.toString(rooms[i]));
      }
   }
}
