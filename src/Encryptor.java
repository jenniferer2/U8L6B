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
            }
        }
        if (str.length() < numRows * numCols) {
            for (int r = 0; r < letterBlock.length; r++) {
                for (int c = 0; c < letterBlock[0].length; c++) {
                    if (letterBlock[r][c] == null) {
                        letterBlock[r][c] = "A";
                    }
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
  ;
       for (int i = 0; i < message.length(); i = numRows*numCols + i ) {
           fillBlock(message.substring(i));
           result = result + encryptBlock();


       }


        return result;


    }

}

