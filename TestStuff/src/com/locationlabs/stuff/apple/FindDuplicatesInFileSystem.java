package com.locationlabs.stuff.apple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by manjeet.singh on 5/22/20.
 */
public class FindDuplicatesInFileSystem {
   private static List<List<String>> findDuplicate(String[] paths) {
      final List<List<String>> result = new ArrayList<>();

      if (paths == null || paths.length == 0) {
         return result;
      }

      final Map<String, List<String>> map = new HashMap<>();
      for (String path : paths) {
         final String[] tmp = path.split("\\s");
         for (int i = 1; i < tmp.length; i++) {
            final String[] contents = tmp[i].split("\\(");
            final String txt = contents[1].substring(0, contents[1].length() - 1);
            map.putIfAbsent(txt, new ArrayList<>());
            map.get(txt).add(tmp[0].concat("/").concat(contents[0]));
         }
      }

      return map.values().stream().filter(value -> value.size() > 1).collect(Collectors.toList());
   }

   public static void main(String[] args) {
      System.out.println(findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"}));
   }
}
