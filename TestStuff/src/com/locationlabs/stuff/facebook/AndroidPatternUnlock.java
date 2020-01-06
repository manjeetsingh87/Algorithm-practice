package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 9/28/19.
 */
public class AndroidPatternUnlock {
   private static int numberOfPatterns(int m, int n) {
      int[][] jumps = new int[10][10];
      jumps[1][3] = jumps[3][1] = 2;
      jumps[4][6] = jumps[6][4] = 5;
      jumps[7][9] = jumps[9][7] = 8;
      jumps[1][7] = jumps[7][1] = 4;
      jumps[2][8] = jumps[8][2] = 5;
      jumps[3][9] = jumps[9][3] = 6;
      jumps[1][9] = jumps[9][1] = jumps[3][7] = jumps[7][3] = 5;

      boolean[] visited = new boolean[10];
      int count  = 0;
      count += dfs(1, 1, 0, m, n, jumps, visited) * 4; // 1, 3, 7, 9 are symmetrical
      count += dfs(2, 1, 0, m, n, jumps, visited) * 4; // 2, 4, 6, 8 are symmetrical
      count += dfs(5, 1, 0, m, n, jumps, visited);
      return count;
   }

   private static int dfs(int num, int len, int count, int m, int n, int[][] jumps, boolean[] visited) {
      if (len >= m) {
         count++;
      }

      len++;

      if (len > n) {
         return count;
      }

      visited[num] = true;
      for (int i = 1; i < 10; i++) {
         int jump = jumps[num][i];
         if (!visited[i] && (jump == 0 || visited[jump])) {
            count = dfs(i, len, count, m, n, jumps, visited);
         }
      }
      visited[num] = false;
      return count;
   }

   public static void main(String[] args) {
      System.out.println(numberOfPatterns(1, 1));
   }
}
