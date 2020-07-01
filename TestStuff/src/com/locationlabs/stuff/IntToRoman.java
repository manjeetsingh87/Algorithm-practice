package com.locationlabs.stuff;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by manjeet.singh on 5/12/19.
 */
public class IntToRoman {
   private static final TreeMap<Integer, String> map = new TreeMap<>();
   private static final Map<Character, Integer> romanIntMap = new HashMap<>();

   static {
      map.put(1, "I");
      map.put(4, "IV");
      map.put(5, "V");
      map.put(9, "IX");
      map.put(10, "X");
      map.put(40, "XL");
      map.put(50, "L");
      map.put(90, "XC");
      map.put(100, "C");
      map.put(400, "CD");
      map.put(500, "D");
      map.put(900, "CM");
      map.put(1000, "M");

      romanIntMap.put('I', 1);
      romanIntMap.put('V', 5);
      romanIntMap.put('X', 10);
      romanIntMap.put('L', 50);
      romanIntMap.put('C', 100);
      romanIntMap.put('D', 500);
      romanIntMap.put('M', 1000);
   }

   private static String intToRoman(int num) {
      StringBuilder answer = new StringBuilder();
      while (num != 0) {
         Map.Entry<Integer, String> entry = map.floorEntry(num);
         answer.append(entry.getValue());
         num -= entry.getKey();
      }
      return answer.toString();
   }

   private static int romanToInt(String roman) {
      if (roman == null || roman.length() == 0) {
         return -1;
      }

      int len = roman.length();
      int result = romanIntMap.get(roman.charAt(len-1));

      for (int i = len-2; i >= 0; i--) {
         int currentVal = romanIntMap.get(roman.charAt(i));
         int previousVal = romanIntMap.get(roman.charAt(i+1));
         if (currentVal >= previousVal) {
            result += currentVal;
         } else {
            result -= currentVal;
         }
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(intToRoman(8));
//      System.out.println(romanToInt("CXX"));
//      System.out.println(romanToInt("MCMXCIV"));
   }
}
