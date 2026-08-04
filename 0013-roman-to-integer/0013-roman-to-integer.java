class Solution {
    public int romanToInt(String s) {

        int answer = 0;

        for (int i = 0; i < s.length(); i++) {

            int current = getValue(s.charAt(i));

            // Check whether a next character exists
            if (i + 1 < s.length()) {

                int next = getValue(s.charAt(i + 1));

                // Smaller value before larger value means subtraction
                if (current < next) {
                    answer -= current;
                } else {
                    answer += current;
                }

            } else {
                // Last character
                answer += current;
            }
        }

        return answer;
    }

    private int getValue(char roman) {

        switch (roman) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}