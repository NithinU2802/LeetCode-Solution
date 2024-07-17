// 1110. Delete Nodes And Return Forest
class Solution {
    static List<TreeNode> res;

    public void traverse(TreeNode root, boolean[] check) {
        if (root == null) {
            return;
        }
        
        boolean deleted = check[root.val];

        if (!deleted)
            res.add(root);
        
        root.left = traverseHelper(root.left, check);
        root.right = traverseHelper(root.right, check);
        
        if (deleted){
            if (root.left != null)
                res.add(root.left);
            if (root.right != null)
                res.add(root.right);
        }
    }

    public TreeNode traverseHelper(TreeNode root, boolean[] check) {
        if (root == null)
            return null;
        
        if (check[root.val]) {
            traverse(root, check);
            return null;
        } else {
            root.left = traverseHelper(root.left, check);
            root.right = traverseHelper(root.right, check);
            return root;
        }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        res = new ArrayList<>();
        boolean[] check=new boolean[1001];
        for(int i:to_delete)
            check[i]=true;
        traverse(root, check);
        return res;
    }
}
