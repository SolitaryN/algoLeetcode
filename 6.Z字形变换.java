import java.util.ArrayList;
import java.util.*;

class Solution {
    // input: aab
    public String convert(String s, int numRows) {
        List<StringBuilder> list = new ArrayList<>();

        for(int i = 0; i < numRows; i++){
            list.add(new StringBuilder());
        }
        
        int flag = -1, j = 0;
        for (int i = 0; i < s.length(); i++) {
            list.get(j).append(s.charAt(i));
            if(j == 0 || j == numRows -1) flag = - flag;
            j += flag;
        }

        StringBuilder res = new StringBuilder();
        for(StringBuilder row : list) 
            res.append(row);
        return res.toString();
    }

}
