package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 7/11/19.
 */
public class BulbSwitcher {
   /**
    * n = 3
    n = 0 [off off off]
    n = 1 [on on on]
    n = 2 [on off on]
    n = 3 [on off off]

    n = 4
    n = 0 [off off off off]
    n = 1 [on on on on]
    n = 2 [on off on off]
    n = 3 [on off off off]
    n = 4 [on off off on]

    n = 6
    n = 0 [off off off off off off]
    n = 1 [on on on on on on]
    n = 2 [on off on off on off]
    n = 3 [on off off off on on]
    n = 4 [on off off on on on]
    n = 5 [on off off on off on]
    n = 6 [on off off on off off]

    n = 14
    n = 0 [off off off off off off off off off off off off off off]
    n = 1 [on on on on on on on on on on on on on on]
    n = 2 [on off on off on off on off on off on off on off]
    n = 3 [on off off off on on on off off off on on on off]
    n = 4 [on off off on on on on on off off on off on off]
    n = 5 [on off off on off on on on off on on off on off]
    n = 6 [on off off on off off on on off on on on on off]
    n = 7 [on off off on off off off on off on on on on on]
    n = 8 [on off off on off off off off off on on on on on]
    n = 9 [on off off on off off off off on on on on on on]
    n = 10 [on off off on off off off off on off on on on on]
    n = 11 [on off off on off off off off on off off on on on]
    n = 12 [on off off on off off off off on off off off on on]
    n = 13 [on off off on off off off off on off off off off on]
    n = 14 [on off off on off off off off on off off off off off]
    */

   private static int bulbSwitcher(int n) {
      if (n <= 0) {
         return 0;
      }
      return (int) Math.floor(Math.sqrt(n));
   }

   public static void main(String[] args) {
      System.out.println(bulbSwitcher(-1));
      System.out.println(bulbSwitcher(4));
      System.out.println(bulbSwitcher(9));
      System.out.println(bulbSwitcher(14));
      System.out.println(bulbSwitcher(16));
      System.out.println(bulbSwitcher(36));
   }
}
