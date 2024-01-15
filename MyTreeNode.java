import java.util.ArrayList;
import java.util.List;

public class MyTreeNode<T>{
    /**
     * Represents aa node within a tree data structure
     * @param item, pointer parent, list children
     * @return void
     */
    private T item;
    private MyTreeNode<T> parent;
    private ArrayList<MyTreeNode<T>> children;

    /**
     * Constructs MyTreeNode assigning params, creates arraylist to hold children
     * @param item, pointer parent
     * @return void
     */
    private MyTreeNode(T itemIn, MyTreeNode<T> parentIn){
        this.item = itemIn;
        this.parent = parentIn;
        this.children = new ArrayList<>();
    }

    /**
     * constructor for a root node with no parent 
     * @param takes in an item
     * @return void
     */
    public MyTreeNode(T itemIn){
        this(itemIn, null);
    }

    /**
     * Returns nodes parent node
     * @return parent
     */
    public MyTreeNode<T> getParent(){
        return parent;
    }

    /**
     * Returns nodes item
     * @return item
     */
    public T getItem(){
        return item;
    }

    /**
     * Creates a deep copy of list children and returns it
     * @return arraylist children
     */
    public List<MyTreeNode<T>> getChildren(){
        List<MyTreeNode<T>> childrenCopy = new ArrayList<MyTreeNode<T>>(this.children);
        return childrenCopy;
    }

    /**
     * Assigns a node as a child to another node. 
     * @param TreeNode childNode
     * @return childNode
     */
    public MyTreeNode<T> addChild(MyTreeNode<T> childNode) {
        childNode.parent = this;
        this.children.add(childNode);
        return childNode;
    }

    /**
     * Checks if a node is a leaf
     * @return boolean
     */
    public boolean isLeaf(){
        if (this.children.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Checks if a node is root
     * @return boolean
     */
    public boolean isRoot(){
        if (this.parent == null){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Finds the size of the node 
     * @return int count
     */
    public int size(){
        int count = 1; // Start with 1 to account for the current node itself

        for (MyTreeNode<T> child : children) {
            count += child.size(); // Recursively add the sizes of children
        }
        return count;
    }

    /**
     * Finds the depth of a node
     * @return int
     */
    public int depth(){
        if (parent == null){
            return 0;
        }
        else{
            return 1 + parent.depth();
        }
    }

    /**
     * Finds height of a node
     * @return int
     */
    public int height(){
        if (children.isEmpty()) {
            return 0; // The height of a leaf node is 0.
        } else {
            int maxHeight = 0;
            for (MyTreeNode<T> child : children) {
                int childHeight = child.height();
                if (childHeight > maxHeight) {
                    maxHeight = childHeight;
                }
            }
            return 1 + maxHeight;
        }
    }

    /**
     * Finds if an input T is the item of any of the nodes descendents (including itself)
     * @return boolean
     */
    public boolean contains(T input){
        if (item.equals(input)){
            return true;
            
        }
        else{
            for (MyTreeNode child : children){
                if (child.contains(input)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Private method print
     * Prints a node and indents for its children to show the familial heigharchy with tabs
     */
    private void print(String prefix){
        System.out.println(prefix + this.item.toString()); 
        if (!children.isEmpty()){
            for (MyTreeNode<T> child : children){
                child.print(prefix + "\t");
            }
            
        }
    }

    /**
     * Pubic method print to call the private method
     */
    public void print(){
        print("");
    }

 // main method to test the print method
 /* 
    public static void main(String[] args){
        MyTreeNode<String> root = new MyTreeNode<>("Root");
        MyTreeNode<String> child1 = new MyTreeNode<>("Child 1");
        MyTreeNode<String> child2 = new MyTreeNode<>("Child 2");

        root.addChild(child1);
        root.addChild(child2);

        MyTreeNode<String> grandchild1 = new MyTreeNode<>("Grandchild 1");
        child1.addChild(grandchild1);

        root.print();
    }
*/

}