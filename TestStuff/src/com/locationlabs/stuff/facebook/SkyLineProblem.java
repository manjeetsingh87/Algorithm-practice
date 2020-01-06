package com.locationlabs.stuff.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by manjeet.singh on 8/13/19.
 */
public class SkyLineProblem {
   private static List<List<Integer>> getSkyline(int[][] buildings) {
      List<List<Integer>> result = new ArrayList<>();

      if (buildings == null || buildings.length == 0) {
         return result;
      }

      List<int[]> heights = new ArrayList<>();
      for (int[] building : buildings) {
         heights.add(new int[]{building[0], -building[2]});
         heights.add(new int[]{building[1], building[2]});
      }

      Collections.sort(heights, (a, b) -> (a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1])));
      final TreeMap<Integer, Integer> heightMap = new TreeMap<>();
      heightMap.put(0, 1);
      int prevHeight = 0;

      for (int[] height : heights) {
         if (height[1] < 0) {
            Integer count = heightMap.get(-height[1]);
            heightMap.put(-height[1], (count == null ? 1 : count + 1));
         } else {
            Integer count = heightMap.get(height[1]);
            if (count == 1) {
               heightMap.remove(height[1]);
            } else {
               heightMap.put(height[1], count - 1);
            }
         }

         int currHeight = heightMap.lastKey();
         if (prevHeight != currHeight) {
            result.add(Arrays.asList(height[0], currHeight));
            prevHeight = currHeight;
         }
      }

      return result;
   }

   public static void main(String[] args) {
      int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 20}, {19, 24, 8}};
      System.out.println(getSkyline(buildings));
   }
}
