/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] 数据流的中位数
 */

// @lc code=start

/*
 * @date 20250305
 * 详细解析参见：
    https://labuladong.online/algo/practice-in-action/find-median-from-data-stream/
 */

import java.util.PriorityQueue;

class MedianFinder {
    private PriorityQueue<Integer> large;
    private PriorityQueue<Integer> small;

    public MedianFinder() {
        // 小顶堆
        large = new PriorityQueue<>();
        // 大顶堆
        small = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
    }

    public double findMedian() {
        // 如果元素不一样多，多的那个堆的堆顶元素就是中位数
        if (large.size() < small.size()) {
            return small.peek();
        } else if (large.size() > small.size()) {
            return large.peek();
        }
        // 如果元素一样多，两个堆堆顶元素的平均数是中位数
        return (large.peek() + small.peek()) / 2.0;

    }

    // 在添加元素时，保证含有元素较多的堆添加一个元素之后，要吐出一个元素给另外一个堆添加
    // 也即，增加元素到含有元素较少的堆中
    public void addNum(int num) {
        if (small.size() >= large.size()) {
            small.offer(num);
            large.offer(small.poll());
        } else {
            large.offer(num);
            small.offer(large.poll());
        }
    }
}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

