import java.util.Stack;

class Node {
    int value;
    int minVal;
}
public class MinStack {
    Stack<Node> st; 
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int value) {
        Node n = new Node();
        int minVal = value;
        if (!st.isEmpty()) {
            minVal = Math.min(minVal, getMin());
        }
        n.value = value;
        n.minVal = minVal;

    }
    
    public void pop() {
        if (!st.isEmpty()) {
            st.pop();
        }
    }
    
    public int top() {
        if (st.isEmpty()) {
            return 0;
        }
        return st.peek().value;
    }
    
    public int getMin() {
        if (st.isEmpty()) {
            return 0;
        }
        return st.peek().minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */