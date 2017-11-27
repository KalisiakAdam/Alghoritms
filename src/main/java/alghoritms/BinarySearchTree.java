package alghoritms;

public class BinarySearchTree <Key extends Comparable<Key>, Value> {

    private Node root;

    public class Node{
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int n;

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    ", n=" + n +
                    '}';
        }

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            this.n = n;


        }
    }

    public int size(){
        return size(root);
    }

    private int size(Node x){
        if (x == null) return 0;
        else return x.n;
    }

    public Value get (Key key){
        return get(root, key);
    }

    private Value get(Node x, Key key){

        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.value;
    }

    public void put(Key key, Value value){
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value){

        if (x == null) return new Node(key,value,1);
        int cmp = key.compareTo(x.key);

        if (cmp < 0) x.left = put(x.left, key, value);
        else if (cmp > 0) x.right = put(x.right, key, value);
        else x.value = value;
        x.n = size(x.right) + size(x.left) + 1;

        System.out.println("x is " + x);
        System.out.println("x.left" + x.left);
        System.out.println("x.right "  + x.right);

        return x;
    }

    public static void main(String[] args) {

        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.put("Adam", 18);
        binarySearchTree.put("Ula", 21);
        binarySearchTree.put("Wiki", 1);
        binarySearchTree.put("Lila", 2);

        System.out.println(binarySearchTree.size());
        System.out.println(binarySearchTree.get("Adam"));

    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }
}
