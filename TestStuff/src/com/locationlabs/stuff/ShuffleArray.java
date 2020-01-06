package com.locationlabs.stuff;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by manjeet.singh on 5/12/19.
 */
public class ShuffleArray {

   private int[] array;
   private int[] original;

   private final Random rand = new SecureRandom();

   public ShuffleArray(int[] nums) {
      array = nums;
      original = nums.clone();
   }

   /** Resets the array to its original configuration and return it. */
   public int[] reset() {
      array = original;
      original = original.clone();
      return array;
   }

   /** Returns a random shuffling of the array. */
   public int[] shuffle() {
      int len = array.length;
      for (int i = 0; i < len; i++) {
         int j = rand.nextInt(i + 1);
         swap(i, j);
      }
      return array;
   }

   private void swap(int i, int j) {
      int tmp = array[i];
      array[i] = array[j];
      array[j] = tmp;
   }

   public static void main(String[] args) {
      int[] nums = {1,2,3};
      ShuffleArray shuffle = new ShuffleArray(nums);
      System.out.println(Arrays.toString(shuffle.shuffle()));
      System.out.println(Arrays.toString(shuffle.reset()));
      System.out.println(Arrays.toString(shuffle.shuffle()));
   }
}
