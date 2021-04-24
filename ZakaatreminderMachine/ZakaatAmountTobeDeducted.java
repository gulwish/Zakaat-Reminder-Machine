package ZakaatreminderMachine;


public class ZakaatAmountTobeDeducted {
    double tempBalance;
    Q_Node front, rear;
    public int nItems; // number of items or//current size

    //class to define linked node
    static class Q_Node {
        double balance;
        Q_Node next;

        public Q_Node(double balance) {
            this.balance = balance;
        }
    }

    //Zero argument constructor
    public ZakaatAmountTobeDeducted() {
        super();
        front = null;
        rear = null;
        nItems = 0;
        //  rear=front;
        // front = rear;
    }

//--------------------------------------------
    //Remove item from the beginning of the list.
    public double pop()  throws  RuntimeException{


        try {
            tempBalance = front.balance;
            front = front.next;// next in the line comes forward and become front of queue

            //dec size
            nItems--;
            System.out.println(tempBalance + " removed from the queue");
            return tempBalance;
        }
        catch( RuntimeException e ){
                System.out.println(" underflow");
            }
       return  -1;
    }

    //--------------------------------------------
    //Add balance to the end (rear part )of the list.
    //--------------------------------------------
    public void push(double bal) {

        Q_Node newRear = new Q_Node(bal);

        if (front==null) {//front ==null
            // front = rear;
            front = newRear;
            rear = newRear;
            nItems++;
            System.out.println(bal + " added to the queue");
        } else {
            rear.next = newRear;
            rear = newRear;
            nItems++;
            System.out.println(bal + " added to the queue");
        }


    }//--------------------------------------------

    double peek() {
        if (isEmptyList()) return 0;
        return this.rear.balance;
    }
    //--------------------------------------------
    void display() {

        Q_Node current = front;
        if (front == null) {
            System.out.println("List is empty");

        } else {
            System.out.println(" list of Nodes: ");
            while (current != null) {
                System.out.print(current.balance + " ->");
                current = current.next;
            }
            System.out.println();
        }
    }
    //--------------------------------------------
    public Boolean isEmptyList() {
        return (nItems == 0);
    }

    //--------------------------------------------

    public Boolean isEmpty() {

        return front == null;
    }
    //--------------------------------------------
}
