package com.locationlabs.stuff.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by manjeet.singh on 5/8/20.
 */
public class PartitionLabels {
   private static List<Integer> partitionLabels(String S) {
      List<Integer> result = new ArrayList<>();

      if (S == null || S.isEmpty()) {
         return result;
      }

      final int[] map = new int[26];
      for (int i = 0; i < S.length(); i++) {
         map[S.charAt(i) - 'a'] = i;
      }

      int start = 0, end = 0;
      for (int i = 0; i < S.length(); i++) {
         end = Math.max(end, map[S.charAt(i) - 'a']);
         if (end == i) {
            result.add(end - start + 1);
            start = end + 1;
         }
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
   }
}
