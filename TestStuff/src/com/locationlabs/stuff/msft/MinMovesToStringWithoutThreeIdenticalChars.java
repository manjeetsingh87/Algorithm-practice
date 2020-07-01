package com.locationlabs.stuff.msft;

/**
 * Created by manjeet.singh on 4/18/20.
 */
public class MinMovesToStringWithoutThreeIdenticalChars {
   private static final char A = 'a';
   private static final char B = 'b';

   private static int minMoves(String S) {
      if (S == null || S.length() < 3) {
         return 0;
      }

      int aCount = 0, bCount = 0;
      int moves = 0;
      for (char ch : S.toCharArray()) {
         if (ch == A) {
            aCount += 1;
            bCount = 0;
         } else if (ch == B) {
            bCount += 1;
            aCount = 0;
         }

         if (aCount == 3 || bCount == 3) {
            moves++;
            aCount = 0;
            bCount = 0;
         }
      }

      return moves;
   }

   public static void main(String[] args) {
      System.out.println(minMoves("baaaaa"));
      System.out.println(minMoves("aaabb"));
      System.out.println(minMoves("baaabbaabbba"));
   }
}
