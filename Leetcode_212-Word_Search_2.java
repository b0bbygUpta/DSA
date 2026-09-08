// -- Leetcode 212 -- 
// -- Word Search 2 -- 

class TrieNode{
    HashMap<Character,TrieNode> children=new HashMap<Character, TrieNode>();
    String word=null;
    public TrieNode(){};
}

class Solution {
    char[][] fullboard=null;
    ArrayList<String> answer=new ArrayList<String>();

    public List<String> findWords(char[][] board, String[] words) {
        
        TrieNode root=new TrieNode();
        for(String word: words){
            TrieNode node=root;
            for(Character ch: word.toCharArray()){
                if(node.children.containsKey(ch)){
                    node=node.children.get(ch);
                }
                else{
                    TrieNode newNode=new TrieNode();
                    node.children.put(ch,newNode);
                    node=newNode;
                }
            }
            node.word=word;
        }
        this.fullboard=board;
    
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[0].length;col++){
                if(root.children.containsKey(board[row][col])){
                    backtracking(row,col,root);
                }
            }
        }
        return answer;
    }

    public void backtracking(int row, int col, TrieNode parent){
        Character ch=fullboard[row][col];
        TrieNode curr=parent.children.get(ch);

        if(curr.word != null){
            this.answer.add(curr.word);
            curr.word=null;
        }
        fullboard[row][col]='#';
        int[] rowOffset={-1,0,1,0};
        int[] colOffset={0,1,0,-1};
        for(int i=0;i<4;i++){
            int newRow=row+rowOffset[i];
            int newCol=col+colOffset[i];
            if(newRow<0 || newCol<0 || newRow>=fullboard.length || newCol>=fullboard[0].length){
                continue;
            }
            if(curr.children.containsKey(fullboard[newRow][newCol])){
                backtracking(newRow,newCol,curr);
            }
        }
        fullboard[row][col]=ch;
        if(curr.children.isEmpty()){
            parent.children.remove(ch);
        }
    }
}
