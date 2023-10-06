import java.util.ArrayList;

public class P_050_Max_Sum_Subarray_Of_Size_K {

    // https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1

    // ? T.C = O(n^2) & S.C = O(1).
    public static long maximumSumSubarray1(int k, ArrayList<Integer> list, int n) {
        long maxSum = 0;
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                if (j - i + 1 <= k) {
                    sum += list.get(j);
                }
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    // * T.C = O(n) & S.C = O(1).
    public static long maximumSumSubarray2(int k, ArrayList<Integer> list, int n) {
        long maxSum = 0, sum = 0;
        int i = 0, j = 0;

        while (j < n) {
            sum += list.get(j);
            if (j - i + 1 < k) {
                j++;
            } else {
                maxSum = Math.max(maxSum, sum);
                sum -= list.get(i);
                i++;
                j++;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(200);
        list.add(300);
        list.add(400);

        System.out.println(maximumSumSubarray2(3, list, list.size()));
    }
}
