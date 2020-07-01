package com.locationlabs.stuff.apple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by manjeet.singh on 5/25/20.
 */
public class SubdomainVisitCount {
   private static List<String> subdomainVisits(String[] cpDomains) {
      final List<String> result = new ArrayList<>();

      if (cpDomains == null || cpDomains.length == 0) {
         return result;
      }

      final Map<String, Integer> map = new HashMap<>();
      for (String cpDomain : cpDomains) {
         final int spaceIdx = cpDomain.indexOf(" ");
         final int clicksCount = Integer.parseInt(cpDomain.substring(0, spaceIdx));
         String domain = cpDomain.substring(spaceIdx + 1);
         for (int i = 0; i < domain.length(); i++) {
            if (domain.charAt(i) == '.') {
               String currDomain = domain.substring(i + 1);
               map.put(currDomain, map.getOrDefault(currDomain, 0) + clicksCount);
            }
         }
         map.put(domain, map.getOrDefault(domain, 0) + clicksCount);
      }

      map.keySet().forEach(key -> result.add(map.get(key) + " " + key));

      return result;
   }

   public static void main(String[] args) {
      System.out.println(subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
   }
}
