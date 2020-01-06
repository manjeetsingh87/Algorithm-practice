package com.locationlabs.stuff.dropbox;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Created by manjeet.singh on 7/22/19.
 */
public class GridIllumination {
   public static void main(String[] args) {
      int[] result = gridIllumination(5, new int[][]{{0, 0}, {4, 4}}, new int[][]{{1, 1}, {0, 1}});
      System.out.println(Arrays.toString(result));

      /**
       *
       10
       [[3,4],[6,6],[1,8],[4,5],[8,7],[0,6],[5,2],[1,9]]
       [[7,9],[2,8],[8,6],[6,8],[2,8]]
       */
      /*int[] result2 = gridIllumination(10, new int[][]{{3, 4}, {6, 6}, {1, 8}, {4,5}, {8, 7}, {0, 6}, {5, 2}, {1, 9}},
                                 new int[][]{{7, 9}, {2, 8}, {8, 6}, {6, 8}, {2, 8}});
      System.out.println(Arrays.toString(result2));*/
   }

   private static int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
      final Map<Integer, Integer> rows = new HashMap<>();
      final Map<Integer, Integer> columns = new HashMap<>();
      final Map<Integer, Integer> leftToRightDiags = new HashMap<>();
      final Map<Integer, Integer> rightToLeftDiags = new HashMap<>();
      final Set<Lamp> lampsOn = new HashSet<>();

      processLamps(lamps, rows, columns, leftToRightDiags, rightToLeftDiags, lampsOn);

      int[] ans = new int[queries.length];
      int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}, {0,0}};
      // address queries
      for (int i=0; i<queries.length; i++) {
         int x = queries[i][0];
         int y = queries[i][1];

         ans[i] = isLightOn(rows, columns, leftToRightDiags, rightToLeftDiags, x, y) ? 1 : 0;
         // switch off the lamps, if any
         toggleNearbyLamps(rows, columns, leftToRightDiags, rightToLeftDiags, lampsOn, dirs, x, y);
      }

      return ans;
   }

   private static void processLamps(int[][] lamps, Map<Integer, Integer> rows, Map<Integer, Integer> columns, Map<Integer, Integer> leftToRightDiags, Map<Integer, Integer> rightToLeftDiags, Set<Lamp> lampsOn) {
      for (int[] lamp : lamps) {
         int x = lamp[0];
         int y = lamp[1];
         rows.put(x, rows.getOrDefault(x, 0) + 1);
         columns.put(y, columns.getOrDefault(y, 0) + 1);
         leftToRightDiags.put(x+y, leftToRightDiags.getOrDefault(x+y, 0) + 1);
         rightToLeftDiags.put(x-y, rightToLeftDiags.getOrDefault(x-y, 0) + 1);
         lampsOn.add(new Lamp(x, y));
      }
   }

   private static boolean isLightOn(Map<Integer, Integer> rows,
                                    Map<Integer, Integer> columns,
                                    Map<Integer, Integer> leftToRightDiags,
                                    Map<Integer, Integer> rightToLeftDiags,
                                    int x, int y) {
      return (rows.getOrDefault(x, 0) > 0
              || columns.getOrDefault(y, 0) > 0
              || leftToRightDiags.getOrDefault(x+y, 0) > 0
              || rightToLeftDiags.getOrDefault(x-y, 0) > 0);
   }

   private static void toggleNearbyLamps(Map<Integer, Integer> rows, Map<Integer, Integer> columns, Map<Integer, Integer> leftToRightDiags, Map<Integer, Integer> rightToLeftDiags, Set<Lamp> lampsOn, int[][] dirs, int x, int y) {
      for (int[] dir : dirs) {
         int x1 = x + dir[0];
         int y1 = y + dir[1];
         Lamp lamp = new Lamp(x1, y1);
         if(lampsOn.contains(lamp)){
            // the lamp is on, turn it off, so decrement the count of the lamps
            rows.put(x1, rows.getOrDefault(x1, 1) - 1);
            columns.put(y1, columns.getOrDefault(y1, 1) - 1);
            leftToRightDiags.put(x1 + y1, leftToRightDiags.getOrDefault(x1 + y1, 1) - 1);
            rightToLeftDiags.put(x1 - y1, rightToLeftDiags.getOrDefault(x1 - y1, 1) - 1);
            lampsOn.remove(lamp);
         }
      }
   }

   private static class Lamp {
      int row, col;

      private Lamp(int row, int col) {
         this.row = row;
         this.col = col;
      }

      @Override
      public boolean equals(Object obj) {
         if (this == obj) {
            return true;
         }

         if (obj == null || !(obj instanceof Lamp)) {
            return false;
         }

         Lamp other = (Lamp) obj;
         return this.row == other.row && this.col == other.col;
      }

      @Override
      public int hashCode() {
         return Objects.hash(row, col);
      }

      @Override
      public String toString() {
         return String.format("{%s, %s}", this.row, this.col);
      }
   }
}
