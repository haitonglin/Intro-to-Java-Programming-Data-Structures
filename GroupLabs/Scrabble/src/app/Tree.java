package app;
//Inspiration comes from Hash tree and trie

public class Tree {//big O (constant)
    private int SIZE = 26;// 26 English letters
    private TreeNode root;// root of tree

    class TreeNode // node of tree
    {
        private TreeNode[] son;// all the son node (length should be size(26))
        private boolean isEnd;// is it the last letter? （Only the last letter of the node is true）
       

        TreeNode()
        {
            son = new TreeNode[SIZE];
            isEnd = false;
        }
    }

    Tree() // Initialize tree
    {
        root = new TreeNode();
    }

    // build tree
    public void insert(String str) 
    {
        if (str == null || str.length() == 0)
        {
            return;
        }
        TreeNode node = root;//from the very beginning
        char[] letters = str.toCharArray();
        for (int i = 0, len = str.length(); i < len; i++)
        {
            int pos = letters[i]- 'a';
            if (node.son[pos] == null)  //If not exist, then create a new node
            {
                node.son[pos] = new TreeNode();//create new node
            } 
            node = node.son[pos];//running form this node(change the root)
        }
        node.isEnd = true;
    }

    // check word
    // It has almost the same step as the "building tree"
    public boolean has(String str)
    {
        if(str==null||str.length()==0)
        {
            return false;
        }
        TreeNode node=root;
        char[]letters=str.toCharArray();
        for(int i=0,len=str.length(); i<len; i++)
        {
            int pos=letters[i]-'a';
            if(node.son[pos]!=null)//existing, then check next node
            {
                node=node.son[pos];
            }
            else// the play word is not in the tree
            {
                return false;
            }
        }
        //could be partially the same, should think if it is the last letter
        return node.isEnd;//if it is the last one
    }

    public static void main(String[]args)
    {
        char[] text = {'a','b','c','d'};
        System.out.println(text[0] - 'a');
        System.out.println(text[1] - 'a');
        System.out.println(text[2] - 'a');
        System.out.println(text[3] - 'a');
        Tree tree=new Tree();
        String[]strs= {"aa","cc","aple","duke","lol",};
        for(String str:strs)
        {
            tree.insert(str);
        }
        System.out.println(tree.has("duke"));
        System.out.println(tree.has("duk"));
        System.out.println(tree.has("dukea"));
        System.out.println(tree.has("kk"));
    }
}