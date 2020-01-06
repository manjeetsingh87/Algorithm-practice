package com.locationlabs.stuff.facebook;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 8/11/19.
 */
public class KnightDialer {
   private static final int MOD = 1000000007;

   private static int knightDialer(int N) {
      if (N < 0) {
         return 0;
      }

      int[][] graph = new int[][]{{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};
      int count = 0;
      int[][] memo = new int[N + 1][10];
      for (int[] num : memo) {
         Arrays.fill(num, -1);
      }

      for (int i = 0; i <= 9; i++) {
         count = (count + dfs(graph, memo, i, N - 1)) % MOD;
      }

      return count;
   }

   private static int dfs(int[][] graph, int[][] memo, int currPos, int N) {
      if (N == 0) {
         return 1;
      }

      if (memo[N][currPos] != -1) {
         return memo[N][currPos];
      }

      int count = 0;
      for (int neighbor : graph[currPos]) {
         count = (count + dfs(graph, memo, neighbor, N - 1)) % MOD;
      }
      memo[N][currPos] = count;
      return count;
   }

   public static void main(String[] args) {
      System.out.println(knightDialer(1));
      System.out.println(knightDialer(2));
      System.out.println(knightDialer(3));
   }
}
