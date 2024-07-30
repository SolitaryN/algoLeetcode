/*
 * @lc app=leetcode.cn id=981 lang=java
 *
 * [981] 基于时间的键值存储
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimeMap {

    Map<String, List<Pair<String, Integer>>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key))  map.put(key, new ArrayList<>());

        map.get(key).add(new Pair(value, timestamp));

    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        List<Pair<String, Integer>> list = map.get(key);
        return search(list, timestamp);
    }

    String search(List<Pair<String, Integer>> list, int timestamp){
        int l = 0, r = list.size() - 1;

        while (l <= r) {
            int mid = l + ((r - l) >> 2);
            if(list.get(mid).b == timestamp){
                return list.get(mid).a;
            }else if(list.get(mid).b < timestamp){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        return r <= -1 ? "" : list.get(r).a;
    }
}


class Pair<T, K>{
    T a;
    K b;

    public Pair(T a, K b){
        this.a = a; 
        this.b = b;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
// @lc code=end

