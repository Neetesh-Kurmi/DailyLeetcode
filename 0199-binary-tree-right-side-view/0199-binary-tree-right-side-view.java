class Solution {
    public List<Integer> rightSideView(TreeNode root) {
       List<Integer>list =  new ArrayList<>();
       Queue<TreeNode> q = new LinkedList<>();
       if (root!=null) q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode removal = q.remove();

                if(i == size-1)
                list.add(removal.val);

                if(removal.left !=null)
                    q.add(removal.left);
                if(removal.right !=null)
                   q.add(removal.right);
            }
        }
        return list;
    }
}