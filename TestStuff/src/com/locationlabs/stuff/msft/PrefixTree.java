package com.locationlabs.stuff.msft;

/**
 * Created by manjeet.singh on 4/12/20.
 */
public class PrefixTree {
   private class TrieNode {
      private boolean isWord;
      private TrieNode[] children;

      // constructor
      protected TrieNode() {
         this.children = new TrieNode[26];
      }
   }

   private TrieNode root;

   /** Initialize your data structure here. */
   public PrefixTree() {
      this.root = new TrieNode();
   }

   /** Inserts a word into the trie. */
   public void insert(String word) {
      TrieNode curr = root;
      for (char ch : word.toCharArray()) {
         final int idx = ch - 'a';
         if (curr.children[idx] == null) {
            curr.children[idx] = new TrieNode();
         }
         curr = curr.children[idx];
      }
      curr.isWord = true;
   }

   /** Returns if the word is in the trie. */
   public boolean search(String word) {
      TrieNode curr = root;
      for (char ch : word.toCharArray()) {
         final int idx = ch - 'a';
         if (curr.children[idx] == null) {
            return false;
         }
         curr = curr.children[idx];
      }

      return curr != null && curr.isWord;
   }

   /** Returns if there is any word in the trie that starts with the given prefix. */
   public boolean startsWith(String prefix) {
      TrieNode curr = root;
      for (char ch : prefix.toCharArray()) {
         final int idx = ch - 'a';
         if (curr.children[idx] == null) {
            return false;
         }
         curr = curr.children[idx];
      }

      return curr != null;
   }

   public static void main(String[] args) {
      PrefixTree trie = new PrefixTree();

      trie.insert("apple");
      System.out.println(trie.search("apple"));   // returns true
      System.out.println(trie.search("app"));     // returns false
      System.out.println(trie.startsWith("app")); // returns true
      trie.insert("app");
      System.out.println(trie.search("app"));     // returns true
   }
}
