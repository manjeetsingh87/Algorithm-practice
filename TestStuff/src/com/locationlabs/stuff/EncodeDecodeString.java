package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by manjeet.singh on 6/3/19.
 */
public class EncodeDecodeString {
   private static String encode(List<String> strs) {
      if (strs == null || strs.isEmpty()) {
         return null;
      }

      StringBuilder sb = new StringBuilder();
      for (String str : strs) {
         sb.append(str.length()).append('/').append(str);
      }
      return sb.toString();
   }

   private static List<String> decode(String s) {
      List<String> result = new ArrayList<>();
      if (s == null || s.length() == 0) {
         return result;
      }

      int i = 0;
      while (i < s.length()) {
         int slash = s.indexOf('/', i);
         int size = Integer.valueOf(s.substring(i, slash));
         i = slash + size + 1;
         result.add(s.substring(slash+1, i));
      }

      return result;
   }

   public static void main(String[] args) {
      String encode = encode(Arrays.asList("abc", "cat", "bat"));
      System.out.println(encode);
      List<String> decode = decode(encode);
      System.out.println(decode);

      String encoded = encode(Arrays.asList("Hello", "World"));
      System.out.println(encoded);
      System.out.println(decode(encoded));
   }
}
