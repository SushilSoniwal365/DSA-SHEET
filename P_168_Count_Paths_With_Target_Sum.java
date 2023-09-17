import java.util.HashMap;

import TreeClasses.TreeNode;

public class P_168_Count_Paths_With_Target_Sum {

    // https://leetcode.com/problems/path-sum-iii/

    // ? T.C = O(n) & S.C = O(n).
    public static int total;

    public static int pathSum(TreeNode root, int targetSum) {
        total = 0;
        if (root == null) {
            return 0;
        }
        HashMap<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);
        solve(root, 0, targetSum, map);
        return total;
    }

    private static void solve(TreeNode root, long currSum, long targetSum, HashMap<Long, Long> map) {
        if (root == null) {
            return;
        }
        currSum += root.val;
        if (map.containsKey(currSum - targetSum)) {
            total += map.get(currSum - targetSum);
        }
        map.put(currSum, map.getOrDefault(currSum, 0L) + 1);
        solve(root.left, currSum, targetSum, map);
        solve(root.right, currSum, targetSum, map);
        map.put(currSum, map.get(currSum) - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(pathSum(root, 5));
    }
}
