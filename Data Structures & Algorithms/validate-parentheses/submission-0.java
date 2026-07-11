class Solution {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {

                stack.push(')');

            } else if (ch == '[') {

                stack.push(']');

            } else if (ch == '{') {

                stack.push('}');

            } else {

                if (stack.isEmpty() || stack.pop() != ch)
                    return false;
            }
        }

        return stack.isEmpty();
    }
} //need 1 more revision after week (today its 11july 2026)
//doubt that last block of else.