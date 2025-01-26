class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;

        for (int bill=0;bill<bills.length;bill++) {
            if (bills[bill] == 5) {
                five++;
            } else if (bills[bill]== 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false; 
                }
            } else if (bills[bill]== 20) {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false; 
                }
            }
        }

        return true;
    }
}