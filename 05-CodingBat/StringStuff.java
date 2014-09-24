//hw 5, 9/24/14

public class StringStuff {
	
//nonstart
	public String nonStart(String a, String b) {
  		String newA = a.substring(1);
  		String newB = b.substring(1);
  		return newA + newB;
	}

//makeABBA
	public String makeAbba(String a, String b) {
   		return a + b + b + a;
  
	}

//diff21
	public int diff21(int n) {
   		int absDiff = Math.abs(n - 21);
   		if (n <= 21) {
      			return absDiff;
   		} else {
     			 return 2 * absDiff;
      		}
	}

}
 
