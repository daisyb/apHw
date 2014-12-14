import java.io.*;
import java.util.*;


public class Search{
    private Comparable[] a;

    public Search(int len){
	a = new Comparable[len];
    }
    
    public String toString(){
	String s = ("[");
	for(int i = 0; i <a.length;i++){
	    s +=a[i] + ", ";
	}
	return s + "]\n";
    }

    public void addTerm(int index, Comparable c){
	a[index] = c;
    }
    
    public void sort(){
	Arrays.sort(a);
    }

    public Comparable lsearch(Comparable item){
	sort();
	for(int i = 0;i<a.length;i++){
	    if (a[i].compareTo(item) == 0){
		return a[i];
	    }
	}
	return null;
    }

    public Comparable bsearch(Comparable item){
	sort();
	int high = a.length;
	int low = 0;
	while ((high - low) > 0){
	    int mid = (high +low)/2;
	    int compare = a[mid].compareTo(item);
	    if (compare == 0){
		return a[mid];
	    } else if (compare > 0){
		high = mid -1;
	    } else {
		low = mid + 1;
	    }
	}
	return null;
    }
    public Comparable rbsearch(Comparable item,int high, int low){
	if ((high - low) < 0){
	     return null;
	}
	int mid = (high +low)/2;
	int compare = a[mid].compareTo(item);
	if (compare == 0){
	    return a[mid];
	} else if (compare > 0){
	    return rbsearch(item, mid -1,low);
	} else {
	    return rbsearch(item,high,mid+1);
	}
    }

    public Comparable rbsearch(Comparable item){
	sort();
	return rbsearch(item,a.length,0);
    }


	
    public static void main(String[] args){
	Random rnd = new Random();
	Search s = new Search(10);
	for(int i = 0; i < 10;i++){
	    s.addTerm(i,rnd.nextInt(15));
	}
	s.sort();
	System.out.println(s);
	System.out.println(s.rbsearch(5));
	
    }
}
