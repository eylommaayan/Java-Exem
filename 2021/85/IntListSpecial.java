public class IntListSpecial {
    // A private field representing the head of the linked list
    private IntNodeSpecial _head;

    // Constructor that initializes the head of the list to null
    public IntListSpecial() {
        _head = null;
    }

    // Method to set a special property for each node in the list
    public void setSpecial() {
        // Start with the head of the list
        IntNodeSpecial temp = _head;
        
        // Iterate through the list until the end
        while (temp != null) {
            // Call the setNextSpecial() method on the current node
            temp.setNextSpecial();
            
            // Move to the next node in the list
            temp = temp.getNext();
        }
    }
}
