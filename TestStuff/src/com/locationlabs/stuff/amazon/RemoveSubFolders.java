package com.locationlabs.stuff.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by manjeet.singh on 5/16/20.
 */
public class RemoveSubFolders {
   // Time: O(n * M * log(n))
   // Space: O(1)
   private static List<String> removeSubfolders(String[] folder) {
      if (folder == null || folder.length == 0) {
         return new ArrayList<>();
      }

      final LinkedList<String> result = new LinkedList<>();
      Arrays.sort(folder);
      for (String f : folder) {
         //  need '/' to ensure a parent.
         if (result.isEmpty() || !f.startsWith(result.peekLast() + "/")) {
            result.offer(f);
         }
      }

      return result;
   }

   // time: O(n * m)
   // space: O(n * m)

   private static class TrieNode {
      TrieNode[] children = new TrieNode[27];
      int wordIdx = -1;
   }

   private static List<String> removeSubFoldersWithTrie(String[] folders) {
      if (folders == null || folders.length == 0) {
         return new ArrayList<>();
      }

      TrieNode root = new TrieNode();
      for (int i = 0; i < folders.length; i++) {
         TrieNode curr = root;
         for (char ch : folders[i].toCharArray()) {
            final int idx = ch == '/' ? 26 : ch - 'a';
            if (curr.children[idx] == null) {
               curr.children[idx] = new TrieNode();
            }

            curr = curr.children[idx];
         }
         curr.wordIdx = i;
      }

      return bfs(root, folders);
   }

   private static List<String> bfs(TrieNode root, String[] folders) {
      final List<String> result = new ArrayList<>();
      final Queue<TrieNode> queue = new LinkedList<>();
      queue.offer(root);

      while (!queue.isEmpty()) {
         root = queue.poll();
         if (root.wordIdx >= 0) {
            result.add(folders[root.wordIdx]);
         }

         for (int i = 0; i < 27; i++) {
            if (root.children[i] != null && !(i == 26 && root.wordIdx >= 0)) {
               queue.offer(root.children[i]);
            }
         }
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(removeSubFoldersWithTrie(new String[]{"/a","/a/b","/c/d","/c/d/e","/c/f"}));
      System.out.println(removeSubFoldersWithTrie(new String[]{"/a","/a/b/c","/a/b/d"}));
      System.out.println(removeSubFoldersWithTrie(new String[]{"/a/b/c","/a/b/ca","/a/b/d"}));
   }
}
