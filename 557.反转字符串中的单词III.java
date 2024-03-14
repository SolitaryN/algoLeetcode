class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");

        StringBuilder sb = new StringBuilder();
        StringBuilder sum = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]).reverse();
            sum.append(sb + " ");
            sb.delete(0, words[i].length());
        }

        return sum.delete(sum.length() - 1, sum.length()).toString();
    }

        public String reverseWords_1(String s) {
            char[] s_arr = s.toCharArray();
            int len = s.length();
            int i = 0;

            while(i < len){
                int start = i;
                while(i < len && s_arr[i] != ' '){
                    i++;
                }

                for (int left = start, right = i - 1; left < right; left++, right--) {
                    Character temp = s_arr[left];
                    s_arr[left] = s_arr[right];
                    s_arr[right] = temp;
                }

                while(i < len && s_arr[i] == ' '){
                    i++;
                }
            }

            return new String(s_arr);
        }
}