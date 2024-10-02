import java.util.ArrayList;
import java.util.List;

class Solution{
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();

        int numStart = 0, numEnd;
        int i = 0;
        while (i < str.length()) {
            while (str.charAt(i) != '#'){
                i++;
            }

            numEnd = i;
            int strLen = Integer.valueOf(str.substring(numStart, numEnd));
            ans.add(str.substring(numEnd + 1, numEnd + 1 + strLen));
            numStart = numEnd + 1 + strLen;
            i = numStart;
        }

        return ans;
    }
}
