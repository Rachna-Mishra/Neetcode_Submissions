class Solution {
    Trie root;
    public boolean wordBreak(String s, List<String> wordDict) {
        root = new Trie();
        for(String str : wordDict)
            addInTrie(str);
        HashSet<String> set = new HashSet<>();
        return checkWordBreakExist(s, set);
    }
    public boolean checkWordBreakExist(String s, HashSet<String> set) {
        if(s.length()== 0){
            return true;
        }
        for(int i = 0; i < s.length(); i++){
            String first = s.substring(0, i+1);
            String second = s.substring(i+1);
            if(search(first)){
                if(set.contains(second)){
                    return false;
                }
                if(checkWordBreakExist(second, set)){
                    return true;
                }
                else
                    set.add(s.substring(i+1));
            }
        }
        return false;
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
