import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

class Solution {
    public void moveZeroes(int[] nums) {
        Deque<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                que.add(nums[i]);
            }
        }


        Iterator<Integer> iter = que.iterator();
        int index = 0;
        while(iter.hasNext()){
            Integer temp = iter.next();
            nums[index] = temp;
            index++;
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes_1(int[] nums) {
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                if(i == j){
                    j++;
                    continue;
                }
                int temp = nums[i];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }

        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}