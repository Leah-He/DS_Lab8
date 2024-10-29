import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerComparatorTesting {
	private Customer c1, c2, c3, c4, c5, c6;
	private Customer.WorthComparator worthComp;
	private Customer.LoyaltyComparator loyaltyComp;
	private Customer.WorthPoliteComparator WPComp;
	private PriorityQueue<Customer> priorityQ;
	
	

	@BeforeEach
	void setUp() throws Exception {
		c1 = new Customer(10000, 3, 10);
		c2 = new Customer(10000, 2, 15);
		c3 = new Customer(20000, 2, 5); 
		c4 = new Customer(10000, 3, 10);
		
		
		
	}

	@Test
	void test() {
		
		//Test worthComp:
		worthComp = new Customer.WorthComparator();
			//which one is larger
		assertTrue(worthComp.compare(c1, c3) < 0); //C3 should be higher
			//equals:
		assertEquals(0, worthComp.compare(c1, c2));
		
		//Test loyalty:
		loyaltyComp = new Customer.LoyaltyComparator();
		assertTrue(loyaltyComp.compare(c1, c2) > 0);
		assertEquals(0, loyaltyComp.compare(c1, c4));
		
		
		//Test WPComp:
		WPComp = new Customer.WorthPoliteComparator();
	
		
		assertEquals(0, WPComp.compare(c1, c4)); //under same nw
		
		//test nw:
		//assertTrue(WPComp.compare(c3, c2) > 0); //C3 NW is higher
		assertTrue(WPComp.compare(c1, c3) < 0); //C3 should be higher
		assertEquals(0, worthComp.compare(c1, c2));
		assertTrue(WPComp.compare(c1, c2) < 0);//p of C2 is higher
		
		
		
		
		
	//test PQ:
		//worthComp:
		priorityQ = new PriorityQueue<>(worthComp);
		priorityQ.push(c1);
		
		//assertEquals(c1, priorityQ.head.value);
		
        priorityQ.push(c2);
        //assertEquals(c1, priorityQ.head.value);
        
        priorityQ.push(c3);
        //assertEquals(c3, priorityQ.head.value); //nw of c3 is the highest one 
        
        	//pop based on networth:
        assertEquals(c3, priorityQ.pop()); 
        assertEquals(c1, priorityQ.pop()); //c1 and c2 are the same but c1 in the Q first
        assertEquals(c2, priorityQ.pop());
        
        
        //LoyaltyComparator
        priorityQ = new PriorityQueue<>(loyaltyComp);
        priorityQ.push(c1);
        //assertEquals(c1, priorityQ.head.value); // c1 should be the head
        
        priorityQ.push(c2);
        //assertEquals(c1, priorityQ.head.value); // c1 should still be the head
        
        priorityQ.push(c3);
        //assertEquals(c1, priorityQ.head.value); // c1 should be the head
     
        
        //pop based on yearsWithcompany
        assertEquals(c1, priorityQ.pop()); 
        assertEquals(c3, priorityQ.pop()); 
        assertEquals(c2, priorityQ.pop());
		
        // WorthPoliteComparator
        //compares clients based on nw and then if they are the same see politeness
        priorityQ = new PriorityQueue<>(WPComp);
        priorityQ.push(c1);
        //assertEquals(c1, priorityQ.head.value);
        
        priorityQ.push(c2);
        //assertEquals(c2, priorityQ.head.value);//p is higher than C1
        
        priorityQ.push(c3);
        //assertEquals(c3, priorityQ.head.value); //nw of c3 is highest

        //pop based WPcomp
        assertEquals(c3, priorityQ.pop()); // c3 netWorth is higheast
        assertEquals(c2, priorityQ.pop()); // c2 netWorth same but politeness is higher
        assertEquals(c1, priorityQ.pop()); 
	}

}
