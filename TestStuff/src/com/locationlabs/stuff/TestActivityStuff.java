package com.locationlabs.stuff;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by manjeet.singh on 9/4/18.
 */
public class TestActivityStuff {
   public static void main(String[] args) throws Exception {
      final String fileName = "/Users/manjeet.singh/Downloads/activity_records.csv";
      final BufferedReader br1 = new BufferedReader(new FileReader(new File(fileName)));
      List<DomainCategory> activityList = new ArrayList<>();
      String line;
      while ((line = br1.readLine()) != null) {
         String[] data = line.split(",");
         final String categoryId = data[1].trim();
         activityList.add(new DomainCategory(data[0], categoryId));
      }
      br1.close();

      final Map<String, Map<String, Integer>> categoryWiseActivityMap = getActivityCountMap(activityList);
      System.out.println("categoryWiseActivityMap is: " + categoryWiseActivityMap);
      Map<String, Long> categoryWeightMap = computeCategoryWeightRecord(categoryWiseActivityMap, activityList.size());
      System.out.println("categoryWeightMap is: " + categoryWeightMap);


      final List<DomainWeight> domainWeights = new ArrayList<>();
      domainWeights.add(new DomainWeight("override-0032", 9, 67));
      domainWeights.add(new DomainWeight("override-0042", 74, 67));
      domainWeights.add(new DomainWeight("override-0001", 15, 33));
      domainWeights.add(new DomainWeight("e9edab73-c1b8-4d46-870e-8a3d01eadfa8", 3, 33));

      domainWeights.sort(Comparator.comparingLong(DomainWeight::getCategoryWeightedUsage)
                                   .thenComparingInt(DomainWeight::getDomainWeightedUsage)
                                   .reversed());
      System.out.println(domainWeights);
   }

   private static Map<String, Map<String, Integer>> getActivityCountMap(final List<DomainCategory> activityList) {


      final Map<String, Map<String, Integer>> categoryWiseActivityMap = new HashMap<>();

      // For each activity record, invert it to a map of categoryId by the number of activities
      // that category has been referenced in.
      activityList.forEach(activity -> {
         final String categoryId = activity.getCategoryId();
         final String domainId  = activity.getDomain();
         if (categoryWiseActivityMap.containsKey(categoryId)) {
            final Map<String, Integer> domainMap = categoryWiseActivityMap.get(categoryId);
            if (domainMap.containsKey(domainId)) {
               domainMap.put(domainId, domainMap.get(domainId) + 1);
            } else {
               domainMap.put(domainId, 1);
            }
         } else {
            final Map<String, Integer> domainMap = new HashMap<>();
            domainMap.put(domainId, 1);
            categoryWiseActivityMap.put(categoryId, domainMap);
         }
      });
      return categoryWiseActivityMap;
   }

   /**
    * For each category in the categoryWiseActivityMap, we get the weightedUsage of the activities in that category
    * compared to total activities for this user.
    */
   private static Map<String,Long> computeCategoryWeightRecord(final Map<String, Map<String, Integer>> categoryWiseActivityMap,
                                                               final int activityNum) {

      final Map<String, Long> categoryWeightMap = new HashMap<>();

      categoryWiseActivityMap.forEach((categoryId, categoryActivities) -> {
         final double weightedUsage =
                 (categoryActivities.values().stream()
                         .collect(Collectors.summingInt(Integer::intValue)) * 100) / (double) activityNum;
         categoryWeightMap.put(categoryId, Math.round(weightedUsage));
      });

      return categoryWeightMap;
   }


   public static class DomainCategory {
      private String domain;
      private String categoryId;

      public DomainCategory(final String domain, final String categoryId) {
         this.domain = domain;
         this.categoryId = categoryId;
      }

      @Override
      public String toString() {
         return this.domain + ":" + this.categoryId;
      }

      public String getDomain() {
         return domain;
      }

      public String getCategoryId() {
         return categoryId;
      }
   }

   public static class DomainWeight {

      private final String domain;
      private final int domainWeightedUsage;
      private final long categoryWeightedUsage;

      public DomainWeight(final String domain, final int domainWeightedUsage, final long categoryWeightedUsage) {
         this.domain = domain;
         this.domainWeightedUsage = domainWeightedUsage;
         this.categoryWeightedUsage = categoryWeightedUsage;
      }

      public String getDomain() {
         return domain;
      }

      public int getDomainWeightedUsage() {
         return domainWeightedUsage;
      }

      public long getCategoryWeightedUsage() {
         return categoryWeightedUsage;
      }

      /**
       *
       * @param obj the object to compare
       * @return true if object equals else false
       */
      @Override
      public boolean equals(final Object obj) {
         if ( obj == this) {
            return true;
         }
         if (!(obj instanceof DomainWeight)) {
            return false;
         }

         final DomainWeight other = (DomainWeight) obj;

         final String thisDomain = this.domain;
         final String otherDomain = other.getDomain();

         return thisDomain.equals(otherDomain);
      }

      /**
       *
       * @return computed hashCode value of the domainWeight object. makes use of basic hash implementation.
       */
      @Override
      public int hashCode() {
         return Objects.hash(this.domain, this.domain);
      }

      @Override
      public String toString() {
         return this.domain + ":" + this.domainWeightedUsage;
      }
   }
}
