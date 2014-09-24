//worked in class with Fanny Ma

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


/* Sorry Fanny I accidentally didn't add the file from class and homers not working so I rewrote them */

//working
    public boolean nearHundred(int n) {
        if ((90 <= n && n <= 110) || (190 <= n && n<= 210)) {
            return true;
        } else {
            return false;
        }
    }
    
//working
    public boolean mixStart(String str) {
        if (str.length() < 1) return false;
            return str.substring(1).startsWith("ix");
    }  
    
//working
    public int teaParty(int tea, int candy) {
       if (tea < 5 || candy < 5) {
            return 0;
        } else if (tea*2 <=  candy || candy*2 <= tea) {
            return 2;
        } else {
            return 1;
        }
    }
    
//working
    public boolean lastDigit(int a, int b, int c) {
        int newA = a % 10;
        int newB = b % 10;
        int newC = c % 10;
        if (newA == newB || newA == newC || newB == newC) {
            return true;
        } else {
            return false;
        }
    }
}
 
