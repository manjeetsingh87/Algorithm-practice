package com.locationlabs.stuff;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by manjeet.singh on 12/28/18.
 */
public class UniqueEmailAddresses {

   public static void main(String[] args) {
      final String[] input = {"test.emailalex@leetcode.com","test.e.mailbob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
      System.out.println(numUniqueEmails(input));
   }

   public static int numUniqueEmails(String[] emails) {

      if (emails.length == 0) {
         return 0;
      }

      if (emails.length == 1) {
         return 1;
      }

      final Set<String> uniqueAddresses = new HashSet<>();

      for(String email : emails) {
         int domainIdx = email.indexOf("@");
         final String domain = email.substring(domainIdx);
         uniqueAddresses.add(getLocalName(email.substring(0, domainIdx))+"@"+domain);
      }

      return uniqueAddresses.size();
   }

   private static String getLocalName(String name) {
      if (name.contains("+")) {
         name = name.substring(0, name.indexOf("+"));
      }

      if (name.contains(".")) {
         name = name.replace(".", "");
      }

      return name;
   }
}
