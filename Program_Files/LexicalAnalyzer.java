/* Front.java - a lexical analyzer system for simple
             arithmetic expressions */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* Global declarations */
/* Variables */
public class Front {

    // This fails, how do we convert EOF to Java?!
    public static final String EOF = "\u001a";

    public static int charClass;
    public static String lexeme = "";
    public static char nextChar;
    public static int lexLen;
    public static int token;
    public static int nextToken;
    public static BufferedReader in_fp;
    /* Function declarations */
    public static void addChar() {
        if (lexLen <= 98) {
            lexeme += nextChar;
            lexLen++;
            lexeme += '\0';
        } else
            System.out.println("Error - lexeme is too long");
    }
    public static void getChar() throws IOException {
        int nextCharInt = in_fp.read();
        nextChar = (nextCharInt == -1) ? '\0' : (char)nextCharInt;
        if (Character.isAlphabetic(nextChar))
            charClass = LETTER;
        else if (Character.isDigit(nextChar))
            charClass = DIGIT;
        else
            charClass = UNKNOWN;
    }
    public static void getNonBlank() throws IOException {
        while (Character.isWhitespace(nextChar))
            getChar();
    }
    public static int lookup(char ch) {
        switch (ch) {
        case '(':
            addChar();
            nextToken = LEFT_PAREN;
            break;
        case ')':
            addChar();
            nextToken = RIGHT_PAREN;
            break;
        case '+':
            addChar();
            nextToken = ADD_OP;
            break;
        case '-':
            addChar();
            nextToken = SUB_OP;
            break;
        case '*':
            addChar();
            nextToken = MULT_OP;
            break;
        case '/':
            addChar();
            nextToken = DIV_OP;
            break;
        default:
            addChar();
            nextToken = EOF;
            break;
        }
        return nextToken;
    }
    /* Character classes */
    public static final int LETTER = 0;
    public static final int DIGIT = 1;
    public static final int UNKNOWN = 99;

    /* Token codes */
    public static final int INT_LIT = 10;
    public static final int IDENT = 11;
    public static final int ASSIGN_OP = 20;
    public static final int ADD_OP = 21;
    public static final int SUB_OP = 22;
    public static final int MULT_OP = 23;
    public static final int DIV_OP = 24;
    public static final int LEFT_PAREN = 25;
    public static final int RIGHT_PAREN = 26;

    /******************************************************/
    /* main driver */
    public static void main(String[] args) {
        /* Open the input data file and process its contents */
        try {
            in_fp = new BufferedReader(new FileReader("front.in"));
            getChar();
            do {
                lex();
            } while (nextToken != EOF);
        } catch (IOException e) {
            System.err.println("ERROR - cannot open front.in");
        }
    }

    /*****************************************************/
    /* lex - a simple lexical analyzer for arithmetic
             expressions */

    /* lex - a simple lexical analyzer for arithmetic
         expressions */
    public static int lex() throws IOException {
        lexLen = 0;
        getNonBlank();
        switch (charClass) {
        // Parse identifiers
        case LETTER:
            addChar();
            getChar();
            while (charClass == LETTER || charClass == DIGIT) {
                addChar();
                getChar();
            }
            nextToken = IDENT;
            break;

        // Parse integer literals
        case DIGIT:
            addChar();
            getChar();
            while (charClass == DIGIT) {
                addChar();
                getChar();
            }
            nextToken = INT_LIT;
            break;

        // Parentheses and operators
        case UNKNOWN:
            lookup(nextChar);
            getChar();
            break;

        // EOF
        case EOF:
            nextToken = EOF;
            lexeme[0] = 'E';
            lexeme[1] = 'O';
            lexeme[2] = 'F';
            lexeme[3] = '\0';
            break;
        }
        System.out.printf("Next token is: %d, Next lexeme is %s\n",
                          nextToken, lexeme);
        return nextToken;
    } /* End of function lex */
}