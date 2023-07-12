import java.util.HashMap;

public class P_29_Single_Element_In_A_Sorted_Array {

    // https://leetcode.com/problems/single-element-in-a-sorted-array

    // ? T.C = O(n) & S.C = O(n).
    public static int singleNonDuplicate1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1)
                return key;
        }
        return -1;
    }

    // * T.C = O(n) & S.C = O(1).
    public static int singleNonDuplicate2(int[] nums) {
        int n = nums.length, i = 0;
        if (n == 1)
            return nums[0];
        while (i < n - 1) {
            if (nums[i] == nums[i + 1]) {
                i += 2;
            } else {
                return nums[i];
            }
        }
        return nums[n - 1];
    }

    // ! T.C = O(log n) & S.C = O(1).
    public static int singleNonDuplicate3(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        // Case-01 => Only one element in the array.
        if (n == 1) {
            return nums[0];
        }

        // Case-02 => If the first element is the element that appears once only.
        if (nums[start] != nums[start + 1]) {
            return nums[start];
        }

        // Case-03 => If the last element is the element that appears once only.
        if (nums[end] != nums[end - 1]) {
            return nums[end];
        }

        // Binary Search.
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Case-01 => If the mid element is the element that appear once only.
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            }

            else if (mid % 2 == 0 && nums[mid] == nums[mid + 1] || mid % 2 != 0 && nums[mid] == nums[mid - 1]) {
                start = mid + 1;
            }

            else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
        System.out.println(singleNonDuplicate3(arr));
    }
}
