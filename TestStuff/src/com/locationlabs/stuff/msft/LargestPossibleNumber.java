package com.locationlabs.stuff.msft;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by manjeet.singh on 4/7/20.
 */
public class LargestPossibleNumber {
   private static String largestNumber(int[] nums) {
      if (nums == null || nums.length == 0) {
         return "";
      }

      String[] numsStrs = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
      Arrays.sort(numsStrs, (a , b) -> ((b + a).compareTo(a + b)));

      if (numsStrs[0].equals("0")) {
         return "0";
      }

      return Arrays.stream(numsStrs).map(Object::toString).collect(Collectors.joining(""));
   }

   public static void main(String[] args) {
      System.out.println(largestNumber(new int[]{10, 2}));
      System.out.println(largestNumber(new int[]{3,30,34,5,9}));
   }
}
