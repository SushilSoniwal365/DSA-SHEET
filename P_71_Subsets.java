import java.util.ArrayList;
import java.util.List;

public class P_71_Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        generateSubSets(nums, 0, output, result);
        return result;
    }

    private static void generateSubSets(int[] nums, int index, List<Integer> output, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(output));
            return;
        }

        output.add(nums[index]);
        generateSubSets(nums, index + 1, output, result);
        output.remove(output.size() - 1);
        generateSubSets(nums, index + 1, output, result);

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        List<List<Integer>> sol = subsets(arr);

        for (List<Integer> l : sol) {
            System.out.println(l);
        }
    }
}
