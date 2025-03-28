/*
 * @lc app=leetcode.cn id=468 lang=java
 *
 * [468] 验证IP地址
 */

// @lc code=start
class Solution {
    /*
     * @date 20250328
     * 手动一个个分析
     *  注意 split 方法传入的是 正则表达式，点 的正则表达式是 \\.
     *  注意字符串最后一个字符是 . 或者 : 的时候，直接返回 false
     */
    public String validIPAddress(String queryIP) {
        if (queryIP == null || queryIP.length() == 0) {
            return "Neither";
        }

        if (queryIP.indexOf('.') != -1) {
            return isIPv4(queryIP) ? "IPv4" : "Neither";
        } 

        if (queryIP.indexOf(':') != -1) {
            return isIPv6(queryIP) ? "IPv6" : "Neither";
        }

        return "Neither";
    }

    public boolean isIPv4(String queryIP) {
        String[] parts = queryIP.split("\\.");
        if (parts.length != 4 || queryIP.charAt(queryIP.length() - 1) == '.') {
            return false;
        }

        for (String part : parts) {
            if (part.length() == 0 || part.length() > 3) {
                return false;
            }

            if (part.charAt(0) == '0' && part.length() > 1) {
                return false;
            }

            // 非常有趣的写法，另外Java 的 Integer.parseInt() 方法会自动忽略前导零
            try {
                int num = Integer.parseInt(part);
                if (num < 0 || num > 255) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }

        return true;
    }

    public boolean isIPv6(String queryIP) {
        String[] parts = queryIP.split(":");
        if (parts.length != 8 || queryIP.charAt(queryIP.length() - 1) == ':') {
            return false;
        }

        for (String part : parts) {
            if (part.length() == 0 || part.length() > 4) {
                return false;
            }

            for (char c : part.toCharArray()) {
                if (!isHexChar(c)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isHexChar(char c) {
        return (c >= '0' && c <= '9') || 
                (c >= 'a' && c <= 'f') || 
                (c >= 'A' && c <= 'F');
    }
}

// @lc code=end

