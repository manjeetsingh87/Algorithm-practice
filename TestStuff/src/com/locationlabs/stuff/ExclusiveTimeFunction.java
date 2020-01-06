package com.locationlabs.stuff;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by manjeet.singh on 5/12/19.
 */
public class ExclusiveTimeFunction {
   private static int[] exclusiveTime(int n, List<String> logs) {
      int[] result = new int[n];
      Stack<Integer> stack = new Stack<>();

      String[] func = logs.get(0).split(":");
      stack.push(Integer.parseInt(func[0]));
      int prevTime = Integer.parseInt(func[2]);

      for (int i = 1; i < logs.size(); i++) {
         func = logs.get(i).split(":");
         int currTime = Integer.parseInt(func[2]);
         if (func[1].equals("start")) {
            if (!stack.isEmpty()) {
               result[stack.peek()] += currTime - prevTime;
            }
            stack.push(Integer.parseInt(func[0]));
            prevTime = currTime;
         } else {
            int currFuncId = stack.pop();
            result[currFuncId] += currTime - prevTime + 1;
            prevTime = currTime + 1;
         }
      }

      return result;
   }

   public static void main(String[] args) {
      List<String> logs = Arrays.asList(new String[]{"0:start:0","1:start:2","1:end:5","0:end:6"});
      System.out.println(Arrays.toString(exclusiveTime(2, logs)));
   }
}
