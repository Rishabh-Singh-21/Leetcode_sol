class Solution {
    public int totalWaviness(int num1, int num2) {
        long ans = 0;
        for (int num = num1; num <= num2; num++) {
            String s = String.valueOf(num);
            if (s.length() < 3) {
                continue;
            }
            int waviness = 0;
            for (int i = 1; i < s.length() - 1; i++) {
                char left = s.charAt(i - 1);
                char curr = s.charAt(i);
                char right = s.charAt(i + 1);
                if (curr > left && curr > right) {
                    waviness++;
                }
                else if (curr < left && curr < right) {
                    waviness++;
                }
            }
            ans += waviness;
        }
        return (int) ans;
    }
}