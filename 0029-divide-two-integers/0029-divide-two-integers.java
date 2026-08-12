class Solution {
    public int divide(int dividend, int divisor) {

        // Special overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean negative = (dividend < 0) ^ (divisor < 0);

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        long count = 0;

        while (a >= b) {

            long temp = b;
            long multiple = 1;

            while (a >= temp + temp) {
                temp = temp + temp;
                multiple = multiple + multiple;
            }

            a = a - temp;
            count = count + multiple;
        }

        if (negative) {
            count = -count;
        }

        return (int) count;
    }
}