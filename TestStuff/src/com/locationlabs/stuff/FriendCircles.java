package com.locationlabs.stuff;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by manjeet.singh on 5/12/19.
 */
public class FriendCircles {
   private static int findCircleNum(int[][] M) {
      if (M == null || M.length == 0) {
         return 0;
      }

      boolean[] visited = new boolean[M.length];
      int count = 0;
      final Queue<Integer> queue = new LinkedList<>();

      for (int i = 0; i < M.length; i++) {
         if (!visited[i]) {
            queue.add(i);
            while (!queue.isEmpty()) {
               int currStudent = queue.remove();
               visited[currStudent] = true;
               for (int j = 0; j < M.length; j++) {
                  if (M[currStudent][j] == 1 && !visited[j]) {
                     queue.add(j);
                  }
               }
            }
            count++;
         }
      }
      return count;
   }

   private static int friendCicles(int[][] M) {
      if (M == null || M.length == 0) {
         return 0;
      }

      int len = M.length;
      int count = 0;
      boolean[] visited = new boolean[len];

      for (int i = 0; i < len; i++) {
         if (!visited[i]) {
            dfs(M, visited, i);
            count++;
         }
      }

      return count;
   }

   private static void dfs(int[][] M, boolean[] visited, int i) {
      for (int j = 0; j < M.length; j++) {
         if (M[i][j] == 1 && !visited[j]) {
            visited[j] = true;
            dfs(M, visited, j);
         }
      }
   }

   public static void main(String[] args) {
      int[][] M = new int[][]{{1,1,0}, {1,1,0}, {0,0,1}};
      System.out.println(findCircleNum(M));
      System.out.println(friendCicles(M));
      System.out.println("-----------------------");
      M = new int[][]{{1,1,0}, {1,1,1}, {0,1,1}};
      System.out.println(findCircleNum(M));
      System.out.println(friendCicles(M));
   }
}
