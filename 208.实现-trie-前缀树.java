/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class Trie {

    /*
     * @date 20250323
     * 定义节点，每个节点保存
     *      一个字符，表示节点字符
     *      一个节点数组，表示下游字母节点（算是一个26叉树）
     *      一个布尔值表示是否为一个单词还是前缀
     * 用一个虚拟的根节点保存根，更清晰。
     */
    Node dummyRootNode; 
    public Trie() {
        dummyRootNode = new Node(' ');
    }
    
    public void insert(String word) {
        Node curr = dummyRootNode;
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
    
    public boolean startsWith(String prefix) {
        Node res = getLast(prefix);
        return res != null;
    }

    public Node getLast(String word){
        Node curr = dummyRootNode;
        for(char c : word.toCharArray()){
            if(curr.children[c - 'a'] != null){
                curr = curr.children[c - 'a'];
            }else{
                return null;
            }
        }
        return curr;
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

