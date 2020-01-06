package com.locationlabs.stuff;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 6/17/19.
 */
public class PourWater {
   private static int[] pourWater(int[] heights, int V, int K) {
      if (heights == null || heights.length == 0 || V <= 0) {
         return heights;
      }

      for (int i = 0 ; i < V; i++) {
         int left = K, right = K;
         while (left > 0 && heights[left - 1] <= heights[left]) {
            left--;
         }
         while (left < K && heights[left + 1] == heights[left]) {
            left++;
         }

         while (right < heights.length-1 && heights[right + 1] <= heights[right]) {
            right++;
         }
         while (right > K && heights[right - 1] == heights[right]) {
            right--;
         }

         if (heights[left] < heights[K]) {
            heights[left]++;
         } else {
            heights[right]++;
         }
      }

      return heights;
   }

   public static void main(String[] args) {
      System.out.println(Arrays.toString(pourWater(new int[]{2,1,1,2,1,2,2}, 4, 3)));
      System.out.println(Arrays.toString(pourWater(new int[]{1,2,3,4}, 2, 2)));
      System.out.println(Arrays.toString(pourWater(new int[]{3,1,3}, 5, 1)));
   }
}
