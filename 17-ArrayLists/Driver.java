import java.util.*;

public class Driver{
    public static void main(String[] args){
	 Random r = new Random();
	//ARRAYLISTS
	ArrayList<Integer> al = new ArrayList<Integer>();
	System.out.println(al);
	for(int i=0;i<10000;i++){
	    al.add(i);
	}
	System.out.println(al);

	ArrayList<Integer> ret = new ArrayList<Integer>();
	System.out.println(ret);

	while (al.size()>0){
	    ret.add(al.remove(  r.nextInt(al.size()))  );
	}
	System.out.println(ret);
    

	//ARRAYS


	//working on it :(
        int[] a = new int[7];
	for (int i=0;i<7;i++){
	    a[i]=i;
	}
	int[] newArray = new int[a.length];
	int size = a.length -1;
	for(int i=0;i<a.length;i++){
	    int ran = r.nextInt(size);
	    newArray[ran] = i;
	    

	}

	for (int i=0;i<newArray.length;i++){
	    System.out.println(i + ": " +newArray[i]);
	}
    }   
}
