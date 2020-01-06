package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;

/**
 * Created by manjeet.singh on 4/25/19.
 */
public class ShortestWordDistance {

   private final Map<String, List<Integer>> map;
   private final Map<Pair<String, String>, Integer> distanceCache;

   public ShortestWordDistance(String[] words) {
      this.distanceCache = new HashMap<>();
      this.map = new HashMap<>();

      for (int i = 0; i < words.length; i++) {
         String currWord = words[i];
         if (!map.containsKey(currWord)) {
            map.put(currWord, new ArrayList<>());
         }

         map.get(currWord).add(i);
      }

   }

   private int shortestDistanceII(String word1, String word2) {
      final Pair<String, String> wordPair = new Pair<>(word1, word2);
      if (distanceCache.containsKey(wordPair)) {
         return distanceCache.get(wordPair);
      }

      List<Integer> word1Indices = map.get(word1);
      List<Integer> word2Indices = map.get(word2);

      int i = 0, j = 0;
      int distance = Integer.MAX_VALUE;

      while (i < word1Indices.size() && j < word2Indices.size()) {
         int d1 = word1Indices.get(i), d2 = word2Indices.get(j);

         if (d1 < d2) {
            distance = Math.min(distance, d2 - d1);
            i++;
         } else {
            distance = Math.min(distance, d1 - d2);
            j++;
         }

      }

      distanceCache.put(wordPair, distance);
      return distance;
   }

   private static int shortestDistanceI(String[] words, String word1, String word2) {
      if (words == null || words.length == 0 ||
              word1 == null || word1.length() == 0 ||
              word2 == null || word2.length() == 0) {
         return 0;
      }

      int distance = Integer.MAX_VALUE;
      int word1Idx = -1, word2Idx = -1;

      for (int i = 0; i < words.length; i++) {
         final String word = words[i];
         if (word.equals(word1)) {
            word1Idx = i;
         } else if (word.equals(word2)) {
            word2Idx = i;
         }

         if (word1Idx > -1 && word2Idx > -1) {
            distance = Math.min(distance, Math.abs(word1Idx - word2Idx));
         }
      }

      return distance;
   }

   private static int shortestWordDistanceIII(String[] words, String word1, String word2) {
      int index1 = -1;
      int index2 = -1;

      int distance = Integer.MAX_VALUE;

      for (int i = 0; i < words.length; i++) {
         if (word1.equals(words[i]) && word1.equals(word2)) {
            index2 = index1;
            index1 = i;
         } else if (word1.equals(words[i])) {
            index1 = i;
         } else if (word2.equals(words[i])) {
            index2 = i;
         }

         if (index1 != -1 && index2 != -1) {
            distance = Math.min(distance, Math.abs(index1 - index2));
         }
      }
      return distance;
   }

   public static void main(String[] args) {
      String[] words = new String[]{"practice", "makes", "perfect", "coding", "makes"};
      System.out.println(shortestDistanceI(words, "coding", "practice"));
      ShortestWordDistance wordDistance = new ShortestWordDistance(words);
      System.out.println(wordDistance.shortestDistanceII("coding", "practice"));
      System.out.println(wordDistance.shortestDistanceII("makes", "coding"));
   }
}
