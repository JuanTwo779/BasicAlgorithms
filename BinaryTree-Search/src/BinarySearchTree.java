import java.util.*;

public class BinarySearchTree
{
    public static class Node
    {
        private int data;
        private Node left;
        private Node right;

        public Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public BinarySearchTree()
    {
        root = null;
    }

    public int acceptInput()
    {
        boolean cont = true;
        int val = 0;
        do
        {
            try
            {
                Scanner console = new Scanner(System.in);
                System.out.println("Please enter a numeric value");
                val = Integer.parseInt(console.nextLine());
                cont = false;
            }
            catch(Exception e)
            {
                System.out.println("Please enter numeric input only!");
            }
        }while(cont);
        return val;
    }

    public void add()
    {
        insert(acceptInput());
    }

    public void delete()
    {
        root = deleteNode(root, acceptInput());
    }

    public void getUserInput()
    {
        boolean cont = true;
        do
        {
            System.out.println("Press 1 to add an element to the tree");
            System.out.println("Press 2 to remove an element from the tree");
            System.out.println("Press 3 to print out the tree");
            System.out.println("Press 4 to exit");
            Scanner console = new Scanner(System.in);
            String val = console.nextLine();

            switch(val)
            {
                case "1":
                    add();
                    break;
                case "2":
                    delete();
                    break;
                case "3":
                    display();
                    break;
                case "4":
                    System.out.println("Exiting. Goodbye!");
                    cont = false;
                    break;
                default:
                    System.out.println("Unrecognized input. Ignoring!");
                    break;
            }
        } while (cont);

    }

    public void insert(int data)
    {
        Node newNode = new Node(data);

        if(root == null)
        {
            root = newNode;
            return;
        }
        else
        {
            Node current = root;
            Node parent = null;

            while(true)
            {
                parent = current;

                if(data < current.data)
                {
                    current = current.left;
                    if(current == null)
                    {
                        parent.left = newNode;
                        return;
                    }
                }
                else
                {
                    current = current.right;
                    if(current == null)
                    {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public Node deleteNode(Node node, int value)
    {
        if(node == null)
        {
            return null;
        }
        else
        {
            if(value < node.data)
                node.left = deleteNode(node.left, value);
            else if(value > node.data)
                node.right = deleteNode(node.right, value);
            else
            {
                if(node.left == null && node.right == null)
                    node = null;
                else if(node.left == null)
                    node = node.right;
                else if(node.right == null)
                    node = node.left;
                else
                {
                    Node temp = minNode(node.right);
                    node.data = temp.data;
                    node.right = deleteNode(node.right, temp.data);
                }
            }
            return node;
        }
    }

    public void display()
    {
        inorderTraversal(root);
        System.out.println();
    }

    public void inorderTraversal(Node node)
    {
        if(root == null)
        {
            System.out.println("Tree is empty");
            return;
        }
        else
        {
            if(node.left!= null)
                inorderTraversal(node.left);
            System.out.print(node.data + " ");
            if(node.right!= null)
                inorderTraversal(node.right);
        }
    }

    public static void main(String[] args)
    {
        BinarySearchTree bst = new BinarySearchTree();
        bst.startDemo();
    }

    public Node minNode(Node root)
    {
        if (root.left != null)
            return minNode(root.left);
        else
            return root;
    }

    public void startDemo()
    {
        getUserInput();
    }
}
