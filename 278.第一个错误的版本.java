/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

/**
 * @note_that 最好使用 middle = start + (end - start)/2 来更新 middle，
 *              而不是采用 middle = (start + end)/2 来更新 middle，因为很有可能超出 int 数据表达范围，造成执行流错误。
 */
class Solution {

    public boolean isBadVersion(int n){
        return false; // fake function for no wrong with this Solution
    }
    public int firstBadVersion(int n) {
        // 本题关键，要知道二分查找的最终状态肯定是 left == right
        int left = 1, right = n;
        while (left < right) { // 循环直至区间左右端点相同
            int mid = left + (right - left) / 2; // 防止计算时溢出
            if (isBadVersion(mid)) {
                right = mid; // 答案在区间 [left, mid] 中
            } else {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;

    }

    public int firstBadVersion_myself_function(int n){
        int start = 1, middle = start+ (n - start)/2, end = n;
        while(start <= end){
            // 是否中间为坏版本
            if(isBadVersion(middle)){
                // 如果是坏版本
                if(middle == 1 || !isBadVersion(middle-1) ){
                    // 如果坏版本的前一个版本是好版本，或者 middle 是 1，确认找到首个坏版本
                    return middle;          
                }else{
                    // 如果前一个版本是坏版本，则首个坏版本在前面
                    end = middle - 1;
                    middle = start + (end - start)/2;
                }

            }else{
                // 如果是好版本，则首个坏版本在后面
                start = middle + 1;
                middle = start + (end - start)/2;
            }
        }
        return -1; 
    }
}
