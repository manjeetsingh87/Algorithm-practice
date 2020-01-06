package com.locationlabs.stuff;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by manjeet.singh on 5/22/19.
 */
public class WordLadder {
   private static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
      if (wordList == null || wordList.isEmpty()) {
         return 0;
      }

      if (beginWord == null || beginWord.length() == 0
              || endWord == null || endWord.length() == 0
                  || !wordList.contains(endWord)) {
         return 0;
      }

      Set<String> visitedWords = new HashSet<>();
      visitedWords.add(beginWord);
      int distance = 1;

      while (!visitedWords.contains(endWord)) {
         Set<String> permuteSet = new HashSet<>();
         for (String word : visitedWords) {
            for (int i = 0; i < word.length(); i++) {
               char[] chars = word.toCharArray();
               for (char ch = 'a'; ch <= 'z'; ch++) {
                  chars[i] = ch;
                  String str = new String(chars);
                  if (wordList.contains(str)) {
                     permuteSet.add(str);
                     wordList.remove(str);
                  }
               }
            }
         }
         if (permuteSet.isEmpty()) {
            return 0;
         }
         distance++;
         visitedWords = permuteSet;
      }

      return distance;
   }

   public static void main(String[] args) {
      List<String> words = Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"});
      Set<String> set = new HashSet<>();
      set.addAll(words);
      System.out.println(ladderLength("hit", "cog", set));
   }
}
