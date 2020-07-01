package com.locationlabs.stuff.amazon;

/**
 * Created by manjeet.singh on 5/11/20.
 */
public class AngleBetweenHandsOfClock {
   private static double angleClock(int hour, int minutes) {
      final int oneMinAngle = 6;
      final int oneHourAngle = 30;

      final double minutesAngle = oneMinAngle * minutes;
      final double hourAngle = (hour % 12 + minutes / 60.0) * oneHourAngle;

      final double diff = Math.abs(hourAngle - minutesAngle);

      return Math.min(diff, 360 - diff);
   }

   public static void main(String[] args) {
      System.out.println(angleClock(12, 30));
      System.out.println(angleClock(3, 30));
      System.out.println(angleClock(3, 15));
      System.out.println(angleClock(4, 50));
      System.out.println(angleClock(12, 0));
   }
}
