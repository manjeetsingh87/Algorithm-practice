package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by manjeet.singh on 3/27/19.
 */
public class SubDomainVisitCount {

   private static List<String> subdomainVisits(String[] cpdomains) {

      final Map<String, Integer> domainMap = new HashMap();

      for (String domain : cpdomains) {
         int spaceIndex = domain.indexOf(' ');
         int numClicks = Integer.valueOf(domain.substring(0, spaceIndex));
         String subDomain = domain.substring(spaceIndex+1, domain.length());
         StringBuilder sb = new StringBuilder(subDomain);
         while(true) {
            domainMap.put(sb.toString(), domainMap.getOrDefault(sb.toString(), 0) + numClicks);
            int dotPos = sb.indexOf(".");
            if (dotPos == -1) {
               break;
            }
            sb.delete(0, dotPos + 1);
         }
      }

      List<String> result = new ArrayList();
      for (String domain : domainMap.keySet()) {
         result.add(domainMap.get(domain) + " " + domain);
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
      System.out.println(subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
   }
}
