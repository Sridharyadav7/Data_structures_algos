/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        check(root, pq, k);

        if (pq.size() < k) {
            return -1;
        }

        return pq.poll();
    }
    public Pair check(TreeNode root, PriorityQueue<Integer> pq, int k) {
        if (root == null) {
            return new Pair(0, true);
        }

        Pair left = check(root.left, pq, k);
        Pair right = check(root.right, pq, k);

        boolean isPerfect = left.size == right.size && left.isPerfect && right.isPerfect;
        int size = 1 + left.size + right.size;

        if (isPerfect) {
            if (pq.size() < k) {
                pq.add(size);
            }
            else if (pq.peek() < size) {
                pq.poll();
                pq.add(size);
            }
        }

        return new Pair(size, isPerfect);
    }
}

class Pair {
    int size;
    boolean isPerfect;

    public Pair (int _size, boolean _isPerfect) {
        this.size = _size;
        this.isPerfect = _isPerfect;
    }
}