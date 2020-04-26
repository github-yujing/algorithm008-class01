/*  
242. 有效的字母异位词
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
*/  

/*用一个一维数组做计数器，只计算26个字母的出现次数。
缺点是无法判断字母大小写以及Unicode编码。*/
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] counter = new int[26];
        for (char c: s.toCharArray()) {
            counter[c - 'a']++;
        }
        for (char c: t.toCharArray()) {
            counter[c - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}



/*用哈希表记录字母出现次数，能够判断字母大小写以及Unicode编码*/
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Integer> Map1 = new HashMap();
        Map<Character, Integer> Map2 = new HashMap();
        for (char c : s.toCharArray())
            Map1.put(c, Map1.getOrDefault(c, 0) + 1);
        for (char c : t.toCharArray())
            Map2.put(c, Map2.getOrDefault(c, 0) + 1);
        if (Map1.size() != Map2.size())
            return false;
        for (char c : s.toCharArray()) {
            if (!Map1.get(c).equals(Map2.getOrDefault(c, 0))) {
                return false;
            }
        }
        return true;
    }
}
