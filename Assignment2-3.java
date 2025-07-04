public class BinaryFormatException extends Exception {
    public BinaryFormatException(String message) {
        super(message);
    }
}

public class BinaryConverter {

    public static int bin2Dec(String binaryString) throws BinaryFormatException {
        for (int i = 0; i < binaryString.length(); i++) {
            char c = binaryString.charAt(i);
            if (c != '0' && c != '1') {
                throw new BinaryFormatException("Invalid binary string: " + binaryString);
            }
        }

        return Integer.parseInt(binaryString, 2);
    }
}

