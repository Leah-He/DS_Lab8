public class Queue<T>
{
    //be sure that your attributes are protected, so subclasses can use them
	protected Node head;
	protected Node tail;
	
	protected class Node {
		T value;
		Node next;
		
		Node(T value){
			this.value = value;
			this.next = null; 
		}
	}
	
	

   public Queue()
   {
	   head = null;
	   tail = null;
	   
   
   }


    /**Adds val to the end of the queue
     */
   public void push(T val)
   {
	   Node node1 = new Node(val);
	   
	   if (isEmpty()) {
		   head = node1;
		   tail = node1;
		   
	   } else {
		   tail.next = node1;
		   tail = node1; //should update the tail!!
	   }
   
   }


    /**
       removes and returns the oldest value in the queue
       throws QueueUnderFlowException if the queue is empty
     */
   public T pop()
   {
	   if (isEmpty()) {
		   throw new QueueUnderFlowException();
	   }
	   T headval = head.value;
	   head = head.next;
	   
	   if (head == null) { //check the case if head become null, tail also should be null
		  tail = null; 
	   }
	   
       return headval;
   }    


    /**
      returns true if the queue is empty
     */

   public boolean isEmpty()
   {
	   if (head == null) {
		   return true;
	   } else {
       return false;
	   }
   }

}
