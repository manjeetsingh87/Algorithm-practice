package com.locationlabs.stuff.amazon;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 5/16/20.
 */
public class BoatsToSavePeople {
   private static int numRescueBoats(int[] people, int limit) {
      if (people == null || people.length == 0 || limit <= 0) {
         return 0;
      }

      Arrays.sort(people);
      int i = 0, j = people.length - 1;
      int boats = 0;
      while (i <= j) {
         boats++;
         if (people[i] + people[j]<= limit) {
            i++;
         }
         j--;
      }

      return boats;
   }

   public static void main(String[] args) {
      System.out.println(numRescueBoats(new int[]{1, 2}, 3));
      System.out.println(numRescueBoats(new int[]{3, 2, 2, 1}, 3));
      System.out.println(numRescueBoats(new int[]{3, 5, 3, 4}, 5));
   }
}
