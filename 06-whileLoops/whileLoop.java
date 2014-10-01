
public class whileLoop {

//5 min
    public String frontTimes(String str, int n) {
	String front = "";
	if (str.length() < 3) {
	    front = str;
	} else {
	    front = str.substring(0,3);
        }
	String ans = "";
	while (n > 0) {
	    ans = ans + front;
	    n = n - 1;
	}
	return ans;
    }
  
//3 min
    public String stringBits(String str) {
	int n = 0;
	String ans = "";
	while ( n < str.length()) {
	    ans += str.charAt(n);
	    n += 2;
	}
	return ans;
    }

//17 min
    public String stringYak(String str) {
	String ans = "";
	int n = 0;
	while (n < str.length()) {
	    char c = str.charAt(n);
	    char k = ' ';
	    if (str.length() > (n + 2)){  
		k = str.charAt(n + 2);
	    }
	    if (c == 'y' && k == 'k') {
		n += 2;
	    } else {
		ans += c;
	    }
	    n += 1;
	}
	return ans;
    }

//8 min
    public int stringMatch(String a, String b) {
	int len = 0;
	if (a.length() > b.length()) {
	    len = b.length();
	} else {
	    len = a.length();
	}
	int ans = 0;
	int n = 0;
	while (n + 1 < len){
	    String aTwo = a.substring(n,n+2);
	    String bTwo = b.substring(n,n+2);
	    if (aTwo.equals(bTwo)){
		ans += 1;
	    }
	    n += 1;
	}
	return ans;
    }
    
}
