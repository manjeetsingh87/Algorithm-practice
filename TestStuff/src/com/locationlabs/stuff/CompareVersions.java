package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 10/7/19.
 */
public class CompareVersions {
   private static int compareVersion(String version1, String version2) {
      if ((version1 == null && version2 == null)
              || (version1.isEmpty() && version2.isEmpty())) {
         return 0;
      }

      String[] v1 = version1.split("\\.");
      String[] v2 = version2.split("\\.");
      int len = Math.max(v1.length, v2.length);
      for (int i = 0; i < len; i++) {
         final Integer v1Int = i < v1.length ? Integer.parseInt(v1[i]) : 0;
         final Integer v2Int = i < v2.length ? Integer.parseInt(v2[i]) : 0;
         final int cmp = v1Int.compareTo(v2Int);
         if (cmp != 0) {
            return cmp;
         }
      }
      return 0;
   }

   public static void main(String[] args) {
      System.out.println(compareVersion("0.1", "1.1"));
      System.out.println(compareVersion("1.0.1", "1"));
      System.out.println(compareVersion("7.5.2.4", "7.5.3"));
      System.out.println(compareVersion("1.01", "1.001"));
      System.out.println(compareVersion("1.0", "1.0.0"));
   }
}
