public class P_41_Minimum_Number_Of_Days_To_Make_M_Bouquets {

    // https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/

    // * T.C = O(NlogN) & S.C = O(1).
    public static int minDays(int[] bloomDay, int m, int k) {
        // Calculate the total number of flowers needed
        int totalFlowersNeeded = m * k;

        // Check if there are enough flowers in bloom to make the required number of
        // bouquets
        if (totalFlowersNeeded > bloomDay.length) {
            return -1;
        }

        // Find the minimum and maximum bloom day
        int minBloomDay = Integer.MAX_VALUE;
        int maxBloomDay = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            minBloomDay = Math.min(minBloomDay, day);
            maxBloomDay = Math.max(maxBloomDay, day);
        }

        // Perform binary search on the possible number of days
        int low = minBloomDay;
        int high = maxBloomDay;
        int minDays = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Possible result

            // Check if it is possible to make the required number of bouquets in 'mid' days
            if (isPossible(bloomDay, mid, m, k)) {
                minDays = mid;
                high = mid - 1; // Check for a lesser possible answer
            } else {
                low = mid + 1; // We can not have m bouquets for this 'mid', so look for a higher value
            }
        }
        return minDays;
    }

    // Check if it is possible to make the required number of bouquets in 'mid' days
    private static boolean isPossible(int[] bloomDay, int mid, int m, int k) {
        int flowersInCurrSubarray = 0;
        int bouquetsMade = 0;

        for (int j : bloomDay) {
            if (j > mid) {
                // Flower hasn't bloomed yet, so we can not use it in a bouquet
                flowersInCurrSubarray = 0;
            } else {
                // Flower has bloomed, so we can use it in a bouquet
                flowersInCurrSubarray++;

                if (flowersInCurrSubarray == k) {
                    // We have enough flowers to make a bouquet
                    bouquetsMade++;
                    flowersInCurrSubarray = 0;
                }
            }
        }

        // Check if we were able to make the required number of bouquets
        return bouquetsMade >= m;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 10, 3, 10, 2 };
        int m = 3;
        int k = 1;
        System.out.println(minDays(arr, m, k));
    }
}
