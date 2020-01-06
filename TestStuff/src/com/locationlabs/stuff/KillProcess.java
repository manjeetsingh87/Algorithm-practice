package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by manjeet.singh on 9/30/19.
 */
public class KillProcess {
   private static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
      final List<Integer> result = new ArrayList<>();
      if (pid == null || pid.isEmpty() || kill <= 0) {
         return result;
      }

      final Map<Integer, Set<Integer>> adjMap = new HashMap<>();
      for (int process : pid) {
         adjMap.put(process, new HashSet<>());
      }

      for (int i = 0; i < pid.size(); i++) {
         final int parentPId = ppid.get(i);
         if (adjMap.containsKey(parentPId)) {
            adjMap.get(ppid.get(i)).add(pid.get(i));
         }
      }

      dfs(adjMap, result, kill);
      return result;
   }

   private static void dfs(Map<Integer, Set<Integer>> adjMap, List<Integer> result, int pid) {
      result.add(pid);
      for (int child : adjMap.get(pid)) {
         dfs(adjMap, result, child);
      }
   }

   public static void main(String[] args) {
      System.out.println(killProcess(Arrays.asList(1, 3, 10, 5), Arrays.asList(3, 0, 5, 3), 5));
   }
}
