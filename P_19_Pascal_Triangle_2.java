import java.util.ArrayList;
import java.util.List;

public class P_19_Pascal_Triangle_2 {

    // https://leetcode.com/problems/pascals-triangle-ii/description/

    // ? T.C = O(n^2) & S.C = O(n).
    public static List<Integer> getRow2(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);

        for (int i = 1; i <= n; i++) {
            for (int j = ans.size() - 1; j > 0; --j) {
                ans.set(j, ans.get(j) + ans.get(j - 1));
            }
            ans.add(1);
        }

        return ans;
    }

    public static void main(String[] args) {
        List<Integer> res = getRow2(4);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }
}
