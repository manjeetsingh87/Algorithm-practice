package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 5/25/20.
 */
public class FindTwonJudge {
   private static int findJudge(int N, int[][] trust) {
      if (N <= 0) {
         return -1;
      }

      final int[] trustGraph = new int[N + 1];
      for (int[] pair : trust) {
         trustGraph[pair[0]]--;
         trustGraph[pair[1]]++;
      }

      for (int i = 1; i <= N; i++) {
         if (trustGraph[i] == N - 1) {
            return i;
         }
      }

      return -1;
   }

   public static void main(String[] args) {
      System.out.println(findJudge(2, new int[][]{{1, 2}}));
      System.out.println(findJudge(3, new int[][]{{1, 3}, {2, 3}}));
      System.out.println(findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
      System.out.println(findJudge(3, new int[][]{{1, 2}, {2, 3}}));
      System.out.println(findJudge(4, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}));
   }
}
