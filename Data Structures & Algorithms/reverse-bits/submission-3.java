class Solution {
    public int reverseBits(int n) {
        int rev = 0;
        for(int i = 0; i < 32; i++){
            if((( n >> i) & 1) == 1){
                rev = rev | (1 << (31 - i));
            }
        }
        return rev;
    }
}
