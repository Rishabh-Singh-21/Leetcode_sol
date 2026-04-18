class Solution {
    public int mirrorDistance(int n) {
        String str = String.valueOf(n);
        String rStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            rStr += str.charAt(i);
        }
        int rev = Integer.parseInt(rStr);
        return Math.abs(n - rev);
    }
}