/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class Trie {

    Node dummy; 

    public Trie() {
        dummy = new Node(' ');
    }
    
    public void insert(String word) {
        Node curr = dummy;
        for(char c : word.toCharArray()){
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new Node(c);
            }

            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        Node res = getLast(word);
        return res != null && res.isWord;
    }

    public Node getLast(String word){
        Node curr = dummy;
        for(char c : word.toCharArray()){
            if(curr.children[c - 'a'] != null){
                curr = curr.children[c - 'a'];
            }else{
                return null;
            }
        }
        return curr;
    }
    
    public boolean startsWith(String prefix) {
        Node res = getLast(prefix);
        return res != null;
    }

    class Node{
        char value;
        boolean isWord;
        Node[] children;

        Node(char c){
            value = c;
            isWord = false;
            children = new Node[26];
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

