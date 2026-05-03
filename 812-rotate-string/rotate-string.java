class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        String curr = s;
        for (int i = 0; i < s.length(); i++) {
            if (curr.equals(goal)) return true;
            curr = curr.substring(1) + curr.charAt(0);
        }

        return false;
    }
}