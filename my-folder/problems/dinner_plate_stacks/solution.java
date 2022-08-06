class DinnerPlates {
PriorityQueue<Integer> indexies;
    List<Stack<Integer>> stacks;
    int capacity;
    public DinnerPlates(int capacity) {
        indexies = new PriorityQueue<>();
        this.stacks = new ArrayList<Stack<Integer>>();
        stacks.add(new Stack<Integer>());
        this.capacity=capacity;
    }
    
    public void push(int val) {
        while(!indexies.isEmpty()&&indexies.peek()>=stacks.size()){
            indexies.poll();
        }
        if(!indexies.isEmpty()){
            stacks.get(indexies.peek()).add(val);
            if( stacks.get(indexies.peek()).size()==capacity){
                indexies.poll();
            } 
        }
        else{
            stacks.get(stacks.size()-1).add(val);
            if(stacks.get(stacks.size()-1).size()==capacity){
                stacks.add(new Stack<>());
            }
        }

    }
    public int pop() {
        System.out.println(stacks.size()-1);
        System.out.println(stacks.size()>1);
        while(stacks.get(stacks.size()-1).isEmpty()&&stacks.size()>1){
            // Calculate index of last element
            int index = stacks.size() - 1;
            // Delete last element by passing index
            stacks.remove(index);
        }
        if(stacks.get(stacks.size()-1).empty()){
            return -1;
        }
        return stacks.get(stacks.size()-1).pop();
        
    }
    
    public int popAtStack(int index) {
        if(index>stacks.size()-1){
            return -1;
        }
        Stack<Integer> st=stacks.get(index);
        if(!indexies.contains(index))
            indexies.add(index);
        if(st.isEmpty()){
            return -1;
        }
        return st.pop();
        
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */