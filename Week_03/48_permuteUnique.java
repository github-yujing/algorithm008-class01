public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (len == 0) {
            return result;
        }

        //先对数组排序，便于去掉重复组合。
        Arrays.sort(nums);
        boolean[] used = new boolean[len];

        //这里过程变量数组current在回溯返回上层前，需要revert操作，
        //将最后一个元素去掉，适用后进先出的原则，使用Stack或者Deque数据结构。
        Deque<Integer> current = new ArrayDeque<>(len);

        dfs(nums, len, 0, used, current, result);
        return result;
    }
    private void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> current, List<List<Integer>> result) {
        if (depth == len) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < len; ++i) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            current.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, used, current, result);
            used[i] = false;
            current.removeLast();
        }
    }
}
