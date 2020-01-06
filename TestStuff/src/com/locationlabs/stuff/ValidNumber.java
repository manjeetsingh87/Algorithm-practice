package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 7/13/19.
 */
public class ValidNumber {
   /**
    * If we see [0-9] we reset the number flags
    * We can only see . if we didn't see e or .
    * We can only see e if we didn't see e but we did see a number. We reset numberAfterE flag.
    * We can only see + and - in the beginning and after an e
    * any other character break the validation.
    */
   private static boolean isNumber(String s) {
      if (s == null || s.isEmpty()) {
         return false;
      }

      s = s.trim();
      boolean numberSeen = false;
      boolean pointSeen = false;
      boolean eSeen = false;
      boolean numberAfterE = true;
      for (int i = 0 ; i < s.length(); i++) {
         char ch = s.charAt(i);
         if (ch >= '0' && ch <= '9') {
            numberSeen = true;
            numberAfterE = true;
         } else if (ch == '.') {
            if (eSeen || pointSeen) {
               return false;
            }
            pointSeen = true;
         } else if (ch == 'e') {
            if (eSeen || !numberSeen) {
               return false;
            }
            eSeen = true;
            numberAfterE = false;
         } else if (ch == '+' || ch == '-') {
            if (i != 0 && s.charAt(i - 1) != 'e') {
               return false;
            }
         } else {
            return false;
         }
      }

      return numberSeen && numberAfterE;
   }

   public static void main(String[] args) {
      System.out.println(isNumber("0"));
      System.out.println(isNumber("0.1"));
      System.out.println(isNumber("abc"));
      System.out.println(isNumber("1 abc"));
      System.out.println(isNumber("2e10"));
      System.out.println(isNumber("-90e3"));
      System.out.println(isNumber("  le"));
      System.out.println(isNumber("e3"));
      System.out.println(isNumber("6e-1"));
      System.out.println(isNumber("99e2.5"));
      System.out.println(isNumber("53.5e93"));
      System.out.println(isNumber("--6"));
      System.out.println(isNumber("+-3"));
      System.out.println(isNumber("95a54e53"));
   }
}
