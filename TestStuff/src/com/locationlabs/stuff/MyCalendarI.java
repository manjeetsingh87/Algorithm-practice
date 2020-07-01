package com.locationlabs.stuff;

import java.util.TreeMap;

/**
 * Created by manjeet.singh on 9/24/19.
 */
public class MyCalendarI {
   private final TreeMap<Integer, Integer> calendar;

   public MyCalendarI() {
      this.calendar = new TreeMap<>();
   }

   public boolean book(int start, int end) {
      final Integer floorKey = calendar.floorKey(start);
      if (floorKey != null && calendar.get(floorKey) > start) {
         return false;
      }

      final Integer ceilKey = calendar.ceilingKey(start);
      if (ceilKey != null && ceilKey < end) {
         return false;
      }
      calendar.put(start, end);
      return true;
   }

   public static void main(String[] args) {
      final MyCalendarI calendar = new MyCalendarI();
      System.out.println(calendar.book(10, 20));
      System.out.println(calendar.book(15, 25));
      System.out.println(calendar.book(20, 28));
   }
}
