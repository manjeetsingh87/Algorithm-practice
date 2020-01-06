package com.locationlabs.stuff;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 7/10/19.
 */
public class FindAndReplaceInString {
   private static String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
      if (S == null || S.isEmpty()) {
         return null;
      }

      final Map<Integer, String[]> map = new HashMap<>();
      for (int i = 0 ; i < indexes.length; i++) {
         map.put(indexes[i], new String[]{sources[i], targets[i]});
      }

      final StringBuilder sb = new StringBuilder();
      for (int i = 0; i < S.length();) {
         char ch = S.charAt(i);
         if (!map.containsKey(i)) {
            sb.append(ch);
            i++;
         } else {
            String[] replacement = map.get(i);
            String src = replacement[0];
            String target = replacement[1];

            if (S.substring(i).startsWith(src)) {
               sb.append(target);
               i += src.length();
            } else {
               sb.append(ch);
               i++;
            }
         }
      }

      return sb.toString();
   }

   public static void main(String[] args) {
      String S = "abcd";
      System.out.println(findReplaceString(S, new int[]{0, 2}, new String[]{"a", "cd"}, new String[]{"eee", "ffff"}));
      System.out.println(findReplaceString(S, new int[]{0, 2}, new String[]{"ab", "ec"}, new String[]{"eee", "ffff"}));
   }
}
