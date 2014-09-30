
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
}
