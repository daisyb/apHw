import java.util.*;

public class Driver{
    public static void main(String[] args){
	Random r = new Random();
	int len = 7;
	
	if(args.length == 0){
	    System.out.println("put in args: choose al(arrayList) or a(array)");
	    System.exit(0);
	}
	String choice = args[0];
	if (args.length > 1){
	    len = Integer.parseInt(args[1]);
	}
	
	if(choice.equals("al")){

	    //ARRAYLISTS
	    ArrayList<Integer> al = new ArrayList<Integer>();
	    for(int i=0;i<len;i++){
		al.add(i);
	    }
	    //   System.out.println(al);

	    ArrayList<Integer> ret = new ArrayList<Integer>();
	    while (al.size()>0){
		ret.add(al.remove( r.nextInt(al.size()))  );
	    }
	    al = ret;
	    //	    System.out.println(al);
	} else {    

	    //ARRAYS
	    int[] a = new int[len];
	    for (int i=0;i<a.length;i++){
	        a[i]=i;
	    }

	    int[] newA = new int[a.length];
	    // boolean used;
	    // for(int i = 0; i<a.length;i++){
	    //     used = false;
	    //     while(used == false){
	    // 	    int index = r.nextInt(a.length);
	    // 	    if (a[index] != -1){
	    // 		newA[i] = a[index];
	    // 		a[index] = -1;
	    // 		used = true;
	    // 	    }
	    //     }
	    // }
	    int n = 0;
	    while(n <a.length){
		int index = r.nextInt(a.length);
		if (a[index] != -1){
		    newA[n] = a[index];
		    a[index] = -1;
		    n +=1;
		}
	    }

	    a = newA;

	    for (int i=0;i<a.length;i++){
	        System.out.println(i + ": " +a[i]);
	    }
	}

	/*
	  The ArrayList method takes longer than 
	  the one I wrote for Arrays.
	  Up until lengths in the 10,000's the difference is
	  barely noticible, however:	  
	  At length 100,000  ArrayList time = 1.12s,
	                     Array     time = 0.16s
	  By length 300,000 the ArrayList time is close to 10s,
	  While the Array time does not reach 10s until
	  length 7,000,000.

	  space wise they're probably similar since both are storing two arrays of the same
	  length, which isn't optimal, but doesn't seem all that bad either.
        */
    }   
}
