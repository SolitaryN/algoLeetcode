import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);// 排序，nums变成递增数组
        List<List<Integer>> res = new ArrayList<>();
        // k < nums.length - 2是为了保证后面还能存在两个数字
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0)
                break;// 若nums[k]大于0，则后面的数字也是大于零（排序后是递增的）
            if (k > 0 && nums[k] == nums[k - 1])
                continue;// nums[k]值重复了，去重
            int i = k + 1, j = nums.length - 1;// 定义左右指针
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i])
                        ;// 左指针前进并去重
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j])
                        ;// 右指针后退并去重
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[i] == nums[++i])
                        ;// 左指针前进并去重
                    while (i < j && nums[j] == nums[--j])
                        ;// 右指针后退并去重
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for (int k = 0; k < nums.length - 2; k++) {
            int first = nums[k];
            if (first > 0)
                break;
            if (k > 0 && nums[k - 1] == first)
                continue; // 因为第一个元素已经重复了，意味这之后的所有结果在该元素第一次出现的时候已经全部被考虑到了（因为数组现在已经有序了）

            int left = k + 1, right = nums.length - 1;
            while (left < right) {
                int temp = first + nums[left] + nums[right];
                if (temp < 0) {
                    left++;
                } else if (temp > 0) {
                    right--;
                } else {
                    // 等于 0 的时候，需要进行去重处理，上面的 left 和 right 变化的时候，不进行去重也是可以的
                    res.add(Arrays.asList(first, nums[left], nums[right]));
                    while(left < right && nums[left] == nums[++left]);
                    while(left < right && nums[right] == nums[--right]);
                }
            }

        }

        return res;
    }
}