package com.locationlabs.stuff.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 5/19/20.
 */
public class PrisonCellsAfterNDays {
   private static int[] prisonAfterNDays(int[] cells, int N) {
      if (cells == null || cells.length == 0 || N <= 0) {
         return new int[0];
      }

      int[] firstSimulation = new int[8];
      for (int i=1; i<7; i++) {
         firstSimulation[i] = (cells[i-1] == cells[i+1] ? 1 : 0);
      }
      cells = firstSimulation.clone();
      N--;
      int cycle = 1;

      while (N-- > 0) {
         int[] nextSimulation = new int[8];

         for (int i=1; i<7; i++) {
            nextSimulation[i] = (cells[i-1] == cells[i+1] ? 1 : 0);
         }

         if (Arrays.equals(firstSimulation, nextSimulation)) {
            N %= cycle;
         }

         cells = nextSimulation.clone();
         cycle++;
      }

      return cells;
   }

   public static void main(String[] args) {
      System.out.println(Arrays.toString(prisonAfterNDays(new int[]{0,1,0,1,1,0,0,1}, 7)));
      System.out.println(Arrays.toString(prisonAfterNDays(new int[]{1,0,0,1,0,0,1,0}, 1000000000)));
   }
}
