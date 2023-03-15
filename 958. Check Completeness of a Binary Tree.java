class Solution {
    public boolean isCompleteTree(TreeNode root) {
      Queue<TreeNode> qu=new LinkedList<>();
      qu.offer(root);
      while(qu.peek()!=null){
          TreeNode node=qu.poll();
          qu.offer(node.left);
          qu.offer(node.right);
      }
      while(!qu.isEmpty() && qu.peek()==null){
          qu.poll();
      } 
     return qu.isEmpty();
    }
}