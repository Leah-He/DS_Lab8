import java.util.Comparator;

public class Customer
{

   int netWorth;
   int yearsWithCompany;
   int politeness;
    

   public Customer(int netWorth,int yearsWithCompany,int politeness)
   {
      this.netWorth = netWorth;
      this.yearsWithCompany = yearsWithCompany;
      this.politeness = politeness;
   }


/**
   compares clients based on thier net worth
*/
   public static class WorthComparator implements Comparator<Customer>
   {
   
   /**
      See https://docs.oracle.com/javase/7/docs/api/java/util/Comparator.html#compare(T,%20T)
      for full description.
   
   */
      public int compare(Customer c1, Customer c2)
      {
            return c1.netWorth - c2.netWorth;
      }
   
   }


/**
   compares clients based on thier loyalty 
*/
   public static class LoyaltyComparator implements Comparator<Customer>
   {
   
   /**
      See https://docs.oracle.com/javase/7/docs/api/java/util/Comparator.html#compare(T,%20T)
      for full description.
   
   */
      public int compare(Customer c1, Customer c2)
      {
    	  return c1.yearsWithCompany - c2.yearsWithCompany;
      }
   
   }



/**
   compares clients based on thier net worth.
   If there is a tie, politeness is used.
*/
   public static class WorthPoliteComparator implements Comparator<Customer>
   {
   
   /**
      See https://docs.oracle.com/javase/7/docs/api/java/util/Comparator.html#compare(T,%20T)
      for full description.
   
   */
      public int compare(Customer c1, Customer c2)
      {
    	  int nwcomp = c1.netWorth - c2.netWorth;
    	  if(nwcomp == 0) {
    		  return c1.politeness - c2.politeness;

    	  }
    	  return nwcomp;
      }
   
   }
	




}
