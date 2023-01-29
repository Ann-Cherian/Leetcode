class Solution {
    public int alternateDigitSum(int n) {
        int totalSum = 0;
        boolean isPositive = true;
        String digits = n + "";
        for (char digit : digits.toCharArray()) {
            if (isPositive) {
                totalSum += Integer.parseInt(digit+"");
                isPositive = false;
            } else {
                totalSum -= Integer.parseInt(digit+"");
                isPositive = true;
            }
        }
        return totalSum;
    }
}