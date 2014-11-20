import java.util.*;

public class Driver{

    public static void removeDupes(ArrayList<Integer> a){
	for(int i = a.size() - 1; i > 0;i--){
	    int n = a.get(i);
	    if (n == a.get(i -1)){
		a.remove(i-1);
	    }
	}
    }
    public static void main(String[] args){
	ArrayList<Integer> al = new ArrayList<Integer>();
	Random r =new Random();
	for (int i = 0;i<20;i++){
	    al.add(r.nextInt(5));
	}
	System.out.println(al);
	removeDupes(al);
	System.out.println(al);
    }
}
