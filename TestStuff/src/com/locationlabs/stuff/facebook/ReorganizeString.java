package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 8/11/19.
 */
public class ReorganizeString {
   private static String reorganizeString(String S) {
      if(S == null || S.length() <= 1) {
         return S;
      }

      int[] counts = new int[26];
      for (char ch : S.toCharArray()) {
         counts[ch - 'a']++;
      }

      int max = 0, letter = 0;
      for (int i = 0; i < 26; i++) {
         if (max < counts[i]) {
            max = counts[i];
            letter = i;
         }
      }

      // can't re-arrange the string
      if (max > (S.length() + 1) / 2) {
         return "";
      }

      char[] result = new char[S.length()];
      int idx = 0;
      while (counts[letter]-- > 0) {
         result[idx] = (char) (letter + 'a');
         idx += 2;
      }

      for (int i = 0; i < 26; i++) {
         while (counts[i]-- > 0) {
            if (idx >= result.length) {
               idx = 1;
            }
            result[idx] = (char) (i + 'a');
            idx += 2;
         }
      }

      return new String(result);
   }

   private static String rearrangeString(String s, int k) {
      if (s == null || s.isEmpty()) {
         return "";
      }

      final int[] count = new int[26];
      for (char ch : s.toCharArray()) {
         count[ch - 'a']++;
      }

      final int[] valid = new int[26];
      final StringBuilder sb = new StringBuilder();
      for(int index = 0; index < s.length(); index++) {
         int candidatePos = findValidMax(count, valid, index);
         if (candidatePos == -1) {
            return "";
         }
         count[candidatePos]--;
         valid[candidatePos] = index + k;
         sb.append((char)(candidatePos + 'a'));
      }
      return sb.toString();
   }

   private static int findValidMax(int[] count, int[] valid, int index) {
      int max = Integer.MIN_VALUE;
      int candidatePos = -1;
      for (int i = 0; i < count.length; i++) {
         if (count[i] > 0 && count[i] > max && index >= valid[i]) {
            max = count[i];
            candidatePos = i;
         }
      }
      return candidatePos;
   }

   public static void main(String[] args) {
      System.out.println(reorganizeString("aab"));
      System.out.println(reorganizeString("aaab"));

      System.out.println("------------------\n");

      /*System.out.println(rearrangeString("aabbcc", 3));
      System.out.println(rearrangeString("aaabc", 3));*/
      System.out.println(rearrangeString("aaabbc", 2));
   }
}
