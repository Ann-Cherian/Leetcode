class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildUtil(inorder, postorder, 0, inorder.length - 1, 0, postorder.length- 1);
    }

    TreeNode buildUtil(int in[], int post[], int inStrt,
                   int inEnd, int postStrt, int postEnd)
    {
        // Base case
        if (inStrt > inEnd)
            return null;
 
        /* Pick current node from Postorder traversal using
           postIndex and decrement postIndex */
        TreeNode node = new TreeNode(post[postEnd]);
 
        /* If this node has no children then return */
        if (inStrt == inEnd)
            return node;
        int iIndex = search(in, inStrt, inEnd, node.val);
 
        /* Using index in Inorder traversal, construct left
           and right subtrees */
        node.left = buildUtil(in, post, inStrt, iIndex - 1, postStrt,
                            postStrt - inStrt + iIndex - 1);

        node.right = buildUtil(in, post, iIndex + 1, inEnd,
                               postEnd - inEnd + iIndex,
                               postEnd - 1);
 
        return node;
    }
 
    /* Function to find index of value in arr[start...end]
       The function assumes that value is postsent in in[]
     */
    int search(int arr[], int strt, int end, int value)
    {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value)
                break;
        }
        return i;
    }
 
}