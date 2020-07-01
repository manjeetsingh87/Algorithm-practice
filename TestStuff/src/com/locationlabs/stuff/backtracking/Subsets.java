package com.locationlabs.stuff.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by manjeet.singh on 5/14/19.
 */
public class Subsets {
   // given a list of integers, find all possible subsets.
   // eg nums = [1,2,3]
   //output: [[1], [2], [3], [1,2], [1,3], [2,3], [1,2,3], []]
   private static List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> result = new ArrayList<>();
      //Arrays.sort(nums);
      backtrack(result, new ArrayList<>(), nums, 0);
      return result;
   }

   private static void backtrack(List<List<Integer>> result, List<Integer> subset, int[] nums, int start) {
      result.add(new ArrayList<>(subset));
      for (int i = start; i < nums.length; i++) {
         subset.add(nums[i]);
         backtrack(result, new ArrayList<>(subset), nums, i+1);
         subset.remove(subset.size()-1);
      }
   }

   public static void main(String[] args) {
      System.out.println(subsets(new int[]{1, 2, 3}));
   }
}
