package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 5/27/19.
 */
public class WordSearch {
   private static boolean exist(char[][] board, String word) {
      if (board == null || board.length == 0) {
         return false;
      }

      if (word == null || word.length() == 0) {
         return false;
      }

      int numRows = board.length;
      int numColumns = board[0].length;
      boolean[][] visited = new boolean[numRows][numColumns];

      for (int i = 0; i < numRows; i++) {
         for (int j = 0; j < numColumns; j++) {
            if (word.charAt(0) == board[i][j] && searchWord(board, word, visited, 0, i, j, numRows, numColumns)) {
               return true;
            }
         }
      }

      return false;
   }

   private static boolean searchWord(char[][] board, String word,
                                     boolean[][] visited, int wordIdx,
                                     int row, int col, int numRows, int numColumns) {
      if (wordIdx == word.length()) {
         return true;
      }

      if (row < 0 || row >= numRows || col < 0 || col >= numColumns
              || board[row][col] != word.charAt(wordIdx)
              || visited[row][col]) {
         return false;
      }

      visited[row][col] = true;
      if (searchWord(board, word, visited, wordIdx + 1, row - 1, col, numRows, numColumns)
              || searchWord(board, word, visited, wordIdx + 1, row + 1, col, numRows, numColumns)
              || searchWord(board, word, visited, wordIdx + 1, row, col - 1, numRows, numColumns)
              || searchWord(board, word, visited, wordIdx + 1, row, col + 1, numRows, numColumns)) {
         return true;
      }

      visited[row][col] = false;
      return false;
   }

   public static void main(String[] args) {
//      char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
//      System.out.println(exist(board, "ABCCED"));
//      System.out.println(exist(board, "SEE"));
//      System.out.println(exist(board, "ABCB"));

      char[][] board2 = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
      System.out.println(exist(board2, "AAB"));

      char[][] board3 = {{'a'}, {'b'}};
      System.out.println(exist(board3, "ba"));
   }
}
