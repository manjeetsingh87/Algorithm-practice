package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 9/25/18.
 */
public class Main {

   public static void main(String[] args) {
      final ScreenStateDto dto = new ScreenStateDto().noPasscode(Boolean.TRUE);

      System.out.println(ScreenState.valueOf(dto).ordinal());
      System.out.println(ScreenState.valueOf(dto).name());
   }

}
