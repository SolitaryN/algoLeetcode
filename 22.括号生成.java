import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<List<String>> total = new ArrayList<>();
        if(n == 0){
            return new ArrayList<>();
        }

        total.add(new ArrayList<String>());
        total.get(0).add("");
        total.add(new ArrayList<String>());
        total.get(1).add("()");

        for (int i = 2; i <= n; i++) { // 有 i 个括号的字符串
            List<String> temp_ans = new ArrayList<>(); 

            for (int j = 0; j < i; j++) {
                List<String> now1 = total.get(j); // 有 j 个括号的情况
                List<String> now2 = total.get(i - j - 1); // 有 i - j -1 个括号的情况

                for (String string1 : now1) {
                    for (String string2 : now2) {
                        String temp = "(" + string1 + ")" + string2;
                        temp_ans.add(temp);
                    }
                }
            }

            total.add(temp_ans);
        }

        return total.get(n);
    }
    

    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<>();

        if(n == 0){
            return ans;
        }
        
        dfs_helper(ans, 0, 0, "", n);
        return ans;
    }

    public void dfs_helper(List<String> ans, Integer left, Integer right, String sb, int n){
        if(left == n && right == n){ // 出递归条件
            ans.add(sb.toString());
            return;
        }
        if(left < right){ // 剪枝操作
            return;
        }
        if(left < n){
            dfs_helper(ans, left + 1, right, sb + "(", n);
        }
        if(right < n){
            dfs_helper(ans, left, right + 1, sb + ")", n);
        }
    }
}