import java.util.Arrays;

public class Encryptor {
    /**
     * A two-dimensional array of single-character strings, instantiated in the constructor
     */
    private String[][] letterBlock;

    /**
     * The number of rows of letterBlock, set by the constructor
     */
    private int numRows;

    /**
     * The number of columns of letterBlock, set by the constructor
     */
    private int numCols;

    /**
     * Constructor
     */
    public Encryptor(int r, int c) {
        letterBlock = new String[r][c];
        numRows = r;
        numCols = c;
    }

    public String[][] getLetterBlock() {
        return letterBlock;
    }

    /**
     * Places a string into letterBlock in row-major order.
     *
     * @param str the string to be processed
     *            <p>
     *            Postcondition:
     *            if str.length() < numRows * numCols, "A" in each unfilled cell
     *            if str.length() > numRows * numCols, trailing characters are ignored
     */
    public void fillBlock(String str) {
        int i = 0;
        for (int r = 0; r < letterBlock.length; r++) {
            for (int c = 0; c < letterBlock[0].length; c++) {
                if (i != str.length()) {
                    letterBlock[r][c] = str.substring(i, i + 1);
                    i++;
                }
                else {
                    letterBlock[r][c] = "A";
                }
            }
        }



    }

    /**
     * Extracts encrypted string from letterBlock in column-major order.
     * <p>
     * Precondition: letterBlock has been filled
     *
     * @return the encrypted string from letterBlock
     */
    public String encryptBlock() {
        String result = "";
        for (int c = 0; c < numCols; c++) {
            for (int r = 0; r < numRows; r++) {
                result = result + letterBlock[r][c];


            }
        }
        return result;
    }

    /** Encrypts a message.
     *
     *  @param message the string to be encrypted
     *
     *  @return  the encrypted message; if message is the empty string,
     *           returns the empty string
     */
    public String encryptMessage(String message)
    {

        String result = "";
        for (int i = 0; i < message.length(); i = numRows*numCols + i ) {
            fillBlock(message.substring(i));
            result = result + encryptBlock();


        }


        return result;


    }
    /**  Decrypts an encrypted message. All filler 'A's that may have been
     *   added during encryption will be removed, so this assumes that the
     *   original message (BEFORE it was encrypted) did NOT end in a capital A!
     *
     *   NOTE! When you are decrypting an encrypted message,
     *         be sure that you have initialized your Encryptor object
     *         with the same row/column used to encrypted the message! (i.e.
     *         the “encryption key” that is necessary for successful decryption)
     *         This is outlined in the precondition below.
     *
     *   Precondition: the Encryptor object being used for decryption has been
     *                 initialized with the same number of rows and columns
     *                 as was used for the Encryptor object used for encryption.
     *
     *   @param encryptedMessage  the encrypted message to decrypt
     *
     *   @return  the decrypted, original message (which had been encrypted)
     *
     *   TIP: Feel free to create other helper methods as you see fit
     *        (e.g. a method to decrypt each section of the decrypted message)
     */
    public String decryptMessage(String encryptedMessage)
    {
        String result = "";
        String h = encryptedMessage;
        for (int i = 0; i < encryptedMessage.length(); i =  numRows*numCols + i) {


         String s = encryptedMessage.substring(i, numRows*numCols + i);
          result = result + decrypt2(s);

}
        result = removeA(result);


        return result;

    }

    public String decrypt2 (String en) {
        String x [][] = new String [numRows][numCols] ;
        int i = 0;
        for (int c = 0; c < numCols; c++) {
            for (int r = 0; r < numRows; r++) {

                    x[r][c] = en.substring(i, i + 1);
                    i++;

            }
        }
        String res = "";

        for (int r = 0; r < x.length;r++) {
            for (int c = 0; c < x[0].length; c++) {

                    res = res + x[r][c];


            }
        }

        return res;

    }
    public String removeA (String d) {
        int g =0;
        String newn = d;
        String hold = newn.substring(newn.length()-1);

        while(hold.equals("A")) {
            hold = newn.substring(newn.length() -1);
            if (hold.equals("A")) {
                newn = newn.substring(0, newn.length()-1);
            }


        }
        return newn;





}
}
