package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manjeet.singh on 9/30/19.
 */
public class WordSearchII {
   private static List<String> findWords(char[][] board, String[] words) {
      final List<String> result = new ArrayList<>();
      if (board == null || board.length == 0 || words == null || words.length == 0) {
         return result;
      }

      TrieNode root = buildTrie(words);
      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[0].length; j++) {
            dfs(board, i, j, root, result);
         }
      }

      return result;
   }

   private static void dfs(char[][] board, int row, int col, TrieNode trie, List<String> result) {
      char ch = board[row][col];
      if (ch == '#' || trie.children[ch - 'a'] == null) {
         return;
      }

      trie = trie.children[ch - 'a'];
      if (trie.word != null) {
         result.add(trie.word);
         trie.word = null;
      }

      board[row][col] = '#';
      if (row > 0) {
         dfs(board, row - 1, col, trie, result);
      }

      if (col > 0) {
         dfs(board, row, col - 1, trie, result);
      }

      if (row < board.length - 1) {
         dfs(board, row + 1, col, trie, result);
      }

      if (col < board[0].length - 1) {
         dfs(board, row, col + 1, trie, result);
      }

      board[row][col] = ch;
   }

   private static class TrieNode {
      TrieNode[] children = new TrieNode[26];
      String word;
   }

   private static TrieNode buildTrie(String[] words) {
      TrieNode root = new TrieNode();
      for (String word : words) {
         TrieNode curr = root;
         for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
               curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
         }
         curr.word = word;
      }
      return root;
   }

   public static void main(String[] args) {
      char[][] board = {{'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'}};
      System.out.println(findWords(board, new String[]{"oath","pea","eat","rain"}));
   }
}
