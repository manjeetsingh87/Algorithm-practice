package com.locationlabs.stuff.amazon;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by manjeet.singh on 3/26/20.
 */
public class TrafficSignalLightController {
   private AtomicBoolean greenOnRoadA;
   private ReentrantReadWriteLock greenSignalLock;

   public TrafficSignalLightController() {

   }

   public void carArrived(
           int carId,           // ID of the car
           int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
           int direction,       // Direction of the car
           Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
           Runnable crossCar    // Use crossCar.run() to make car cross the intersection
   ) throws InterruptedException {

   }

   private enum Road {
      GREEN(1),
      RED(2);

      private int road;

      private Road(int road) {
         this.road = road;
      }

      private int getRoad() {
         return this.road;
      }
   }
}
