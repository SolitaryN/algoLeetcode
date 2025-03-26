/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

// @lc code=start

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * @date 20250304
 * 官方题解，使用自定义双向链表 + hashmap实现
 * https://leetcode.cn/problems/lru-cache/solutions/259678/lruhuan-cun-ji-zhi-by-leetcode-solution
 */
class LRUCache2{
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache2 (int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null)  return -1;

        // 如果 key 存在，需要移到头部
        makeRecently(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            makeRecently(newNode);

            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }
        else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            makeRecently(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void makeRecently(DLinkedNode node) {
        moveToHead(node);
    }

    // 移出最老元素
    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}


/*
 * @date 20241001
 * 
 * @date 20250304
 */
class LRUCache1 {
    LinkedHashMap<Integer, Integer> map;
    int capacity;

    public LRUCache1(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>();
        // 如果开启 accessOrder，则直接是最近最少访问算法，不需要手动makeRecently操作
        // map = new LinkedHashMap<>(capacity + 1, 1.0f, true);
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            makeRecently(key);
        }
        return map.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            makeRecently(key);
            return;
        }

        // 如果没有该key，则做以下处理，如果目前容器已经满了，则进行最老元素的删除
        if(map.size() >= this.capacity){
            // LinkedHashMap中新加入的元素会放置到双链表的末尾
            //      这里LinkedHashMap 返回的keySet是LinkedHashSet，
            //          按照插入顺序的key集合，有序
            int oldestKey = map.keySet().iterator().next();// 第一个元素的key
            map.remove(oldestKey);
        }
        map.put(key, value);
    }

    public void makeRecently(int key) {
        int val = map.get(key);
        map.remove(key);
        map.put(key, val);
    }
}

/*
 * @date 20250326
 */
class LRUCache{
    int cap;
    LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        cap = capacity;
        cache = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        makeRecent(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            makeRecent(key);
            return;
        }

        if (cache.size() >= cap) {
            int del = cache.keySet().iterator().next();
            cache.remove(del);
        }
        cache.put(key, value);
    }

    public void makeRecent(int key) {
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

