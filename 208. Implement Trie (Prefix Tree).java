class TrieNode {
    // Initialize your data structure here.
	TrieNode[] children;
	String item;
	
    public TrieNode() {
        children = new TrieNode[26];
        item = "";
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        
        for(char ch: word.toCharArray()){
            int index = ch - 'a';
            if(node.children[index] == null) node.children[index] = new TrieNode();
            node = node.children[index];
        }
        
        node.item = word;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return match(root, word, 0, false);
    }
    
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return match(root, prefix, 0, true);
    }
    
    private boolean match(TrieNode node, String word, int i, boolean searchPrefix){
        if(node==null) return false;
        if(i==word.length()){
            if(searchPrefix) return true;
            return node.item.equals(word);
        }
        
        int index = word.charAt(i)-'a';
        return match(node.children[index], word, i+1, searchPrefix);
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");