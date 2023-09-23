import java.util.ArrayList;
import java.util.List;

import TreeClasses.Node;

public class P_195_Merge_Two_BSTs {

    // https://practice.geeksforgeeks.org/problems/merge-two-bst-s/1

    // ? T.C = O(m+n) & S.C = O(m+n).
    public static List<Integer> merge(Node root1, Node root2) {
        List<Integer> first = new ArrayList<>();
        first = inorderTraversal(root1);
        List<Integer> second = new ArrayList<>();
        second = inorderTraversal(root2);

        Integer[] a = first.toArray(new Integer[first.size()]);
        Integer[] b = second.toArray(new Integer[second.size()]);

        List<Integer> ans = mergeSortedArrays(a, b);
        return ans;
    }

    // * Merge Two Sorted Arrays.
    public static List<Integer> mergeSortedArrays(Integer[] arr1, Integer[] arr2) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                result.add(arr1[i]);
                i++;
            } else {
                result.add(arr2[j]);
                j++;
            }
        }

        while (i < arr1.length) {
            result.add(arr1[i]);
            i++;
        }

        while (j < arr2.length) {
            result.add(arr2[j]);
            j++;
        }

        return result;
    }

    // * InOrder Traversal.
    public static List<Integer> inorderTraversal(Node root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }

    private static void helper(Node root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        helper(root.left, ans);
        ans.add(root.data);
        helper(root.right, ans);
    }

    public static void main(String[] args) {
        // Create the first BST
        Node root1 = new Node(4);
        root1.left = new Node(2);
        root1.right = new Node(6);
        root1.left.left = new Node(1);
        root1.left.right = new Node(3);
        root1.right.left = new Node(5);
        root1.right.right = new Node(7);

        // Create the second BST
        Node root2 = new Node(9);
        root2.left = new Node(8);
        root2.right = new Node(10);

        // Merge the two BSTs
        List<Integer> mergedList = merge(root1, root2);

        // Print the merged list
        System.out.println("Merged Sorted List: " + mergedList);
    }
}
