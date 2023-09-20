import TreeClasses.TreeNode;

public class P_189_Convert_Sorted_Array_To_BST {

    // https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

    // ? T.C = O(n) & S.C = O(n).
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private static TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = sortedArrayToBST(nums, left, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, right);

        return root;
    }

    public static void main(String[] args) {
        int[] nums = { -10, -3, 0, 5, 9 };
        System.out.println(sortedArrayToBST(nums).val);
    }
}
