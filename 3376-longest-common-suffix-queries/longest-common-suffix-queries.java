class Solution {
    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int index = -1;
    }
    TrieNode root = new TrieNode();
    String[] wordsContainer;
    public int[] stringIndices(String[] wordsContainer,String[] wordsQuery) {
        this.wordsContainer = wordsContainer;
        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i);
        }
        int[] ans = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i]);
        }
        return ans;
    }
    private void insert(String word, int idx) {
        TrieNode node = root;
        update(node, idx);
        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';
            if (node.child[c] == null) {
                node.child[c] = new TrieNode();
            }
            node = node.child[c];
            update(node, idx);
        }
    }
    private void update(TrieNode node, int idx) {
        if (node.index == -1) {
            node.index = idx;
        }
        else {
            String curr = wordsContainer[node.index];
            String next = wordsContainer[idx];
            if (next.length() < curr.length()|| (next.length() == curr.length()&& idx < node.index)) {
                node.index = idx;
            }
        }
    }
    private int search(String query) {
        TrieNode node = root;
        for (int i = query.length() - 1; i >= 0; i--) {
            int c = query.charAt(i) - 'a';
            if (node.child[c] == null) {
                break;
            }
            node = node.child[c];
        }
        return node.index;
    }
}