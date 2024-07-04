// Method what determines if a given node is a leaf node
public static boolean what(Node node) {
    // If the node is null, return false
    if (node == null)
        return false;
    // If both left and right children are null, it is a leaf node
    if (node.getLeftSon() == null && node.getRightSon() == null)
        return true;
    // Otherwise, return false
    return false;
}

// Method secret performs a specific check on the given node
public static boolean secret(Node node) {
    // Variables to store results of left and right subtree checks
    int res1;
    int res2;

    // If the node is null or it is a leaf node, return true
    if (node == null || what(node))
        return true;

    // Recursively check the left and right subtrees
    if (secret(node.getLeftSon()) && secret(node.getRightSon())) {
        // Check the left child
        if (node.getLeftSon() == null)  // If the left child is null
            res1 = 0;  // Set res1 to 0
        else if (what(node.getLeftSon()))  // If the left child is a leaf
            res1 = node.getLeftSon().getNumber();  // Set res1 to its value
        else
            res1 = 2 * (node.getLeftSon().getNumber());  // Otherwise, set res1 to twice its value

        // Check the right child
        if (node.getRightSon() == null)  // If the right child is null
            res2 = 0;  // Set res2 to 0
        else if (what(node.getRightSon()))  // If the right child is a leaf
            res2 = node.getRightSon().getNumber();  // Set res2 to its value
        else
            res2 = 2 * (node.getRightSon().getNumber());  // Otherwise, set res2 to twice its value

        // If the node's value equals the sum of the results from its children, return true
        if (node.getNumber() == res2 + res1)
            return true;
        else
            return false;
    }
    // If the subtrees do not satisfy the condition, return false
    return false;
}
