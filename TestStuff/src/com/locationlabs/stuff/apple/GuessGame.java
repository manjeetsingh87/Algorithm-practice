package com.locationlabs.stuff.apple;

/**
 * Created by manjeet.singh on 5/25/20.
 */
public class GuessGame {
   private static int guess(int num) {
      return 0;
   }

   private static int guessGame(int n) {
      int low = 0, high = n;

      while (low <= high) {
         final int mid = low + (high - low) / 2;
         final int guessed = guess(mid);

         if (guessed == 0) {
            return mid;
         }

         if (guessed < 0) {
            high = mid - 1;
         } else {
            low = mid + 1;
         }
      }

      return -1;
   }
}
