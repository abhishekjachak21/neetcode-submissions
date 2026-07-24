class StockSpanner {

    private static class Pair {
        int price;
        int index;

        Pair(int price, int index) {
            this.price = price;
            this.index = index;
        }
    }

    Stack<Pair> stack;
    int index;

    public StockSpanner() {
        stack = new Stack<>();
        index = -1;
    }

    public int next(int price) {

        index++;

        while (!stack.isEmpty() && stack.peek().price <= price) {
            stack.pop();
        }

        int span;

        if (stack.isEmpty()) {
            span = index + 1;   //it was confusing a lot
        } else {
            span = index - stack.peek().index;
        }

        stack.push(new Pair(price, index));

        return span;
    }
}

/* In simple manner =>
while (top.price <= currentPrice)
    pop();

span = stack.isEmpty()
        ? index + 1
        : index - stack.peek().index;

stack.push(current);
*/

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */