public static String minimalSt(String st1, String st2) {
    // If the first string is empty, return the second string
    if (st1.length() == 0) {
        return st2;
    }
    // If the second string is empty, return the first string
    if (st2.length() == 0) {
        return st1;
    }
    // If the first characters of both strings are equal
    if (st1.charAt(0) == st2.charAt(0)) {
        // Add the character to the result and call minimalSt on the remaining substrings
        return st1.charAt(0) + minimalSt(st1.substring(1), st2.substring(1));
    }
    // If the first characters are not equal
    // Find the minimal string by considering two cases:
    // 1. Including the first character of st1
    // 2. Including the first character of st2
    String res1 = st1.charAt(0) + minimalSt(st1.substring(1), st2);
    String res2 = st2.charAt(0) + minimalSt(st1, st2.substring(1));
    // Return the shorter of the two resulting strings
    return res1.length() < res2.length() ? res1 : res2;
}
