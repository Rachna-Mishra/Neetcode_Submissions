class Solution {
    Trie root;
    List<String> result;
    public List<String> wordBreak(String s, List<String> wordDict) {
        root = new Trie();
        for(String str : wordDict)
            addInTrie(str);
        result = new ArrayList<>();
        s=s.trim();
        System.out.println(s);
        checkWordBreakExist(s, "");
        
        return result;  
    }
    public void checkWordBreakExist(String s, String pattern) {
        if(s.length()== 0){
            result.add(pattern.substring(0, pattern.length()-1));
            return;
        }
        for(int i = 0; i < s.length(); i++){
            int ch = s.charAt(i)-'a';
            if(ch < 0 || ch > 25){
                return;
            }
            String first = s.substring(0, i+1);
            String second = s.substring(i+1);
           // System.out.println(first);
            if(search(first)){
                checkWordBreakExist(second, pattern+first+" "); 
            }
        }
    }
    public void addInTrie(String s){
        Trie p = root;
        for(int i = 0; i< s.length(); i++){
            int ch = s.charAt(i)-'a';
            if(p.nodes[ch] == null){
                p.nodes[ch] = new Trie();
            }
            if(i == s.length()-1){
                p.nodes[ch].eow = true;
            }
            p = p.nodes[ch];
        }
    }
    public boolean search(String s){
      //  System.out.println(s);
        Trie p = root;
        for(int i = 0; i< s.length(); i++){
            int ch = s.charAt(i)-'a';
            if(p.nodes[ch] == null){
                return false;
            }
            if(i == s.length()-1 && !p.nodes[ch].eow){
                return false;
            }
            p = p.nodes[ch];
        }
        return true;
    }
}
class Trie{
    Trie[] nodes;
    boolean eow;
    public Trie(){
        nodes = new Trie[26];
        eow = false;
    }
}