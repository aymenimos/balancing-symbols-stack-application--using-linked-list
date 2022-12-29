import java.util.Scanner;

class Node {

    char data;
    Node next;

}

public class stack {

    Node head;

    public void reciever() {
      
        Scanner get = new Scanner(System.in);
      
        System.out.println("enter the symbol: ");
      
        char newsymbol = get.next().charAt(0); 
        while (newsymbol == '(' || newsymbol == '[' || newsymbol == ')' || newsymbol == ']') { // invalid input

        checksymbol(newsymbol);
        } System.out.println("invalid entry");
        reciever();
    }

    
    private void checksymbol(char newsymbol) {

        if (newsymbol == '(' || newsymbol == '[') {
          
            push(newsymbol);                                 // first opening input

        }
        if (newsymbol == ')' || newsymbol == ']') {         // check if closing is entered
           
            if (head == null) {                             // check the stack and report error
                
                System.out.println(" closing not accepted the stack is empty ");
                
                return;

            } else {                                        // check the stack if not empty pop what you got
               
                Node store = head;                      // store the head to push back if not corect after
               
                pop();
               
                if (newsymbol == ']' && store.data == '(') {
               
                    System.out.println("not correct closing ( ]"); // check the poped symbol
               
                    push(store.data); // if not correct push back to compare
                                      // with the next input

                }
               
                if (newsymbol == ')' && store.data == '[') {            //check the new closing 
                                                                    // and the opening in the stack
                    System.out.println(" not correct closing [ )");
               
                    push(store.data);
                }
               
                if (newsymbol == ')' && store.data == '(') {       // correct closing ()
               
                    System.out.println(store.data + "" + "" + newsymbol + " balanced symbols");
               
                    checkstack();
               
                    System.exit(0);
               
                }
               
                if (newsymbol == ']' && store.data == '[') {   // correct closing []
               
                    System.out.println(store.data + "" + "" + newsymbol + " balanced symbols");
               
                    checkstack();               // see whats in the satck and report back
               
                  System.exit(0);

                }

            }

        }

    }

   
    private void push(char symbol) {
   
        Node newnode = new Node();
   
        newnode.data = symbol;

        if (head == null) {
   
            head = newnode;

        } else {
   
            newnode.next = head;
   
            head = newnode;
        }
   
        if (head.data == '(' || head.data == '[') {
   
            reciever();
   
        } 

    }

    private void pop() {
   
            Node pointer = head;
   
            System.out.println(head.data + " is poped");
   
            pointer = pointer.next;
   
            head = pointer;

        }

   
    private void checkstack() {
   
        if (head != null) {

            System.out.println("the stack is not empty");
            display();
            reciever();

        } else {
   
            System.out.println("the stack is empty");
   
        }

    }
    public void display() {
        Node pointer = head;
        if (head == null) {

        } else {
            while (pointer.next != null) {
                System.out.println(pointer.data);

                pointer = pointer.next;
            }
            System.out.println(" is left in the stack");
        }
    }

    
}
