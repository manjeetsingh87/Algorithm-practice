package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by manjeet.singh on 5/2/19.
 */
public class KMostFrequestWords {

   private static List<String> topKFrequent(String[] words, int k) {
      if (words == null || words.length == 0) {
         return null;
      }

      final Map<String, Integer> countMap = new HashMap<>();
      for (String word: words) {
         countMap.put(word, countMap.getOrDefault(word, 0) + 1);
      }

      final Queue<String> heap = new PriorityQueue<>(
              (word1, word2) ->
                      countMap.get(word1).equals(countMap.get(word2)) ?
                              word2.compareTo(word1) :
                              countMap.get(word1) - countMap.get(word2));

      for (String word : countMap.keySet()) {
         heap.offer(word);
         if (heap.size() > k) {
            heap.poll();
         }
      }

      LinkedList<String> result = new LinkedList<>();
      while (!heap.isEmpty()) {
         result.addFirst(heap.poll());
      }

      Collections.reverse(result);
      return result;
   }

   public static void main(String[] args) {
      System.out.println(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
      System.out.println(topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
   }
}
