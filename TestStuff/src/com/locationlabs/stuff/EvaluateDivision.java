package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by manjeet.singh on 6/3/19.
 */
public class EvaluateDivision {
   private static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
      Map<String, Map<String, Double>> graph = buildGraph(equations, values);
      double[] result = new double[queries.size()];

      for (int i = 0; i < queries.size(); i++) {
         List<String> query = queries.get(i);
         result[i] = getPathWeight(graph, new HashSet<>(), query.get(0), query.get(1));
      }

      return result;
   }

   private static double getPathWeight(Map<String, Map<String, Double>> graph,
                                       Set<String> visited,
                                       String start,
                                       String end) {
      if (!graph.containsKey(start)) {
         return -1.0;
      }

      if (graph.get(start).containsKey(end)) {
         return graph.get(start).get(end);
      }

      visited.add(start);
      for (Map.Entry<String, Double> neighbour : graph.get(start).entrySet()) {
         if (!visited.contains(neighbour.getKey())) {
            double productWeight = getPathWeight(graph, visited, neighbour.getKey(), end);
            if (productWeight != -1.0) {
               return neighbour.getValue() * productWeight;
            }
         }
      }

      return -1.0;
   }

   private static Map<String, Map<String, Double>> buildGraph(List<List<String>> equations,
                                                              double[] values) {
      Map<String, Map<String, Double>> graph = new HashMap<>();
      for (int i = 0; i < equations.size(); i++) {
         List<String> equation = equations.get(i);
         String node = equation.get(0);
         String vertex = equation.get(1);
         graph.putIfAbsent(node, new HashMap<>());
         graph.get(node).put(vertex, values[i]);
         graph.putIfAbsent(vertex, new HashMap<>());
         graph.get(vertex).put(node, 1/values[i]);
      }

      return graph;
   }

   public static void main(String[] args) {
      List<List<String>> equations = new ArrayList<>();
      equations.add(Arrays.asList("a", "b"));
      equations.add(Arrays.asList("b", "c"));

      List<List<String>> queries = new ArrayList<>();
      queries.add(Arrays.asList("a", "c"));
      queries.add(Arrays.asList("b", "a"));
      queries.add(Arrays.asList("a", "e"));
      queries.add(Arrays.asList("a", "a"));
      queries.add(Arrays.asList("x", "x"));
      System.out.println(Arrays.toString(calcEquation(equations, new double[]{2.0, 3.0}, queries)));
   }
}
