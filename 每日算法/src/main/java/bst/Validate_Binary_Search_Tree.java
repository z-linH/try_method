package bst;

/**
 * Created by Hzl on 2018/5/14.
 * 二叉查找树
 * -----------------------------------
 * 节点的左子树中的值要严格小于该节点的值。
 * 节点的右子树中的值要严格大于该节点的值。
 * 左右子树也必须是二叉查找树。
 * 一个节点的树也是二叉查找树。
 * -----------------------------------
 */
public class Validate_Binary_Search_Tree {
    public boolean isValidBST(TreeNode root) {
        return divideConquer(root).isBST;
    }

    private ResultType divideConquer(TreeNode root) {
        if (root == null) {
            return new ResultType(true);
        }

        ResultType left = divideConquer(root.left);
        ResultType right = divideConquer(root.right);
        if (!left.isBST || !right.isBST) {
            return new ResultType(false);
        }

        if (left.maxNode != null && left.maxNode.val >= root.val) {
            return new ResultType(false);
        }

        if (right.minNode != null && right.minNode.val <= root.val) {
            return new ResultType(false);
        }

        // is bst
        ResultType result = new ResultType(true);
        result.minNode = left.minNode != null ? left.minNode : root;
        result.maxNode = right.maxNode != null ? right.maxNode : root;

        return result;
    }
}

class ResultType {
    public boolean isBST;
    public TreeNode maxNode, minNode;
    public ResultType(boolean isBST) {
        this.isBST = isBST;
        this.maxNode = null;
        this.minNode = null;
    }
}

class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
     }
  }

