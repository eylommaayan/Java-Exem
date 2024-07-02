public class Class_4 {
    
    public class A {
        public int _a;   // Public member variable
        private int _b;  // Private member variable
    
        public A(int a, int b) {
            _a = a;  // Initialize _a with the given value
            _b = b;  // Initialize _b with the given value
        }
    
        public int getB() {
            return _b;  // Return the value of _b
        }
    
        public int f() {
            return f(0);  // Call the overloaded method f with 0
        }
    
        public int f(int c) {
            return _b + c;  // Return the sum of _b and c
        }
    
        public String toString() {
            return "a= " + _a + " , b= " + _b;  // Return a string representation of the object
        }
    }
    public class B extends A {
        public int _a;   // Public member variable that hides _a in A
        private int _b;  // Private member variable that hides _b in A
    
        public B(int a, int b) {
            super(a, b);  // Call the constructor of class A
            _a = a + 1;   // Initialize _a with a+1
            _b = b + 1;   // Initialize _b with b+1
        }
    
        public int getB() {
            return _b;  // Return the value of _b
        }
    
        public int f() {
            return super.f();  // Call the f method in class A
        }
    
        public int f(int c) {
            return super.f(_b + c);  // Call the overloaded f method in class A with _b + c
            // This means it will pass the sum of the local _b in class B and c to the method f(int c) in class A
        }
    
        public String toString() {
            return "a= " + _a + " , b= " + _b;  // Return a string representation of the object
            // This will display the values of the local variables _a and _b in class B
        }
    }
    

public class Driver {
    public static void main(String[] args) {
        A aa = new A(0, 1);  // Create an instance of A with a=0, b=1
        A ab = new B(0, 1);  // Create an instance of B, referred to as A, with a=0, b=1
        B bb = new B(-2, -1);  // Create an instance of B with a=-2, b=-1

        // *** Corrected line for accessing _b ***
        System.out.println(bb.getB());  // Correctly accessing the private _b through getB()
    }
