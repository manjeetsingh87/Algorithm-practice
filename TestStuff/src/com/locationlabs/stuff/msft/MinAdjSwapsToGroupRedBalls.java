package com.locationlabs.stuff.msft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by manjeet.singh on 4/18/20.
 */
public class MinAdjSwapsToGroupRedBalls {
   private static final char RED = 'R';

   private static int solution(String S) {
      if (S == null || S.isEmpty()) {
         return 0;
      }

      long minSwaps = 0;
      final List<Integer> redIndices = getRedIndices(S);

      if (redIndices.isEmpty()) {
         return 0;
      }

      final int mid = redIndices.size() / 2;

      for (int i = 0; i < redIndices.size(); i++) {
         minSwaps += Math.abs(redIndices.get(mid) - redIndices.get(i)) - Math.abs(mid - i);
      }

      return (minSwaps > Math.pow(10, 9)) ? -1 : (int)minSwaps;
   }

   private static List<Integer> getRedIndices(String s) {
      final List<Integer> redIndices = new ArrayList<>();
      for (int i = 0; i < s.length(); i++) {
         if (s.charAt(i) == RED) {
            redIndices.add(i);
         }
      }
      return redIndices;
   }

   public static void main(String[] args) {
      System.out.println(solution("WRRWWR"));
      System.out.println(solution("WWRWWWRWR"));
      System.out.println(solution("WWW"));

      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < 100000; i++) {
         sb.append("RW");
      }
      System.out.println(solution(sb.toString()));
   }
}
