package com.locationlabs.stuff.msft;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by manjeet.singh on 4/12/20.
 */
public class RevealCardsInIncreasingOrder {
   private static int[] deckRevealedIncreasing(int[] deck) {
      if (deck == null || deck.length <= 1) {
         return deck;
      }

      Arrays.sort(deck);
      int n = deck.length;
      final Queue<Integer> queue = new LinkedList<>();

      for (int i = 0; i < n; i++) {
         queue.offer(i);
      }

      int[] result = new int[n];
      for (int i = 0; i < n; i++) {
         result[queue.poll()] = deck[i];
         queue.offer(queue.poll());
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(Arrays.toString(deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7})));
   }
}
