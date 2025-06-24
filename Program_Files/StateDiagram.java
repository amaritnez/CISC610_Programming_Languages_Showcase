public class StateDiagram {
    // Enumerate the possible states in the state diagram
    private enum State {
        START, DIGITS_BEFORE_FRACTION, FRACTION, DIGITS_AFTER_FRACTION, EXPONENT_START, EXPONENT_SIGN, DIGITS_IN_EXPONENT, ERROR
    }

    // Function to determine if a given string is a floating-point literal
    public static boolean isFloatingPointLiteral(String s) {
        // Initialize state to start state
        State state = State.START;

        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // Determine which state we are in
            switch (state) {
                case START:
                    if (Character.isDigit(c) || c == '-') {
                        state = State.DIGITS_BEFORE_FRACTION;
                    } else {
                        state = State.ERROR;
                    }
                    break;
                case DIGITS_BEFORE_FRACTION:
                    if (Character.isDigit(c)) {
                        // Stay in this state
                    } else if (c == '.') {
                        state = State.FRACTION;
                    } else if (c == 'e' || c == 'E') {
                        state = State.EXPONENT_START;
                    } else {
                        state = State.ERROR;
                    }
                    break;
                case FRACTION:
                    if (Character.isDigit(c)) {
                        state = State.DIGITS_AFTER_FRACTION;
                    } else if (c == 'e' || c == 'E') {
                        state = State.EXPONENT_START;
                    } else {
                        state = State.ERROR;
                    }
                    break;
                case DIGITS_AFTER_FRACTION:
                    if (Character.isDigit(c)) {
                        // Stay in this state
                    } else if (c == 'e' || c == 'E') {
                        state = State.EXPONENT_START;
                    } else {
                        state = State.ERROR;
                    }
                    break;
                case EXPONENT_START:
                    if (c == '+' || c == '-') {
                        state = State.EXPONENT_SIGN;
                    } else if (Character.isDigit(c)) {
                        state = State.DIGITS_IN_EXPONENT;
                    } else {
                        state = State.ERROR;
                    }
                    break;
                case EXPONENT_SIGN:
                    if (Character.isDigit(c)) {
                        state = State.DIGITS_IN_EXPONENT;
                    } else {
                        state = State.ERROR;
                    }
                    break;
                case DIGITS_IN_EXPONENT:
                    if (Character.isDigit(c)) {
                        // Stay in this state
                    } else {
                        state = State.ERROR;
                    }
                    break;
                case ERROR:
                    // Remain in error state
                    break;
            }
        }

        // If the final state is an accepting state, the string is a floating-point literal
        return state == State.DIGITS_BEFORE_FRACTION || state == State.DIGITS_AFTER_FRACTION || state == State.DIGITS_IN_EXPONENT;
    }

    // Test the recognizer function
    public static void main(String[] args) {
        String[] testCases = {"3.14", "-2.0", "1.0E-3", "4.2e+10", "3.", ".4", "1e", "1e+", "1e-", "abc", "2..5", "1.2.3", "+-1.0"};
        // Iterate through each string in our test cases
        for (String testCase : testCases) {
            System.out.println(testCase + ": " + isFloatingPointLiteral(testCase));
        }
    }
}
