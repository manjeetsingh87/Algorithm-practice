package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manjeet.singh on 7/16/19.
 */
public class TextJustification {
   private static List<String> fullJustify(String[] words, int maxWidth) {
      final List<String> justifiedResult = new ArrayList<>();
      if (words == null || words.length == 0 || maxWidth == 0) {
         return justifiedResult;
      }

      int len = words.length;
      int[][] costMatrix = new int[len][len];


      return justifiedResult;
   }
}
