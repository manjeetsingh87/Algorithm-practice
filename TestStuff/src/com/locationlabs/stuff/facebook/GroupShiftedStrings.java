package com.locationlabs.stuff.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by manjeet.singh on 8/9/19.
 */
public class GroupShiftedStrings {
   private static List<List<String>> groupStrings(String[] strings) {
      final List<List<String>> result = new ArrayList<>();
      if (strings == null || strings.length == 0) {
         return result;
      }

      final Map<String, List<String>> map = new HashMap<>();
      for (String str : strings) {
         int offset = str.charAt(0) - 'a';
         final StringBuilder key = new StringBuilder();
         for (int i = 0; i < str.length(); i++) {
            char ch = (char) (str.charAt(i) - offset);
            if (ch < 'a') {
               ch += 26;
            }
            key.append(ch);
         }

         final List<String> group = map.getOrDefault(key.toString(), new ArrayList<>());
         group.add(str);
         map.put(key.toString(), group);
      }

      for (List<String> group : map.values()) {
         result.add(group);
      }

      return result;
   }
   public static void main(String[] args) {
      System.out.println(groupStrings(new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"}));
   }
}
