package com.dyzwj.trie;


/**
 * 前缀树
 */
public class TrieTree {


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc","abd","acd","ahb","abgt","abc");
        System.out.println(trie.search("abc"));
        System.out.println(trie.prefixNumber("ab"));

        trie.delete("abc");
        System.out.println(trie.search("abc"));
        System.out.println("============");
        System.out.println(trie.search("ahb"));
        trie.delete("ahb");
        System.out.println(trie.search("ahb"));
    }

    static class TrieNode{
        //经过当前节点的串
        int pass;
        //以当前节点结尾的串
        int end;
        TrieNode[] nexts;

        public TrieNode(){
            pass = 0;
            end = 0;
            nexts = new TrieNode[26];
        }

    }

    static class Trie{
        TrieNode trieNode;
        public Trie(){
            trieNode = new TrieNode();
        }
        public void insert(String... words){
            for (String word : words) {
                insert(word);
            }
        }

        //删除某个单词
        public void delete(String word){
            TrieNode cur = trieNode;
            char[] chars = word.toCharArray();
            cur.pass--;
            if(search(word) != -1){
                for (char aChar : chars) {
                    int index = aChar - 'a';
                    if(--cur.nexts[index].pass == 0){
                        cur.nexts[index] = null;
                        return;
                    }
                    cur = cur.nexts[index];
                }
                cur.end--;
            }


        }

        public void insert(String word){
            TrieNode cur = trieNode;
            char[] chars = word.toCharArray();
            cur.pass++;
            for (char aChar : chars) {
                int index = aChar - 'a';
                if(cur.nexts[index] == null){
                    cur.nexts[index] = new TrieNode();
                }
                cur = cur.nexts[index];
                cur.pass++;
            }
            cur.end++;
        }

        //查找该单词的个数
        public int search(String word){
            TrieNode cur = trieNode;
            char[] chars = word.toCharArray();
            for (char aChar : chars) {
                int index = aChar - 'a';
                if(cur.nexts[index] == null){
                    return -1;
                }
                cur = cur.nexts[index];
            }
            return cur.end;
        }

        public int prefixNumber(String pre) {
            TrieNode cur = trieNode;
            char[] chars = pre.toCharArray();
            for (char aChar : chars) {
                int index = aChar - 'a';
                if(cur.nexts[index] == null){
                    return -1;
                }
                cur = cur.nexts[index];
            }
            return cur.pass;

        }
    }


}
