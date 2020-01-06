package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by manjeet.singh on 5/18/19.
 */
public class Twitch {
   public static int solution(String S) {
      int total = 0;
      for (int i = 0; i < S.length(); i++) {
         StringBuilder sb = new StringBuilder();
         Set<Character> set = new HashSet<>();
         int count = 0;
         for (int j = i; j < S.length(); j++) {
            char ch = S.charAt(j);
            sb.append(ch);
            if (set.contains(ch)) {
               count--;
            } else {
               set.add(ch);
               count += sb.length();
            }
            System.out.println(sb);
         }
         total += count;
         System.out.println(set);
      }

      return total;
   }

   private static int countUnique(List<String> list) {
      int count = 0;

      for (String s : list) {
         Set<Character> set = new HashSet<>();
         for (char ch : s.toCharArray()) {
            if (!set.add(ch)) {
               set.remove(ch);
               count--;
            } else {
               count++;
            }
         }
      }

      return count;
   }

   public static void main(String[] args) {
      System.out.println(solution("ACAX"));
   }
}
