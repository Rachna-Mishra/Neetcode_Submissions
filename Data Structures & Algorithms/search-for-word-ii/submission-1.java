class Solution {
    Trie root;
    int m;
    int n;
    List<String> result;
    public List<String> findWords(char[][] board, String[] words) {
        root = new Trie();
        m = board.length;
        n = board[0].length;
        result = new ArrayList<>();
        int[][] dir = {{0, -1},{0, +1},{+1, 0},{-1, 0}};
        for(int i = 0; i< words.length; i++){
            addInTrie(words[i]);
        }
        Trie p = root;
        for(int i = 0; i< m; i++){
            for(int j = 0; j < n; j++){
                char ch = board[i][j];
                if(p.nodes[ch-'a'] != null){
                    board[i][j] = '#';
                    dfs(board, i, j, p.nodes[ch-'a'], dir, ""+ch);
                    board[i][j] = ch;
                }
            }
        }
        return result;
    }
    public void dfs(char[][] board, int r, int c, Trie p, int[][] dir, String word){
        if(p.eow && !result.contains(word)){
            result.add(word);
        }
        for(int i = 0; i< dir.length; i++){
            int nextRow = r + dir[i][0];
            int nextCol = c + dir[i][1];
           // System.out.print(nextRow+" "+nextCol+" ");
            if((nextRow >= 0 && nextRow < board.length) &&
                (nextCol >= 0 && nextCol < board[0].length)){
                    char ch = board[nextRow][nextCol];
                    if(ch != '#' && p.nodes[ch-'a'] != null){
                        board[nextRow][nextCol] = '#';
                        dfs(board, nextRow, nextCol, p.nodes[ch-'a'], dir, word+ch);
                        board[nextRow][nextCol] = ch;
                    }
            }
        }

    }
    public void addInTrie(String word){
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
}
class Trie{
    Trie[] nodes;
    boolean eow;
    public Trie(){
        nodes = new Trie[26];
        eow = false;
    }
}
