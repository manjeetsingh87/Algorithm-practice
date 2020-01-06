package com.locationlabs.stuff;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 12/28/18.
 */
public class AnagramMapping {
   public static void main(String[] args) {
      int[] A = {12, 28, 46, 32, 50};
      int[] B = {50, 12, 32, 46, 28};
      System.out.println(Arrays.toString(anagramMappings(A, B)));
   }

   public static int[] anagramMappings(int[] A, int[] B) {
      final Map<Integer, Integer> indexMap = new HashMap<>();
      for(int i = 0; i < B.length; i++) {
         if(!indexMap.containsKey(B[i])) {
            indexMap.put(B[i], i);
         }
      }

      final int[] result = new int[A.length];
      for(int i = 0; i < A.length; i++) {
         if(indexMap.containsKey(A[i])) {
            result[i] = indexMap.get(A[i]);
         }
      }
      return result;
   }
}
