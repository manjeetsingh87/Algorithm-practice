package com.locationlabs.stuff.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by manjeet.singh on 5/16/20.
 */
public class UserWebsiteVisitPattern {
   private static class VisitTuple {
      private String userName;
      private int timestamp;
      private String website;

      protected VisitTuple(final String userName, final int timestamp, final String website) {
         this.userName = userName;
         this.timestamp = timestamp;
         this.website = website;
      }

      @Override
      public String toString() {
         return this.userName + " " + this.timestamp + " " + this.website;
      }
   }

   private static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
      if (username == null || username.length == 0 || timestamp == null || timestamp.length == 0
              || website == null || website.length == 0) {
         return new ArrayList<>();
      }

      final int lenUsers = username.length;
      if (lenUsers != timestamp.length || lenUsers != website.length || website.length != timestamp.length) {
         return new ArrayList<>();
      }

      // convert input data arrays to a list of VisitTuple objects
      final List<VisitTuple> userSiteVisitList = new ArrayList<>();
      for (int i = 0; i < lenUsers; i++) {
         userSiteVisitList.add(new VisitTuple(username[i], timestamp[i], website[i]));
      }

      // sort the list data by timestamp , earliest first
      Collections.sort(userSiteVisitList, (a, b) -> Integer.compare(a.timestamp, b.timestamp));

      //Collect list of websites for each user
      Map<String,List<String>> userWebSitesMap= new HashMap<>();
      for(VisitTuple tuple: userSiteVisitList){
         userWebSitesMap.putIfAbsent(tuple.userName, new ArrayList<>());
         userWebSitesMap.get(tuple.userName).add(tuple.website);
      }

      // now let's generate a 3 sequence for every user in the VisitTuple list
      final Map<List<String>,Integer> seqUserFreMap = new HashMap<>();

      for (List<String> websites : userWebSitesMap.values()) {
         // if size is less than 3, don't consider that list of websites
         if (websites.size() < 3) {
            continue;
         }

         final Set<List<String>> threeSequenceSet = generate3Seq(websites);

         for (List<String> seq : threeSequenceSet) {
            seqUserFreMap.put(seq, seqUserFreMap.getOrDefault(seq, 0) + 1);
         }
      }

      List<String> result = new ArrayList<>();
      int max = 0;
      for (Map.Entry<List<String>, Integer> entry : seqUserFreMap.entrySet()) {
         if (entry.getValue() > max) {
            max = entry.getValue();
            result = entry.getKey();
         } else if (entry.getValue() == max) {
            if (entry.getKey().toString().compareTo(result.toString()) < 0) {
               result = entry.getKey();
            }
         }
      }

      return result;
   }

   private static Set<List<String>> generate3Seq(List<String> websites) {
      final Set<List<String>> setOfListSeq= new HashSet<>();

      for (int i = 0; i < websites.size(); i++) {
         for (int j = i + 1; j < websites.size(); j++) {
            for (int k = j + 1; k < websites.size(); k++) {
               setOfListSeq.add(Arrays.asList(websites.get(i), websites.get(j), websites.get(k)));
            }
         }
      }

      return setOfListSeq;
   }

   public static void main(String[] args) {
      final String[] username = {"joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"};
      final int[] timestamp = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      final String[] websites = {"home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career"};

      System.out.println(mostVisitedPattern(username, timestamp, websites));
   }
}
