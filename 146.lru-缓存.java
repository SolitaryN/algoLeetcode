/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

// @lc code=start

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache1 {

    Map<Integer, Integer> map;
    int capacity;

    public LRUCache1(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            makeRecent(key);
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.put(key, value);
            makeRecent(key);
            return;
        }
        
        if(map.size() == this.capacity){
            int oldestKey = map.keySet().iterator().next(); //  双向链表中的第一个元素
            map.remove(oldestKey);
        }
        map.put(key,value);
    }

    void makeRecent(int key){
        int val = map.get(key);
        map.remove(key);
        map.put(key, val);
    }


}

class LRUCache {

    Map<Integer, Integer> map;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity, 0.75f, true);
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.put(key, value);
            map.get(key);
            return;
        }
        
        if(map.size() == this.capacity){
            int oldestKey = map.keySet().iterator().next(); //  双向链表中的第一个元素
            map.remove(oldestKey);
        }
        map.put(key,value);
        map.get(key);
    }

}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

