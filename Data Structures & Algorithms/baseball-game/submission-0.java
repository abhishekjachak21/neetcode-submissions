class Solution {
    public int calPoints(String[] operations) {
        
    //   Stack<Integer> stk = new Stack<>(); //old hogya bhai ye
      Deque<Integer> stk = new ArrayDeque<>();

      for(String str : operations){

        if(str.equals("+")){

        int top = stk.pop();
        int prevSum = stk.peek() + top;
 
         stk.push(top);
         stk.push(prevSum);

        }

        else if(str.equals("C")) stk.pop();

        else if(str.equals("D"))
          stk.push(stk.peek()*2);

        else {
            stk.push(Integer.parseInt(str));
        }

      }

      int sum = 0;

      while(!stk.isEmpty()) sum += stk.pop();

      return sum;

    }
}