package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by manjeet.singh on 5/27/19.
 */
public class RepeatingDNASequence {
   private static List<String> findRepeatedDnaSequences(String s) {
      if (s == null || s.length() == 0) {
         return new ArrayList<>();
      }

      Set<String> sequenceSet = new HashSet<>();
      Set<String> result = new HashSet<>();

      for (int i = 0; i < s.length() - 9; i++) {
         String dnaSequence = s.substring(i, i+10);
         if (!sequenceSet.add(dnaSequence)) {
            result.add(dnaSequence);
         }
      }
      System.out.println(sequenceSet);
      return new ArrayList<>(result);
   }

   public static void main(String[] args) {
      System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));
   }
}
