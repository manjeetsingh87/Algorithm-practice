package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by manjeet.singh on 5/26/19.
 */
public class AmazonFoodDeliveryProblem {
   private static Set<String> set = new HashSet<>();
   private static int pathSum = Integer.MIN_VALUE;
   private static int minDistance(int numRows, int numColumns, List<List<Integer>> area) {
      if (area == null || numRows <= 0 || numColumns <= 0) {
         return 0;
      }

      int targetRow = 0, targetCol = 0;
      boolean[][] visited = new boolean[numRows][numColumns];
      for (int i = 0; i < numRows; i++) {
         for (int j = 0; j < numColumns; j++) {
            StringBuilder sb = new StringBuilder();
            int currentCost = area.get(i).get(j);
            if (currentCost == 1) {
               dfs(i, j, numRows, numColumns, currentCost, area, visited, sb, "o");
            } else if (area.get(i).get(j) == 9) {
               targetRow = i;
               targetCol = j;
            }
         }
      }

      for (boolean[] visit : visited) {
         System.out.println(Arrays.toString(visit));
      }

      System.out.println(set);
      System.out.println(pathSum);

      /*for (Integer[] obj : truePathSet) {
         System.out.println(Arrays.toString(obj));
      }

      System.out.println(getMinCost(targetRow, targetCol, numRows, numColumns, area, visited));*/
      return 0;
   }

//   private static int getMinCost(int i, int j, int numRows, int numColumns,
//                                 List<List<Integer>> area, boolean[][] visited) {
//      int leftCost = Integer.MIN_VALUE;
//      int rightCost = Integer.MIN_VALUE;
//      int upCost = Integer.MIN_VALUE;
//      int downCost = Integer.MIN_VALUE;
//
//      System.out.println(area);
//
//      if (i > 0 && area.get(i-1).get(j) != 0
//              && truePathSet.contains(new Integer[]{i-1, j})) {
//         upCost = area.get(i-1).get(j);
//      }
//
//      if (i < numRows-1 && area.get(i+1).get(j) != 0
//              && truePathSet.contains(new Integer[]{i+1, j})) {
//         downCost = area.get(i+1).get(j);
//      }
//
//      if (j > 0 && area.get(i).get(j-1) != 0
//              && truePathSet.contains(new Integer[]{i, j-1})) {
//         leftCost = area.get(i).get(j-1);
//      }
//
//      if (j < numColumns-1 && area.get(i).get(j+1) != 0
//              && truePathSet.contains(new Integer[]{i, j+1})) {
//         rightCost = area.get(i).get(j+1);
//      }
//
//      int minHorizontalCost = Math.max(leftCost, rightCost);
//      int minVerticalCost = Math.max(upCost, downCost);
//      return Math.max(minHorizontalCost, minVerticalCost);
//   }

   private static void dfs(int rowStart, int colStart,
                           int numRows, int numCols,
                           int currentCost,
                           List<List<Integer>> area,
                           boolean[][] visited,
                           StringBuilder path,
                           String direction) {
      if (rowStart < 0 || rowStart >= numRows || colStart < 0 ||
              colStart >= numCols ||
              (area.get(rowStart).get(colStart) != 1 && area.get(rowStart).get(colStart) != 9) ||
              visited[rowStart][colStart]) {
         return;
      }

      if (area.get(rowStart).get(colStart) == 9) {
         path.append("t");
         set.add(path.toString());

         pathSum = Math.max(pathSum, currentCost);
         return;
      }

      path.append(direction);
      visited[rowStart][colStart] = true;
      area.get(rowStart).set(colStart, currentCost);
      dfs(rowStart+1, colStart, numRows, numCols, currentCost+1, area, visited, path, "d");
      dfs(rowStart-1, colStart, numRows, numCols, currentCost+1, area, visited, path, "u");
      dfs(rowStart, colStart+1, numRows, numCols, currentCost+1, area, visited, path, "r");
      dfs(rowStart, colStart-1, numRows, numCols, currentCost+1, area, visited, path, "l");
   }

   public static void main(String[] args) {
      List<List<Integer>> area = new ArrayList<>();
      area.add(Arrays.asList(1,1,0));
      area.add(Arrays.asList(1,9,1));
      area.add(Arrays.asList(1,0,1));
      minDistance(3, 3, area);
   }
}
