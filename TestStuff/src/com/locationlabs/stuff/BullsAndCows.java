package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 6/17/19.
 */
public class BullsAndCows {
   private static String getHint(String secret, String guess) {
      if (secret == null || secret.length() == 0
              || guess == null || guess.length() == 0) {
         return "";
      }

      int bulls = 0, cows = 0;
      int[] sArr = new int[10];
      int[] gArr = new int[10];
      for (int i = 0 ; i< secret.length(); i++) {
         char secretChar = secret.charAt(i);
         char guessChar = guess.charAt(i);
         if (secretChar == guessChar) {
            bulls++;
         } else {
            sArr[secretChar - '0']++;
            gArr[guessChar - '0']++;
         }
      }

      for (int i = 0; i < 10; i++) {
         cows += Math.min(sArr[i], gArr[i]);
      }

      return bulls + "A" + cows + "B";
   }

   public static void main(String[] args) {
      System.out.println(getHint("1807", "7810"));
      System.out.println(getHint("1123", "0111"));
   }
}
