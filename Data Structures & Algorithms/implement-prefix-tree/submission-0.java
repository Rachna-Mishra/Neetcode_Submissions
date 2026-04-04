class PrefixTree {

    Trie root;
    public PrefixTree(){
        root = new Trie();
    }

    public void insert(String word) {
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
        for(int i = 0; i < word.length(); i++){
            int ch = word.charAt(i) - 'a';
            if(p.nodes[ch] == null){
                return false;
            }
            if(i == word.length()-1 && p.nodes[ch].eow){
                return true;
            }
            p = p.nodes[ch];
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        Trie p = root;
        for(int i = 0; i < prefix.length(); i++){
            int ch = prefix.charAt(i) - 'a';
            if(p.nodes[ch] == null){
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

