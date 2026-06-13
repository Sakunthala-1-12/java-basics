import java.util.*;

class Solution {

    public int amountOfTime(TreeNode root, int start) {

        Map<TreeNode, TreeNode> parent = new HashMap<>();

        TreeNode startNode = build(root, parent, start);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> vis = new HashSet<>();

        q.add(startNode);
        vis.add(startNode);

        int time = -1;

        while (!q.isEmpty()) {

            int size = q.size();
            time++;

            for (int i = 0; i < size; i++) {

                TreeNode cur = q.poll();

                if (cur.left != null && vis.add(cur.left))
                    q.add(cur.left);

                if (cur.right != null && vis.add(cur.right))
                    q.add(cur.right);

                if (parent.get(cur) != null && vis.add(parent.get(cur)))
                    q.add(parent.get(cur));
            }
        }

        return time;
    }

    private TreeNode build(TreeNode root,
                           Map<TreeNode, TreeNode> parent,
                           int start) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        TreeNode startNode = null;

        while (!q.isEmpty()) {

            TreeNode cur = q.poll();

            if (cur.val == start)
                startNode = cur;

            if (cur.left != null) {
                parent.put(cur.left, cur);
                q.add(cur.left);
            }

            if (cur.right != null) {
                parent.put(cur.right, cur);
                q.add(cur.right);
            }
        }

        return startNode;
    }
}