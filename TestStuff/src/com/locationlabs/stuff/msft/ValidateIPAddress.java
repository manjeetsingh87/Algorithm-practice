package com.locationlabs.stuff.msft;

/**
 * Created by manjeet.singh on 4/7/20.
 */
public class ValidateIPAddress {
   private enum IPType {
      IPv4,
      IPv6,
      Neither
   }

   private static String validIPAddress(String IP) {
      if (IP == null || IP.isEmpty()) {
         return IPType.Neither.name();
      }

      if (isIPv4(IP)) {
         return IPType.IPv4.name();
      }

      if (isIPv6(IP)) {
         return IPType.IPv6.name();
      }

      return IPType.Neither.name();
   }

   private static boolean isIPv4(String ip) {
      if (ip.charAt(0) == '.' || ip.charAt(ip.length() - 1) == '.') {
         return false;
      }

      final String[] octets = ip.split("\\.");
      if (octets.length != 4) {
         return false;
      }

      for (String octet : octets) {
         if (octet.isEmpty() || (octet.startsWith("0") && octet.length() > 1)) {
            return false;
         }

         if (!Character.isDigit(octet.charAt(0))) {
            return false;
         }

         try {
            int octectVal = Integer.parseInt(octet);
            if (octectVal < 0 || octectVal > 255) {
               return false;
            }
         } catch (Exception e) {
            return false;
         }
      }
      return true;
   }

   private static boolean isIPv6(String ip) {
      if (ip.charAt(0) == ':' || ip.charAt(ip.length() - 1) == ':') {
         return false;
      }

      final String[] octets = ip.split("\\:");
      if (octets.length != 8) {
         return false;
      }

      for (String octet : octets) {
         if (octet.length() == 0 || octet.length() > 4) {
            return false;
         }

         for (char ch : octet.toCharArray()) {
            if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F')) {
               continue;
            }
            return false;
         }
      }

      return true;
   }

   public static void main(String[] args) {
      System.out.println(validIPAddress("172.16.254.1"));
      System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
      System.out.println(validIPAddress("2001:db8:85a3:0:0:8A2E:0370:7334"));
      System.out.println(validIPAddress("2001:0db8:85a3::8A2E:0370:7334"));
      System.out.println(validIPAddress("256.256.256.256"));
      System.out.println(validIPAddress("12..33.4"));
   }
}
