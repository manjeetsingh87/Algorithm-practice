package com.locationlabs.stuff.facebook;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 8/8/19.
 */
public class FriendsOfAppropriateAges {
   private static int numFriendRequests(int[] ages) {
      if (ages == null || ages.length <= 1) {
         return 0;
      }

      final int[] agesCount = new int[121];
      for (int age : ages) {
         agesCount[age]++;
      }

      int count = 0;
      for (int i = 0; i < 121; i++) {
         if (agesCount[i] == 0) {
            continue;
         }
         for (int j = 0; j < 121; j++) {
            if (agesCount[j] == 0) {
               continue;
            }
            if (isValid(i, j)) {
               count += agesCount[i] * (i == j ? agesCount[j] - 1 : agesCount[j]);
            }
         }
      }

      return count;
   }

   private static boolean isValid(int personA, int personB) {
      return !(personB <= (0.5 * personA + 7) || (personB > personA) || (personB > 100 && personA < 100));
   }

   public static void main(String[] args) {
      System.out.println(numFriendRequests(new int[]{16, 16}));
      System.out.println(numFriendRequests(new int[]{16, 17, 18}));
      System.out.println(numFriendRequests(new int[]{20, 30, 100, 110, 120}));
   }
}
