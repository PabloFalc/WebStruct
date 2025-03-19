import priority;

public class run {



    public static void main(String[] args){

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        
        queue.enqueue(1, 3);
        queue.enqueue(2, 1);
        queue.enqueue(3, 5);
        queue.enqueue(4, 2);
        queue.enqueue(5, 4);
        queue.enqueue(6, 2);
        queue.enqueue(7, 4);
        queue.enqueue(8, 1);
        queue.enqueue(9, 3);
        queue.enqueue(10, 5);
        // queue

        // queue.enqueue(3,1);
        // queue.enqueue(1,3);
        // queue.enqueue(8,7);
        
        // queue.enqueue(2,2);
        // queue.enqueue(2,1);
        // queue.enqueue(10,4);

        // queue.enqueue(90,8);
        // queue.enqueuePrioridade(1,5);
        // queue.enqueuePrioridade(2,2);
        // queue.enqueuePrioridade(3,3);
        // queue.enqueuePrioridade(4,4);
        
    
        
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

      
        

        //java DataStruct/priorityQueue/run.java
       
        
        
       
        

        
        // 8->2->6->4->9->1->7->5->10->3
        


    }
    
}
