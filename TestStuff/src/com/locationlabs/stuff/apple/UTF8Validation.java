package com.locationlabs.stuff.apple;

/**
 * Created by manjeet.singh on 5/27/20.
 */
public class UTF8Validation {
   private static int[] masks = {128, 64, 32, 16, 8};

   private static boolean validUtf8(int[] data) {
      int len = data.length;
      for (int i = 0; i < len; i ++) {
         int curr = data[i];
         int type = getType(curr);
         if (type == 0) {
            continue;
         }
         if (type > 1 && i + type <= len) {
            while (type-- > 1) {
               if (getType(data[++i]) != 1) {
                  return false;
               }
            }
         } else {
            return false;
         }
      }
      return true;
   }

   private static int getType(int num) {
      for (int i = 0; i < 5; i ++) {
         if ((masks[i] & num) == 0) {
            return i;
         }
      }
      return -1;
   }

   public static void main(String[] args) {
      System.out.println(validUtf8(new int[]{197, 130, 1}));
      System.out.println(validUtf8(new int[]{235, 140, 4}));
   }
}
