import java.util.HashMap;
import java.util.Map;


class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if(map.get(target - numbers[i]) == null){
                map.put(numbers[i], i + 1);
            }else{
                return new int[]{map.get(target - numbers[i]), i + 1};
            }
        }

        return new int[]{};
    }
    public int[] twoSum_1(int[] numbers, int target) {
        // 利用缩减搜索空间的思想，解说地址：
        // https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/solutions/87919/yi-zhang-tu-gao-su-ni-on-de-shuang-zhi-zhen-jie-fa/
        int i = 0, j = numbers.length - 1;
        
        while(i < j){
            if(numbers[i] + numbers[j] < target){
                i++;
            }else if(numbers[i] + numbers[j] > target){
                j--;
            }else if((numbers[i] + numbers[j]) == target){
                return new int[]{i+1, j+1};
            }
        }

        return new int[]{0, 0};
    }
}