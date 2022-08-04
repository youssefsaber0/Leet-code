class MinStack {
    Stack<Integer> real;
    Stack<Integer> min;
    public MinStack() {
        real = new Stack<>();
        min = new Stack<>();
    }
    boolean compare(int a,int b){
        return a<=b;
    }
    public void push(int val) {
        if(min.empty()||compare(val,min.peek())){
            real.push(val);
            min.push(val); 
        }
        else{
            real.push(val);
            min.push(min.peek());  
        }
    }
    
    public void pop() {
        real.pop();
        min.pop();  
    }
    
    public int top() {
        return real.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */