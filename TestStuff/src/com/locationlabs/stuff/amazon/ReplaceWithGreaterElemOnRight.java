package com.locationlabs.stuff.amazon;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 3/26/20.
 */
public class ReplaceWithGreaterElemOnRight {
   private static int[] replaceElements(int[] arr) {
      if (arr == null || arr.length == 0) {
         return arr;
      }

      int len = arr.length - 1;
      int currMax = arr[len];
      arr[len] = -1;
      for (int i = len - 1; i >= 0; i--) {
         final int currNum = arr[i];
         arr[i] = currMax;
         currMax = Math.max(currMax, currNum);
      }

      return arr;
   }

   public static void main(String[] args) {
      System.out.println(Arrays.toString(replaceElements(new int[]{17,18,5,4,6,1})));
   }
}
