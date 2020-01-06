package com.locationlabs.stuff.facebook;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by manjeet.singh on 8/12/19.
 */
public class RobotRoomCleaner {
   private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

   public void cleanRoom(Robot robot) {
      backtrack(robot, new HashSet<>(), 0, 0, 0);
   }

   private void backtrack(Robot robot, Set<String> visited, int x, int y, int currDir) {
      visited.add(x + "#" + y);
      robot.clean();
      for (int i = 0; i < 4; i++) {
         //moving direction, let's say we are facing right (1), nextDir will be 1 as well.
         int nextDir = (currDir + i) % 4;
         int nextX = x + dirs[nextDir][0];
         int nextY = y + dirs[nextDir][1];
         if (!visited.contains(nextX + "#" + nextY) && robot.move()) {
            backtrack(robot, visited, nextX, nextY, nextDir);
            // go back to start cell
            robot.turnRight();
            robot.turnRight();
            robot.move();
            //go back to the original direction
            robot.turnRight();
            robot.turnRight();
         }
         //because we purposely arranged dx, dy to be clockwise. If we are facing right, we will be facing down in the next iteration
         robot.turnRight();
      }
   }

   private class Robot {

      private void clean() {

      }

      private void turnLeft() {

      }

      private void turnRight() {

      }

      private boolean move() {
         return true;
      }
   }
}
