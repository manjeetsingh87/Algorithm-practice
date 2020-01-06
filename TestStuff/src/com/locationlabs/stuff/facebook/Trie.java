package com.locationlabs.stuff.facebook;

/**
 * Created by manjeet.singh on 8/11/19.
 */
public class Trie {

   private class TrieNode {
      private TrieNode[] children;
      private boolean isWord;

      private TrieNode() {
         children = new TrieNode[26];
         isWord = false;
      }
   }

   private TrieNode root;

   /** Initialize your data structure here. */
   public Trie() {
      root = new TrieNode();
   }

   /** Adds a word into the data structure. */
   public void addWord(String word) {
      TrieNode node = root;
      for (char ch : word.toCharArray()) {
         int idx = ch - 'a';
         if (node.children[idx] == null) {
            node.children[idx] = new TrieNode();
         }
         node = node.children[idx];
      }
      node.isWord = true;
   }

   /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
   public boolean search(String word) {
      return search(root, word, 0);
   }

   private boolean search(TrieNode node, String word, int idx) {
      if (node == null) {
         return false;
      }

      if (idx == word.length()) {
         return node.isWord;
      }

      char ch = word.charAt(idx);
      if (ch == '.') {
         for (int i = 0; i < 26; i++) {
            if (search(node.children[i], word, idx + 1)) {
               return true;
            }
         }
         return false;
      }
      return node.children[ch - 'a'] != null && search(node.children[ch - 'a'], word, idx + 1);
   }

   public static void main(String[] args) {
      Trie trie = new Trie();
      trie.addWord("a");
      trie.addWord("a");
      System.out.println(trie.search("."));
      System.out.println(trie.search("a"));
      System.out.println(trie.search("aa"));
      System.out.println(trie.search("a"));
      System.out.println(trie.search(".a"));
      System.out.println(trie.search("a."));
   }
}
