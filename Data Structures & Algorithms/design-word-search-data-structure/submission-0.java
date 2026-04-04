class WordDictionary {
    Trie root ;
    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie p = root;
        for(int i = 0; i < word.length(); i++){
            int ch = word.charAt(i) - 'a';
            if(p.nodes[ch] == null){
                p.nodes[ch] = new Trie();
            }
            if(i == word.length()-1){
                p.nodes[ch].eow = true;
            }
            p = p.nodes[ch];
        }
    }

    public boolean search(String word) {
        Trie p = root;
        return searchInDict(word, 0, p);
    }

    public boolean searchInDict(String word, int cur, Trie p){
        
        if(cur == word.length()){
            if(p.eow)
                return true;
            return false;
        }
        char ch = word.charAt(cur);
        if(ch == '.'){
            for(int i = 0; i < 26; i++){
                if(p.nodes[i] != null && searchInDict(word, cur+1, p.nodes[i])){
                    return true;
                }
            }
        }else{
            if(p.nodes[ch-'a'] == null){
                return false;
            }
            return searchInDict(word, cur+1, p.nodes[ch-'a']);
        }
        return false;
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

