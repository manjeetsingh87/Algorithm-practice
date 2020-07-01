package com.locationlabs.stuff.msft;

/**
 * Created by manjeet.singh on 4/18/20.
 */
public class StringWithoutThreeIdenticalConsecitiveLetters {
   private static String solution(String S) {
      if (S == null || S.length() < 3) {
         return S;
      }

      final StringBuilder sb = new StringBuilder();
      char[] arr = S.toCharArray();
      sb.append(arr[0]);
      int count = 1;

      for (int i = 1; i < arr.length; i++) {
         if (arr[i] == arr[i - 1]) {
            count++;
         } else {
            count = 1;
         }

         if (count < 3) {
            sb.append(arr[i]);
         }
      }


      return sb.toString();
   }

   public static void main(String[] args) {
      System.out.println(solution("eedaaad"));
      System.out.println(solution("xxxtxxx"));
      System.out.println(solution("aaa"));
      System.out.println(solution("uuuuxaaaaxuu"));
   }
}
