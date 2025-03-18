package deque;

public class run{


    public static void main(String[] args){


        Deque<Integer> deque = new Deque<>();


        deque.enqueueRigth(2);
        deque.enqueueRigth(4);
        deque.enqueueLeft(1);
        deque.enqueueRigth(6);
        deque.enqueueLeft(3);
        deque.enqueueLeft(5);
        deque.enqueueRigth(8);
        deque.enqueueLeft(7);
        deque.enqueueRigth(10);
        deque.enqueueLeft(9);
        deque.enqueueLeft(11);
        deque.enqueueRigth(12);

        
        deque.dequeueRigth();
        deque.dequeueRigth();
        deque.dequeueRigth();
        deque.dequeueRigth();
        deque.dequeueRigth();
        deque.dequeueRigth();
        
    
        

    }

}