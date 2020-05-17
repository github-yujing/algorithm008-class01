//因为找零一般都是先找大面额的钱，再补小面额的钱，所以可以用贪心法解决。
class Solution {
    public boolean lemonadeChange(int[] bills) {
    int five = 0, ten = 0;
        for (int bill : bills) {
            switch (bill) {
                case 5: five++; break;
                case 10: five--; ten++; break;
                case 20: {
                    if (ten > 0) {
                        ten--; five--;
                    } else {
                        five -= 3;
                    }
                    break;
                }
                default: break;
            }
            if (five < 0) {
                return false;
            }
        }
        return true;
    }
}
