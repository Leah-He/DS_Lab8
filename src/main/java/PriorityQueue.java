import java.util.Comparator;

public class PriorityQueue<T> extends Queue<T>
{

   Comparator<T> compare;

   public PriorityQueue(Comparator<T> comp)
   {
      compare = comp;
   }


    //@Override
   public void push(T val)
   {
       //super.push(val); //right now this is just a normal Queue as it will do what its parent did.
	   //建立一个新节点
	   Node node = new Node(val);
	   if (isEmpty()) {
		   head = node;
		   tail = node;
		   return; //?
	   }
	   
	   //检查优先级如果比头部节点高，则插到head
	   if (compare.compare(val, head.value) > 0) {
		   node.next = head;
		   head = node;
		   return;
	   }
	   
	   //find the position
	   Node curr = head;
	   while(curr.next != null && compare.compare(val, curr.next.value) <= 0) {
		   curr = curr.next;
	   }
	   node.next = curr.next;
	   curr.next = node;
	   
	   //
	   if (node.next == null) {
		   tail = node;
	   }	   
   }
}
