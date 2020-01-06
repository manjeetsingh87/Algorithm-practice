package com.locationlabs.stuff.facebook;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by manjeet.singh on 8/8/19.
 */
public class MineSweeper {
   private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};

   private static char[][] updateBoard(char[][] board, int[] click) {
      if (board == null || board.length == 0) {
         return board;
      }

      if (board[click[0]][click[1]] == 'M') {
         board[click[0]][click[1]] = 'X';
         return board;
      }

      int rows = board.length, columns = board[0].length;
      final Queue<int[]> queue = new LinkedList<>();
      boolean[][] visited = new boolean[rows][columns];

      queue.offer(click);
      visited[click[0]][click[1]] = true;

      while (!queue.isEmpty()) {
         int[] current = queue.poll();
         int row = current[0];
         int col = current[1];
         int mines = numOfMines(board, row, col, rows, columns);

         if (mines == 0) {
            board[row][col] = 'B';
            for (int[] dir : dirs) {
               int x = row + dir[0];
               int y = col + dir[1];

               if (x < 0 || x >= rows || y < 0 || y >= columns
                       || visited[x][y] || board[x][y] != 'E') {
                  continue;
               }
               queue.offer(new int[]{x, y});
               visited[x][y] = true;
            }
         } else {
            board[row][col] = (char) (mines + '0');
         }
      }

      return board;
   }

   private static int numOfMines(char[][] board, int row, int col, int rows, int columns) {
      int mines = 0;
      for (int[] dir : dirs) {
         int x = row + dir[0];
         int y = col + dir[1];

         if (x < 0 || x >= rows || y < 0 || y >= columns || board[x][y] != 'M') {
            continue;
         }

         mines++;
      }
      return mines;
   }
}
