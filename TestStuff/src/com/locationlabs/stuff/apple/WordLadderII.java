package com.locationlabs.stuff.apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by manjeet.singh on 6/28/20.
 */
public class WordLadderII {
   private static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordsList) {

      Map<String, List<String>> graph = new HashMap<String, List<String>>();
      Set<String> wordSet = new HashSet<>(wordsList);
      buildGraph(beginWord, endWord, graph, wordSet);

      List<List<String>> result = new ArrayList<>();
      dfs(beginWord, endWord, graph, new ArrayList<>(), result);
      return result;
   }

   private static void buildGraph(String beginWord,
                           String endWord,
                           Map<String, List<String>> graph,
                           Set<String> wordSet) {
      final Set<String> visited = new HashSet<>();
      final Set<String> toVisit = new HashSet<>();
      final Queue<String> queue = new LinkedList<>();
      boolean foundEnd = false;

      queue.offer(beginWord);
      toVisit.add(beginWord);

      while(!queue.isEmpty()) {
         visited.addAll(toVisit);
         toVisit.clear();
         int count = queue.size();

         for (int i = 0; i < count; i++) {
            String word = queue.poll();
            List<String> children = getNextLevel(word, wordSet);
            for (String child : children) {
               if (child.equals(endWord)) {
                  foundEnd = true;
               }
               if (!visited.contains(child)) {
                  graph.computeIfAbsent(word, v -> new ArrayList<>()).add(child);
               }
               if (!visited.contains(child) && !toVisit.contains(child)) {
                  queue.offer(child);
                  toVisit.add(child);
               }
            }
         }

         if (foundEnd) {
            break;
         }
      }
   }

   private static List<String> getNextLevel(String word, Set<String> wordSet) {
      List<String> result = new ArrayList<>();
      char[] chs = word.toCharArray();

      for (int i = 0; i < chs.length; i++) {
         for (char c = 'a'; c <= 'z'; c++) {
            if (chs[i] == c) {
               continue;
            }
            char t = chs[i];
            chs[i] = c;
            String target = String.valueOf(chs);
            if (wordSet.contains(target)) {
               result.add(target);
            }
            chs[i] = t;
         }
      }

      return result;
   }

   private static void dfs(String curWord,
                    String endWord,
                    Map<String, List<String>> graph,
                    List<String> path,
                    List<List<String>> result) {
      path.add(curWord);

      if (curWord.equals(endWord)) {
         result.add(new ArrayList<String>(path));
      } else if (graph.containsKey(curWord)) {
         for (String nextWord : graph.get(curWord)) {
            dfs(nextWord, endWord, graph, path, result);
         }
      }

      path.remove(path.size()-1);
   }

   public static void main(String[] args) {
      System.out.println(findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
   }
}
