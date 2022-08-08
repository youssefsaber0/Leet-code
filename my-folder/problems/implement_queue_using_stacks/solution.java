class MyQueue {
    Stack<Integer> forward ;
    Stack<Integer> backward ;
    public MyQueue() {
        forward  = new Stack<>();
        backward = new Stack<>();
    }
    
    public void push(int x) {
        if(forward.isEmpty()){
            forward.push(x);
        }
        else{
           backward.push(x); 
        }
    }
    
    public int pop() {
        int val=forward.pop();
        if(forward.isEmpty()){
            while(!backward.isEmpty()){
                forward.push(backward.pop());
            }
        }
        return val;
    }
    
    public int peek() {
        return forward.peek();
    }
    
    public boolean empty() {
        return forward.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */