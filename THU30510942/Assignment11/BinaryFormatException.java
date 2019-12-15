public class BinaryFormatException extends Exception {
    private static final long serialVersionUID = 1L;
    String binaryString;
    BinaryFormatException() { }
    BinaryFormatException(String binaryString) {
        super("Invalid binary string " + binaryString);
        this.binaryString = binaryString;
    }
    public static String binaryToHexadecimal(String binaryString) throws BinaryFormatException {
        int len = binaryString.length();
        for (int i = 0; i < len; ++i) {
            if (binaryString.charAt(i)!= '0' && binaryString.charAt(i) != '1') {
                throw new BinaryFormatException(binaryString);
            }
        }
        int value = Integer.parseInt(binaryString, 2);
        String result = Integer.toHexString(value).toUpperCase();
        return result;
    }
    public static void main (String[] args) {
        String binaryString = "10002";
        try {
            System.out.println(binaryToHexadecimal(binaryString));
        } catch (BinaryFormatException e) {
            e.printStackTrace();
        }
    }
}