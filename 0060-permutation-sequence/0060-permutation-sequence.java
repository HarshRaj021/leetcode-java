class Solution {
    public String getPermutation(int n, int k) {

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        // factorial
        int fact = 1;
        for (int i = 1; i < n; i++) {
            fact *= i;
        }

        k--; // make k zero-based

        StringBuilder ans = new StringBuilder();

        while (true) {

            int index = k / fact;

            ans.append(numbers.get(index));
            numbers.remove(index);

            if (numbers.size() == 0) {
                break;
            }

            k = k % fact;
            fact = fact / numbers.size();
        }

        return ans.toString();
    }
}