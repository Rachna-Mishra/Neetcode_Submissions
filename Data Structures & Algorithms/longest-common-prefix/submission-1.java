class Solution {
    int minL = Integer.MAX_VALUE;
    public String longestCommonPrefix(String[] strs) {
        int k = 0;
        String re = "";
        while(true){
            char prev = '\0';
            for(int i = 0; i < strs.length; i++){
                if(k >= strs[i].length()){
                    return re;
                }
                if(prev == '\0'){
                    prev = strs[i].charAt(k);  
                }
                else if(strs[i].charAt(k) != prev){
                    return re;
                }
            }
            re += prev;
            k++;
        }
    }
}