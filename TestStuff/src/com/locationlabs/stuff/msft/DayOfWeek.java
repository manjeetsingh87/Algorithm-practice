package com.locationlabs.stuff.msft;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * Created by manjeet.singh on 3/31/20.
 */
public class DayOfWeek {

   private static String dayOfTheWeek(int day, int month, int year) {
      try {
         validateDay(day);
         validateMonth(month);

         final ZonedDateTime date = LocalDate.of(year, month, day).atStartOfDay(ZoneOffset.UTC);
         return date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.US);
      } catch (Exception e) {
         // add logging message
         return null;
      }
   }

   private static void validateDay(int day) {
      if (day <= 0 || day > 31) {
         throw new IllegalArgumentException(String.format("Invalid day value passed: %s", day));
      }
   }

   private static void validateMonth(int month) {
      if (month <= 0 || month > 12) {
         throw new IllegalArgumentException(String.format("Invalid month value passed: %s", month));
      }
   }

   public static void main(String[] args) {
      System.out.println(dayOfTheWeek(31, 8, 2019));
      System.out.println(dayOfTheWeek(18, 7, 1999));
      System.out.println(dayOfTheWeek(15, 8, 1993));
   }
}
