package com.locationlabs.stuff.dropbox;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 7/20/19.
 */
public class PairSongsWithTotalDurDivisibleBy60 {
   private static int numPairsDivisibleBy60(int[] times) {
      if (times == null || times.length == 0) {
         return 0;
      }

      int[] mod = new int[60];
      for (int time : times) {
         mod[time % 60]++;
      }

      int songs = 0;
      songs += mod[0] * (mod[0] - 1) / 2;
      songs += mod[30] * (mod[30] - 1) / 2;
      for (int i = 1; i < 30; i++) {
         songs += mod[i] * mod[60 - i];
      }

      return songs;
   }

   public static void main(String[] args) {
      System.out.println(numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));
      /*System.out.println(numPairsDivisibleBy60(new int[]{60, 60, 60}));*/
      /*System.out.println(20 % 60);
      System.out.println(100 % 60);*/
   }
}
