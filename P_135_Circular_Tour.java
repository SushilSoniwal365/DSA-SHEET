public class P_135_Circular_Tour {

    // https://practice.geeksforgeeks.org/problems/circular-tour-1587115620/1

    // ? T.C = O(n) & S.C = O(1).
    public static int tour(int petrol[], int distance[]) {
        int d = 0, b = 0, s = 0;
        for (int i = 0; i < distance.length; i++) {
            b += petrol[i] - distance[i];
            if (b < 0) {
                d += b;
                s = i + 1;
                b = 0;
            }
        }
        if (d + b >= 0) {
            return s;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] petrol = { 4, 6, 7, 4 };
        int[] distance = { 6, 5, 3, 5 };
        System.out.println(tour(petrol, distance));
    }
}
