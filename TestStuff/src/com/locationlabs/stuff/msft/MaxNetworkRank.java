package com.locationlabs.stuff.msft;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by manjeet.singh on 4/18/20.
 */
public class MaxNetworkRank {
   private static int maxNetworkRank(int[] A, int[] B, int N) {
      if (A == null || B == null || N <= 0) {
         return 0;
      }

      if (A.length != B.length) {
         return 0;
      }

      int len = A.length;

      final Map<Integer, Set<Integer>> adjMap = new HashMap<>();
      for (int i = 0; i < len; i++) {
         adjMap.computeIfAbsent(A[i],  k-> new HashSet<>()).add(B[i]);
         adjMap.computeIfAbsent(B[i], k -> new HashSet<>()).add(A[i]);
      }

      int maxRank = 0;
      for (int i = 0; i < len; i++) {
         int currRank = adjMap.get(A[i]).size() + adjMap.get(B[i]).size() - 1;
         maxRank = Math.max(maxRank, currRank);
      }

      return maxRank;
   }

   public static void main(String[] args) {
      int[] A = {1, 2, 3, 3};
      int[] B = {2, 3, 1, 4};

      System.out.println(maxNetworkRank(A, B, 4));
   }
}
