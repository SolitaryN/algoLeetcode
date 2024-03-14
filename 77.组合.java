import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> path;
    public List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        path = new ArrayList<>();
        result = new ArrayList<>();

        backtracking(n, k, 1);
        return result;
    }

    void backtracking(int n, int k, int startIndex){
        if(path.size() == k){
            List<Integer> targetList = new ArrayList<>(Collections.nCopies(path.size(), null));
            Collections.copy(targetList, path);
            result.add(targetList); // 收割结果
            return;
        }

        for (int i = startIndex; i <= n; i++) { // 单层搜索
            path.add(i);  // 处理结点，此处就是“记录路径”
            backtracking(n, k, i + 1);   // 递归函数
            path.remove(path.size() - 1);   // 回溯
        }
    }
}