import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    /*
     * @date 20240925
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3){
            return Collections.emptyList();
        }

        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            // i 为锚点，此时如果值大于0，则break
            if(nums[i] > 0) return ans;
            
            // 锚点去重之前，一定被使用过，即就算有 aa 或者 aaa都已经排查过了
            if(i > 0 && nums[i] == nums[i - 1])  continue;
            
            int current = nums[i];
            int L = i + 1, R = length - 1;
            while (L < R) {
                int temp = current + nums[L] + nums[R];
                if(temp == 0){
                    List<Integer> list = Arrays.asList(nums[i], nums[L], nums[R]);
                    ans.add(list);

                    // 去重，确认答案后，左右都要移动到下一个不相等的元素上
                    while (L < R && nums[L] == nums[L + 1])  ++L;
                    while (L < R && nums[R] == nums[R - 1]) --R;
                    L++;  R--;

                }else if(temp < 0){
                    // 此时负数元素过小，左边右移
                    ++L;
                }else if(temp > 0){
                    // 此时正数元素过大，右边左移
                    --R;
                }
            }
        }
        return ans;
    }
}