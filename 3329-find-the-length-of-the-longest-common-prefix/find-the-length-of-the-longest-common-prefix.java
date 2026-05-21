class Solution {
    class TrieNode {
        TrieNode[] child = new TrieNode[10];
    }
    TrieNode root = new TrieNode();
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        for (int num : arr1) {
            insert(String.valueOf(num));
        }
        int ans = 0;
        for (int num : arr2) {
            ans = Math.max(ans,
                    search(String.valueOf(num)));
        }
        return ans;
    }
    private void insert(String s) {
        TrieNode node = root;
        for (char ch : s.toCharArray()) {
            int idx = ch - '0';
            if (node.child[idx] == null) {
                node.child[idx] = new TrieNode();
            }
            node = node.child[idx];
        }
    }
    private int search(String s) {
        TrieNode node = root;
        int count = 0;
        for (char ch : s.toCharArray()) {
            int idx = ch - '0';
            if (node.child[idx] == null) {
                break;
            }
            count++;
            node = node.child[idx];
        }
        return count;
    }
}