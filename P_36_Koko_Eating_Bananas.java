public class P_36_Koko_Eating_Bananas {

    // https://leetcode.com/problems/koko-eating-bananas

    // ? T.C = O(maxPile * n) & S.C = O(1).
    public static int minEatingSpeed1(int[] piles, int h) {
        int maxPile = 0;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }

        for (int speed = 1; speed <= maxPile; speed++) {
            if (isPossible(piles, h, speed)) {
                return speed;
            }
        }

        return -1;
    }

    // * T.C = O(N*log(max(Piles))) & S.C = O(1).
    public static int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }

        if (h == piles.length)
            return maxPile;

        int low = 1, high = maxPile, k = maxPile;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(piles, h, mid)) {
                k = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return k;
    }

    // Method to check if the current speed is possible or not.
    private static boolean isPossible(int[] piles, int h, int speed) {
        // Calculate the total time required to eat all the piles
        long time = 0;
        for (int pile : piles) {
            time += pile / speed;
            if (pile % speed != 0) {
                time++;
            }
        }

        // Check if the total time is less than or equal to the given number of hours
        return (time <= h);
    }

    public static void main(String[] args) {
        int[] piles = { 805306368, 805306368, 805306368 };
        int h = 1000000000;
        System.out.println(minEatingSpeed(piles, h));
    }
}
