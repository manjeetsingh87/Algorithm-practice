package com.locationlabs.stuff.msft;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manjeet.singh on 4/8/20.
 */
public class RestoreIPAddresses {
   private static List<String> restoreIpAddresses(String s) {
      if (s == null || s.isEmpty()) {
         return new ArrayList<>();
      }

      final List<String> result = new ArrayList<>();
      restore(s, result, "", 0, 0);
      return result;
   }

   private static void restore(String ipString, List<String> result, String restored, int index, int count) {
      if (count > 4) {
         return;
      }

      if (count == 4 && index == ipString.length()) {
         result.add(restored);
         return;
      }

      for (int i = 1; i < 4; i++) {
         if (index + i > ipString.length()) {
            break;
         }

         String curr = ipString.substring(index, index + i);
         if ((curr.charAt(0) == '0' && curr.length() > 1) || Integer.parseInt(curr) > 255) {
            continue;
         }

         restore(ipString, result, (restored + curr + (count == 3 ? "" : ".")), index + i, count + 1);
      }
   }

   public static void main(String[] args) {
      System.out.println(restoreIpAddresses("25525511135"));
   }
}
