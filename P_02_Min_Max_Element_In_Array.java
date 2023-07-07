import java.util.Arrays;

public class P_02_Min_Max_Element_In_Array {

    // T.C = O(n) & S.C = O(1).
    public static int[] findMinMax(int[] arr) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return new int[] { min, max };
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 12, 11, 23, 1, 8, 9 };
        int[] res = findMinMax(arr);
        System.out.println(Arrays.toString(res));
    }
}
