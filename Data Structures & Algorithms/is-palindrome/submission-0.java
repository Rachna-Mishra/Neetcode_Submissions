class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while(i <= j){
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            System.out.println(c1+" "+c2);
            if(!Character.isLetterOrDigit(c1)){
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(c2)){
                j--;
                continue;
            }
            if(c1 != c2){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
