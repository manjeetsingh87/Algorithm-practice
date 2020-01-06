package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by manjeet.singh on 9/28/19.
 */
public class NumberOfSquarefulPermutations {
   private static int numSquarefulPerms(int[] A) {
      if (A == null || A.length == 0) {
         return 0;
      }

      Arrays.sort(A);
      return backtrack(A, new ArrayList<>(), 0, new boolean[A.length]);
   }

   private static int backtrack(int[] nums, List<Integer> tempList, int result, boolean[] used) {
      if (tempList.size() == nums.length) {
         return result + 1;
      }

      for (int i = 0; i < nums.length; i++) {
         if (used[i]
                 || (i > 0 && nums[i] == nums[i - 1] && used[i - 1])
                 || (!tempList.isEmpty() && !isSquareful(tempList.get(tempList.size() - 1) + nums[i]))) {
            continue;
         }
         used[i] = true;
         tempList.add(nums[i]);
         result = backtrack(nums, tempList, result, used);
         used[i] = false;
         tempList.remove(tempList.size() - 1);
      }
      return result;
   }

   private static boolean isSquareful(int x) {
      int sqrt = (int)Math.sqrt(x);
      return sqrt * sqrt == x;
   }

   public static void main(String[] args) {
      System.out.println(numSquarefulPerms(new int[]{1,17,8}));
      System.out.println(numSquarefulPerms(new int[]{2,2,2}));
   }
}
