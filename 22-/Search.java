import java.io.*;
import java.util.*;


public class Search{
    

    public Comparable lsearch(Comparable[] a, Comparable value){
	Arrays.sorts(a);
	for(int i = 0;i<a.length;i++){
	    if (a[i].compareTo(value) == 0){
		return a[i];
	    }
	}
	return null;
    }

    public static void main(String[] args){
	Random rnd = new Random();
	int[] ai = new int[10];
	for(int i = 0; i <ai.length;i++){
	    ai[i] = rnd.nextInt(100);
	}
	System.put.println(lsearch(ai,10));
	System.out.println(ai);

    }
}
