package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by manjeet.singh on 9/26/19.
 */
public class Triangle {
   private static int minimumTotal(List<List<Integer>> triangle) {
      final int[] dp = new int[triangle.size() + 1];

      for (int i = triangle.size() - 1; i >= 0; i--) {
         for (int j = 0; j < triangle.get(i).size(); j++) {
            dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
         }
      }

      return dp[0];
   }

   public static void main(String[] args) {
      final List<List<Integer>> triangles = new ArrayList<>();
      triangles.add(Arrays.asList(2));
      triangles.add(Arrays.asList(3, 4));
      triangles.add(Arrays.asList(6, 5, 7));
      triangles.add(Arrays.asList(4, 1, 8, 3));
      System.out.println(minimumTotal(triangles));
   }
}
