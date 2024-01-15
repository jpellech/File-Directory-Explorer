import java.io.File;

public class ExploreDirectory {

    /**
     * Main functiion checks command line arg
     * Finds the file, and creates it as a tree node
     * @param command line argument is an item on computers disk
     * @return a printed tree graph of the input item and its descendents
     */
    public static void main(String[] args){
        if (args.length != 1){
            System.out.println("You should only have one command line argument.");
            System.exit(-1);
        }
        else{
            String folderName = args[0];
            MyTreeNode<String> root = new MyTreeNode<>(folderName); // Create the root node for the directory tree
            createNode(folderName, root); // Call the recursive method to build the tree
            root.print(); // Print the contents of the directory tree
        }
    }

    /**
     * Creates the file from command line and puts it in a TreeNode, 
     * then it recursively searches the directory and creates a tree of nodes containing files.
     * @param filname is the name of the file, parent is the TreeNode parent
     */
    public static void createNode(String filename, MyTreeNode<String> parent){
        File file = new File(filename);

        MyTreeNode<String> currentNode = new MyTreeNode<>(file.getName());

        if (parent != null) {
            parent.addChild(currentNode);
        }

        if (file.isDirectory()) { // Get all subfolders and files within the directory
            File[] subFiles = file.listFiles();

            if (subFiles != null){
                for (File subfile : subFiles){
                    createNode(subfile.getPath(), currentNode);
                }
            }
        }

    }
}
