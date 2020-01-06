package com.locationlabs.stuff;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by manjeet.singh on 1/15/19.
 */
public class UniqueMorseCodes {
   final static Map<Character, String> morseCodeMap= new HashMap<>();

   static {
      final String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
      int ascii = 97;
      for (int i = 0; i < codes.length; i++) {
         morseCodeMap.put((char)ascii++, codes[i]);
      }
   }

   public static void main(String[] args) {
      final String[] words = {"gin", "zen", "gig", "msg"};
      System.out.println(uniqueMorseRepresentations(words));
   }


   public static int uniqueMorseRepresentations(String[] words) {
      final Set<String> codes = new HashSet<>();

      for (String word : words) {
         codes.add(getMorseCode(word));
      }

      return codes.size();
   }

   private static String getMorseCode(String word) {
      StringBuilder morseCode= new StringBuilder();

      for(Character c : word.toCharArray()) {
         morseCode.append(morseCodeMap.get(c));
      }

      return morseCode.toString();
   }
}
