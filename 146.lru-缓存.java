/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

// @lc code=start

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache1 {
    Map<Integer, Integer> map;
    int capacity;
    public LRUCache1(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        return 0;
    }
    
    public void put(int key, int value) {
    }

    void makeRecently(int key){
    }

    void removeEldest() {
    }
}

/*
 * @date 20241001
 */
class LRUCache {
    LinkedHashMap<Integer, Integer> map;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity, 0.75f, true);
    }
    
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        map.put(key, value);
        map.get(key);
        
        if(map.size() > this.capacity){
            //  双向链表中的第一个元素，如果开启LRU，则是最近最少访问的元素
            int oldestKey = map.keySet().iterator().next();
            map.remove(oldestKey);
        }
    }

}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

