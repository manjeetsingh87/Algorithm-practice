package com.locationlabs.stuff;

public class JewelsAndStones {

   public static void main(String[] args) {
      System.out.println(numJewelsInStones("z", "Z"));
   }

   public static int numJewelsInStones(String J, String S) {
      final int[] hash = new int[256];
      for (int i=0; i < S.length(); i++) {
         hash[S.charAt(i)]++;
      }

      int count = 0;
      for (int i=0; i < J.length(); i++) {
         count += hash[J.charAt(i)];
      }

      return count;
      //return (int) S.chars().boxed().filter((J.chars().boxed().collect(Collectors.toSet()))::contains).count();
   }
}
