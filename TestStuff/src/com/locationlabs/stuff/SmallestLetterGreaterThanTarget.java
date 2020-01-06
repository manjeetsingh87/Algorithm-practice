package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 4/29/19.
 */
public class SmallestLetterGreaterThanTarget {
   private static char nextGreatestLetter(char[] letters, char target) {
      if (letters == null || letters.length == 0) {
         return Character.MIN_VALUE;
      }
      int start = 0, end = letters.length-1;

      while (start <= end) {
         final int mid = (start + end)/2;
         if (letters[mid] <= target) {
            start = mid + 1;
         } else {
            end = mid - 1;
         }
      }

      return letters[start%letters.length];
   }

   public static void main(String[] args) {
      System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
      System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
      System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));
      System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'g'));
      System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
      System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'k'));
   }
}
