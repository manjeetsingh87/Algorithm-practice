package com.locationlabs.stuff.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by manjeet.singh on 5/11/20.
 */
public class SearchSugegstionSystem {
   private static List<List<String>> suggestedProducts(String[] products, String searchWord) {
      if (products == null || products.length == 0 ||  searchWord == null || searchWord.isEmpty()) {
         return new ArrayList<>();
      }

      final TreeMap<String, Integer> productMap = new TreeMap<>();
      Arrays.sort(products);
      for (int i = 0; i < products.length; i++) {
         productMap.put(products[i], i);
      }

      final List<String> productsList = Arrays.asList(products);
      List<List<String>> result = new ArrayList<>();
      String key = "";

      for (char ch : searchWord.toCharArray()) {
         key += ch;
         final String ceil = productMap.ceilingKey(key);
         final String floor = productMap.floorKey(key + '~');

         if (ceil == null || floor == null) {
            break;
         }

         result.add(productsList.subList(productMap.get(ceil), Math.min(productMap.get(ceil) + 3, productMap.get(floor) + 1)));
      }

      while (result.size() < searchWord.length()) {
         result.add(new ArrayList<>());
      }

      return result;
   }

   private static List<List<String>> suggestedProductsApproachII(String[] products, String searchWord) {
      if (products == null || products.length == 0 ||  searchWord == null || searchWord.isEmpty()) {
         return new ArrayList<>();
      }

      Arrays.sort(products);

      List<List<String>> result = new ArrayList<>();
      String key = "";

      for (char ch : searchWord.toCharArray()) {
         final List<String> curr = new ArrayList<>();
         key += ch;

         int searchIdx = Arrays.binarySearch(products, key);
         if (searchIdx < 0) {
            searchIdx = ~searchIdx;
         }
         for (int idx = searchIdx; idx < Math.min(products.length, searchIdx + 3); idx++) {
            if (products[idx].startsWith(key)) {
               curr.add(products[idx]);
            }
         }

         result.add(curr);
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(suggestedProductsApproachII(new String[]{"mobile","mouse","moneypot","monitor","mousepad"}, "mouse"));
      System.out.println(suggestedProductsApproachII(new String[]{"havana"}, "havana"));
      System.out.println(suggestedProductsApproachII(new String[]{"bags","baggage","banner","box","cloths"}, "bags"));
      System.out.println(suggestedProductsApproachII(new String[]{"havana"}, "tatiana"));
   }
}
