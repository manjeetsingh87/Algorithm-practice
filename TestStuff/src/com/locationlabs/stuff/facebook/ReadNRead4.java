package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 8/6/19.
 */
public class ReadNRead4 {
   private static int read(char[] buf, int n) {
      int readBytes = 0;
      char[] tempBuf = new char[4];
      boolean endOfFile = false;

      while (readBytes < n && !endOfFile) {
         int currReadBytes = read4(tempBuf);

         if (currReadBytes != 4) {
            endOfFile = true;
         }

         int len = Math.min(currReadBytes, n - readBytes);

         for (int i = 0; i < len; i++) {
            buf[readBytes++] = tempBuf[i];
         }
      }
      return readBytes;
   }

   private static int prevIdx = 0, prevSize = 0;
   private static char[] tempBuf = new char[4];

   private static int readMultipleTimes(char[] buf, int n) {
      int counter = 0;

      while (counter < n) {
         if (prevIdx < prevSize) {
            buf[counter++] = tempBuf[prevIdx++];
         } else {
            prevSize = read4(tempBuf);
            prevIdx = 0;
            if (prevSize == 0) {
               break;
            }
         }
      }

      return counter;
   }

   private static int read4(char[] tempBuf) {
      return 4;
   }
}
