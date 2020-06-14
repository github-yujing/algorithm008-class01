class Solution {
    boolean[] transformed; 
    int minTimes; 
    public int minMutation(String start, String end, String[] bank) {
        int len = bank.length;
        this.transformed = new boolean[len];
        this.minTimes = Integer.MAX_VALUE;
        boolean contain = false;
        for(String s : bank) { 
            if(s.equals(end)) {
                contain = true;
                break;
            }
        }
        if(!contain) {
            return -1;
        }
        backtrack(start, end, bank, transformed, 0);
        return minTimes == Integer.MAX_VALUE ? -1 : minTimes;
    } 
    public void backtrack(String s, String e, String[] bank, boolean[] trans, int times) {
        if(s.equals(e)) { 
            minTimes = Math.min(times, minTimes);
            return;
        }
        for(int i=0;i<bank.length;++i) {
            if(trans[i] == true) { 
                continue;
            }
            int diffChar = 0;
            for(int j=0;j<s.length();++j) {
                if(diffChar > 1) {
                    break;
                }
                if(s.charAt(j) == bank[i].charAt(j)) {
                    continue;
                } else {
                    diffChar++;
                }
            }

            if(diffChar == 1) {
                trans[i] = true;
                backtrack(bank[i], e, bank, trans, times + 1);
                trans[i] = false;
            }
        }
        return;
    }
}
