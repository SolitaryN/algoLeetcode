import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    /*
     * @date 20240924
     * 保证信息不丢失就行，j 指针一直用来保证可以利用的空间起始
     */
    public void moveZeroes_1(int[] nums) {
        if (nums == null) {
            return;
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }

    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        for (; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    public void moveZeroes_2(int[] nums) {
        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                que.offer(nums[i]);
            }
        }

        int queLen = que.size();
        for (int i = 0; i < queLen; i++) {
            nums[i] = que.poll();
        }

        for (int i = queLen; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}