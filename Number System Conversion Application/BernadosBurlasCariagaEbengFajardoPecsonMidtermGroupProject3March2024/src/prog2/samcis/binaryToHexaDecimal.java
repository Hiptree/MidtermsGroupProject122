/**
 *
 * This method converts binary numbers into hexadecimal numbers by separating the binary number into 4-bit chunks (i.e 10001111 -> 1000 1111) and converts each
 *4-bit chunk into their corresponding hexadecimal equivalent before stringing them together to create the hexadecimal number. 
 (i.e 10001111 -> 1000 1111 -> 8 F -> 8F).
 * @param binary The binary string to be converted.
 * @return The hexadecimal representation of the binary string.
 */
public String binaryToHexadecimal(String binary) {
    // Define an array to store hexadecimal digits
    String[] hex = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

    // Initializes an empty string to store the result
    String result = "";

    // Pad the binary number with leading zeros to make its length a multiple of 4
    while (binary.length() % 4 != 0) {
        binary = "0" + binary; 
    }

    /* Convert each 4-bit chunk from a binary string to its hexadecimal equivalent.It converts each 4-bit chunk of the binary string into decimal first, 
    before getting its hexadecimal equivalent on the hex array above. 
    */
    
    for (int i = 0; i < binary.length(); i += 4) {
        // Extract a 4-bit chunk from the binary string
        String chunk = binary.substring(i, i + 4);
        
        // Convert the 4-bit binary chunk to decimal integer
        int decimal = Integer.parseInt(chunk, 2);
        
        // Append the corresponding hexadecimal digit to the result string
        result += hex[decimal];
    }

    // Return the final hexadecimal representation
    return result;
}
