class Queue {
    int capacity;
    int front;
    int rear;
    int[] q;

    public Queue(int n) {
        q = new int[n];
        front = -1;
        rear = -1;
        capacity = n;
    }


    public String add(int n) {
        if((front == 0 && rear == capacity-1) || (rear+1)%capacity == front) {
            return "Add operation failed. Queue is full!";
        }
        if(front == -1) {
            q[++rear] = n;
            ++front;
        } else if(front != 0 && rear == capacity-1) {
            // reset rear to 0
            rear = 0;
            q[rear] = n;
        } else {
            q[++rear] = n;
        }
        String s = "";
        for(int i : q) {
            s += String.valueOf(i) +" ";
        }
        System.out.println("Queue: " + s);
        return "Successful add operation: " + String.valueOf(n) +"!";
    }

    public String remove() {
        if (front == -1) {
            return "Remove operation failed. Queue is empty!";
        }
        int data = q[front];
        q[front] = -1;
        if(rear == front) {
            // single element in queue
            rear = -1;
            front = -1;
        } else if (front == capacity-1) {
            // elelment to be removed is now at the end of queue, after removal reset the front to 0
            front = 0;
        } else {
            // simply remove element at ptr front and increment it
            front++;
        }
        String s = "";
        for(int i : q) {
            s += String.valueOf(i) +" ";
        }
        System.out.println("Queue: " + s);
        return "Successful remove operation: " + String.valueOf(data) + "!";
    }

    public static void main(String[] args) {
        Queue newQ = new Queue(3);
        System.out.println(newQ.add(1));
        System.out.println(newQ.add(2));
        System.out.println(newQ.add(3));
        System.out.println(newQ.add(4));
        System.out.println(newQ.remove());
        System.out.println(newQ.remove());
        System.out.println(newQ.add(4));
        System.out.println(newQ.add(5));
        System.out.println(newQ.remove());
        System.out.println(newQ.remove());
        System.out.println(newQ.remove());
        System.out.println(newQ.remove());
        
    }
}