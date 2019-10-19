package Stack;

import java.util.ArrayList;
import java.util.List;

class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }

    /**
     * initialize your data structure here.
     */
    List<Integer> minStack = new ArrayList<Integer>();
    int top;
    int min;

    public MinStack() {
        min = Integer.MAX_VALUE;
        top = -1;

    }

    public void push(int x) {
        minStack.add(x);
        top++;
        if (min > x) {
            min = x;
        }
    }

    public void pop() {
        if(min==minStack.get(top)){
            min=Integer.MAX_VALUE;
        }
            minStack.remove(top);
            top--;


        for (int i = 0; i < minStack.size(); i++) {
            if (min > minStack.get(i)) {
                min = minStack.get(i);
            }
        }

    }

    public int top() {
        return minStack.get(top);
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */