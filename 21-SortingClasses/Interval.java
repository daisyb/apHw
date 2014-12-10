import java.util.*;
public class Interval{
    private int[] interval = new int[2];
    private Random rnd = new Random(); 
    private int low, high;
 
    public Interval(int l, int h){
	low = l;
	high = h;
	interval[0] = low;
	interval[1] = high;
    }
    public Interval(){
	high = rnd.nextInt(41) - 20;
	low = rnd.nextInt(41) - 20;
	if (low > high){
	    int n = low;
	    low = high;
	    high = n;
	}

	interval[0] = low;
	interval[1] = high;
    }

    public String toString(){
	return "[" +low+" ," + high+"]";
    }
    public int getLow(){
	return low;
    }
    public int getHigh(){
	return high;
    }
    
    public int compareTo(Interval other){
	int Ldif = low - other.getLow();
	int Hdif = high - other.getHigh();
	if (Ldif == 0){
	    return Hdif;
	} else {
	    return Ldif;
	}
    }



    public static void main(String args[]){
	// Interval[] INT = new Interval[10];
	// for (int i=0; i<10; i++){
	//     INT[i] = new Interval();
	//     System.out.println(INT[i]);
	// }
	Interval a = new Interval(), b = new Interval();
	System.out.println(a);
	System.out.println(b);
	System.out.println(a.compareTo(b));
    }
}
