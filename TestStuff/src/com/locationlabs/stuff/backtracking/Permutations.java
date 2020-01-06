package com.locationlabs.stuff.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Input: [1,2,3]
 * Output: [[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]
 */
public class Permutations {
   private static List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> result = new ArrayList<>();
      backtrack(result, new ArrayList<>(), nums);
      return result;
   }

   private static void backtrack(List<List<Integer>> result, List<Integer> permutation, int[] nums) {
      if (permutation.size() == nums.length) {
         result.add(new ArrayList<>(permutation));
         return;
      }
      for (int num : nums) {
         if (!permutation.contains(num)) {
            permutation.add(num);
            backtrack(result, permutation, nums);
            permutation.remove(permutation.size() - 1);
         }
      }
   }

   private static List<List<Integer>> permuteII(int[] nums) {
      List<List<Integer>> result = new ArrayList<>();
      Arrays.sort(nums);
      backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
      return result;
   }

   private static void backtrack(List<List<Integer>> result, List<Integer> permutation, int[] nums, boolean[] visited) {
      if (permutation.size() == nums.length) {
         result.add(permutation);
         return;
      }

      for (int i = 0; i < nums.length; i++) {
         if (visited[i] || i > 0 && nums[i] == nums[i-1] && visited[i-1]) {
            continue;
         }
         visited[i] = true;
         permutation.add(nums[i]);
         backtrack(result, new ArrayList<>(permutation), nums, visited);
         visited[i] = false;
         permutation.remove(permutation.size()-1);
      }
   }


   public static void main(String[] args) {
//      System.out.println(permute(new int[]{1,2,3}));
      System.out.println(permuteII(new int[]{1,1,3}));
   }
}
