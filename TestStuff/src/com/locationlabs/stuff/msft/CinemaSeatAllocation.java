package com.locationlabs.stuff.msft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by manjeet.singh on 4/18/20.
 */
public class CinemaSeatAllocation {
   private static int maxNumberOfFamilies(int n, int[][] reservedSeats) {
      if (n < 1) {
         return 0;
      }

      final Map<Integer, Set<Integer>> rowToSeatResMap = new HashMap<>();

      for (int[] row : reservedSeats) {
         if (!rowToSeatResMap.containsKey(row[0])) {
            rowToSeatResMap.put(row[0], new HashSet<>());
         }

         rowToSeatResMap.get(row[0]).add(row[1]);
      }

      System.out.println(rowToSeatResMap);

      int maxSeatsAvailable = 0;

      // These rows do not contain any reservations
      maxSeatsAvailable = (n - rowToSeatResMap.size()) * 2;
      for (Set<Integer> reservations : rowToSeatResMap.values()) {
         boolean isPossible = false;

         // Check first possibility
         if(!reservations.contains(2) &&
                 !reservations.contains(3) &&
                 !reservations.contains(4) &&
                 !reservations.contains(5)) {
            maxSeatsAvailable++;
            isPossible = true;
         }

         // Check first possibility
         if(!reservations.contains(6) &&
                 !reservations.contains(7) &&
                 !reservations.contains(8) &&
                 !reservations.contains(9)) {
            maxSeatsAvailable++;
            isPossible = true;
         }

         // Check middle seats only if first two are not used
         if (!isPossible) {
            if(!reservations.contains(4) &&
                    !reservations.contains(5) &&
                    !reservations.contains(6) &&
                    !reservations.contains(7)) {
               maxSeatsAvailable++;
            }
         }
      }


      return maxSeatsAvailable;
   }

   public static void main(String[] args) {
      System.out.println(maxNumberOfFamilies(3, new int[][]{{1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}}));
      System.out.println(maxNumberOfFamilies(2, new int[][]{{2, 1}, {1, 8}, {2, 6}}));
      System.out.println(maxNumberOfFamilies(4, new int[][]{{4, 3}, {1, 4}, {4, 6}, {1, 7}}));
   }
}
