class Solution {

    public String decodeString(String s) {

        // Stores repeat counts
        Stack<Integer> countStack = new Stack<>();

        // Stores previous strings
        Stack<StringBuilder> stringStack = new Stack<>();

        // Current string being built
        StringBuilder current = new StringBuilder();

        // Current number
        int num = 0;

        // Traverse every character
        for (char ch : s.toCharArray()) {

            // Build multi-digit number
            // Example:
            // "23"
            // num = 2
            // num = 2*10+3 = 23
            if (Character.isDigit(ch)) {

                num = num * 10 + (ch - '0');
            }

            // '[' means save current state
            else if (ch == '[') {

                countStack.push(num);

                stringStack.push(current);

                // Start fresh
                current = new StringBuilder();

                num = 0;
            }

            // Decode current part
            else if (ch == ']') {

                // Number of repetitions
                int repeat = countStack.pop();

                // Previous string
                StringBuilder previous = stringStack.pop();

                // Append current string repeat times
                while (repeat > 0) {

                    previous.append(current);

                    repeat--;
                }

                // Continue from previous string
                current = previous;
            }

            // Normal character
            else {

                current.append(ch);
            }
        }

        return current.toString();
    }
}