class Solution {
    public int[] countBits(int n) {
        int[] c = new int[n+1];
        for(int i=0;i<=n;i++){
            int temp =i;
            int cnt =0;
            while(temp!=0){
                cnt += temp&1;
                temp>>=1;
            }
            c[i] = cnt;
        }
        return c;
    }
}