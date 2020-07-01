package com.locationlabs.stuff.msft;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by manjeet.singh on 4/9/20.
 */
public class SnakesAndLadders {
   private static int snakesAndLadders(int[][] board) {
      if (board == null || board.length == 0 || board[0].length == 0) {
         return 0;
      }

      int n = board.length;
      final Queue<Integer> queue = new LinkedList<>();
      boolean[] visited = new boolean[n * n + 1];
      queue.offer(1);
      visited[1] = true;
      int step = 0;

      while (!queue.isEmpty()) {
         int size = queue.size();
         for (int i = 0; i < size; i++) {
            int curr = queue.poll();
            if (curr == n * n) {
               return step;
            }

            for (int j = curr + 1; j <= Math.min(n * n, curr + 6); j++) {
               int[] next = getNextMove(j, n);
               int x = next[0];
               int y = next[1];
               int des = board[x][y] == -1 ? j : board[x][y];

               if (!visited[des]) {
                  visited[des] = true;
                  queue.offer(des);
               }
            }
         }
         step++;
      }

      return -1;
   }

   private static int[] getNextMove(int currPos, int boardSize) {
      int quotient = (currPos - 1) / boardSize;
      int remainder = (currPos - 1) % boardSize;

      int row = boardSize - 1 - quotient;
      int col = quotient % 2 == 0 ? remainder : boardSize - 1 - remainder;
      return new int[]{row, col};
   }

   public static void main(String[] args) {
      int[][] board = {{-1,-1,-1,-1,-1,-1},
                       {-1,-1,-1,-1,-1,-1},
                       {-1,-1,-1,-1,-1,-1},
                       {-1,35,-1,-1,13,-1},
                       {-1,-1,-1,-1,-1,-1},
                       {-1,15,-1,-1,-1,-1}};
      System.out.println(15 / 36);
      System.out.println(15 % 36);
      System.out.println(snakesAndLadders(board));
   }
}
