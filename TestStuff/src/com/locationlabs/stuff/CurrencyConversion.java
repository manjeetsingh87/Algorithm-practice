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
public class CurrencyConversion {
   private static double[] currencyConverter(List<String> currencies, List<List<String>> queries) {
      if (currencies == null || currencies.isEmpty() || queries == null || queries.isEmpty()) {
         return new double[0];
      }

      final Map<String, Map<String, Double>> graph = buildGraph(currencies);

      List<Double> result = new ArrayList<>();
      for (List<String> query : queries) {
         result.add(getRate(graph, new HashSet<>(), query.get(0), query.get(1)));
      }

      return result.stream().mapToDouble(Double::doubleValue).toArray();
   }

   private static double getRate(Map<String, Map<String, Double>> graph, Set<String> visited, String from, String to) {
      if (!graph.containsKey(from)) {
         return -1.0;
      }

      if (graph.get(from).containsKey(to)) {
         return graph.get(from).get(to);
      }

      visited.add(from);
      for (Map.Entry<String, Double> neighbour : graph.get(from).entrySet()) {
         if (!visited.contains(neighbour.getKey())) {
            double conversionRate = getRate(graph, visited, neighbour.getKey(), to);
            if (conversionRate != -1.0) {
               return neighbour.getValue() * conversionRate;
            }
         }
      }

      return -1.0;
   }

   private static Map<String, Map<String, Double>> buildGraph(List<String> currencies) {
      final Map<String, Map<String, Double>> graph = new HashMap<>();

      for (String curreny : currencies) {
         String[] arr = curreny.split("\\s");
         String from = arr[0];
         String to = arr[1];
         double rate = Double.valueOf(arr[2]);

         graph.putIfAbsent(from, new HashMap<>());
         graph.get(from).put(to, rate);
         graph.putIfAbsent(to, new HashMap<>());
         graph.get(to).put(from, 1/rate);
      }
      return graph;
   }

   public static void main(String[] args) {
      List<List<String>> queries = new ArrayList<>();
      queries.add(Arrays.asList("USD", "INR"));
      queries.add(Arrays.asList("INR", "AUD"));
      queries.add(Arrays.asList("AUD", "USD"));
      System.out.println(Arrays.toString(currencyConverter(Arrays.asList("INR USD 0.014", "AUD INR 51.43"), queries)));
   }
}
