package com.locationlabs.stuff.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by manjeet.singh on 8/11/19.
 */
public class AccountMerge {
   private static List<List<String>> accountsMerge(List<List<String>> accounts) {
      final List<List<String>> result = new ArrayList<>();

      if (accounts == null || accounts.isEmpty()) {
         return result;
      }

      final Map<String, List<String>> graph = new HashMap<>();
      final Map<String, String> emailToName = new HashMap<>();

      for (List<String> account : accounts) {
         String name = account.get(0);
         for (int i = 1; i < account.size(); i++) {
            final String email = account.get(i);
            if (!graph.containsKey(email)) {
               graph.put(email, new ArrayList<>());
            }

            emailToName.put(email, name);
            if (i == 1) {
               continue;
            }

            final String otherEmail = account.get(i - 1);
            graph.get(email).add(otherEmail);
            graph.get(otherEmail).add(email);
         }
      }

      final Set<String> visited = new HashSet<>();
      for (String email : emailToName.keySet()) {
         List<String> list = new LinkedList<>();
         if (visited.add(email)) {
            dfs(graph, visited, email, list);
            Collections.sort(list);
            list.add(0, emailToName.get(email));
            result.add(list);
         }
      }

      return result;
   }

   private static void dfs(Map<String, List<String>> graph, Set<String> visited, String email, List<String> list) {
      list.add(email);
      graph.get(email).stream().filter(visited::add).forEach(neighbor -> {
         dfs(graph, visited, neighbor, list);
      });
   }


   public static void main(String[] args) {
      final List<List<String>> accounts = new ArrayList<>();
      accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
      accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));
      accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
      accounts.add(Arrays.asList("Mary", "mary@mail.com"));

      System.out.println(accountsMerge(accounts));

   }
}
