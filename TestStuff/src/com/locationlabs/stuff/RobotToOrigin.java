package com.locationlabs.stuff;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 12/28/18.
 */
public class RobotToOrigin {
   public static void main(String[] args) {
      System.out.println(judgeCircle("RRDD"));
   }

   public static boolean judgeCircle(String moves) {
      if(moves == null || moves.isEmpty()) {
         return false;
      }

      int xAxis = 0, yAxis = 0;
      char[] movesArr = moves.toCharArray();

      for(char move : movesArr) {
         switch (move) {
            case 'U':
               yAxis++;
               break;
            case 'D':
               yAxis--;
               break;
            case 'R':
               xAxis++;
               break;
            case 'L':
               xAxis--;
               break;
         }
      }

      return xAxis == 0 && yAxis == 0;
   }
}
