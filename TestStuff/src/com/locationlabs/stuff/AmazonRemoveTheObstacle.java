package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by manjeet.singh on 6/2/19.
 */
public class AmazonRemoveTheObstacle {
   private static int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot) {
      if (lot == null || lot.isEmpty() || lot.get(0).get(0) != 1) {
         return -1;
      }

      Queue<int[]> posQueue = new LinkedList<>();
      posQueue.add(new int[]{0,0});
      lot.get(0).set(0, -1);

      int[][] dir = new int[][]{{0,1},{-1,0},{0,-1},{1,0}};
      int dist = 0;

      while (!posQueue.isEmpty()) {
         int s = posQueue.size();
         dist++;
         for (int i = 0; i < s; i++){
            int[] temp = posQueue.poll();
            for(int[] d : dir){
               int x = temp[0] + d[0];
               int y = temp[1] + d[1];

               if(x<0 || x>=numRows || y<0 || y>=numColumns || lot.get(x).get(y)==0 || lot.get(x).get(y) == -1)
                  continue;
               if(lot.get(x).get(y)==9)
                  return dist;
               posQueue.add(new int[]{x,y});
               lot.get(x).set(y, -1);
            }
         }
      }
      return -1;
   }
//
//   public static int bfs(List<List<Integer>> lot, int[][] distMat, int numRows, int numColumns){
//
//      Queue<int[]> posQueue = new LinkedList<>();
//      posQueue.add(new int[]{0,0});
//      distMat[0][0] = 1;
//
//      int[][] dir = new int[][]{{0,1},{-1,0},{0,-1},{1,0}};
//      int dist = 0;
//
//      while (!posQueue.isEmpty()) {
//         int s = posQueue.size();
//         dist++;
//         for (int i = 0; i < s; i++){
//            int[] temp = posQueue.poll();
//            for(int[] d : dir){
//               int x = temp[0] + d[0];
//               int y = temp[1] + d[1];
//
//               if(x<0 || x>=numRows || y<0 || y>=numColumns || lot.get(x).get(y)==0 || distMat[x][y]==1)
//                  continue;
//               if(lot.get(x).get(y)==9)
//                  return dist;
//               posQueue.add(new int[]{x,y});
//               distMat[x][y] = 1;
//            }
//         }
//      }
//      return -1;
//   }

   public static void main(String[] args) {
      List<List<Integer>> lot = new ArrayList<>();
      lot.add(Arrays.asList(1,1,1,1));
      lot.add(Arrays.asList(0,1,1,1));
      lot.add(Arrays.asList(0,1,0,1));
      lot.add(Arrays.asList(1,1,9,1));
      lot.add(Arrays.asList(0,0,1,1));
      System.out.println(removeObstacle(lot.size(), lot.get(0).size(), lot));


      // 1,0,0; 1,0,0; 1,9,1;
      // 1,1,1,1; 0,1,1,1; 0,1,0,1; 1,1,9,1; 0,0,1,1;
   }
}
