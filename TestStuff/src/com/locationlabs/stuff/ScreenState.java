package com.locationlabs.stuff;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 9/25/18.
 */
public enum ScreenState {
   UNKNOWN(new ScreenStateDto().unavailable(Boolean.TRUE)),
   OFF(new ScreenStateDto().screenOff(Boolean.TRUE)),
   ON(new ScreenStateDto().screenOn(Boolean.TRUE)),
   NO_PASSCODE(new ScreenStateDto().noPasscode(Boolean.TRUE));

   private final ScreenStateDto screenState;
   private static final Map<ScreenStateDto, ScreenState> map = new HashMap<>();

   private ScreenState(ScreenStateDto screenState) {
      this.screenState = screenState;
   }

   static {
      for (ScreenState screenState : ScreenState.values()) {
         map.put(screenState.screenState, screenState);
      }
   }

   public ScreenStateDto getScreenState() {
      return screenState;
   }

   public static ScreenState valueOf(ScreenStateDto screenState) {
      return map.get(screenState);
   }
}
