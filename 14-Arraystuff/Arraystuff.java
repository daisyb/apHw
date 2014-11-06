import java.util.*;

public class Arraystuff {
    private int[] a;
    private Random rnd;


    public Arraystuff(int n){
	rnd = new Random();
	a = new int[n];
	for (int i=0;i<a.length;i++){
	    a[i] = 0+rnd.nextInt(21);
	}
    }
    
    public Arraystuff() {
	    this(50000000);
    }

    public String toString(){
	String s="";
	for (int i=0;i<a.length;i++){
	    s=s+a[i]+", ";
	}
	return s;
    }

    public int find(int value){
	for (int i = 0; i < a.length;i++){
	    if (a[i] == value){
		return i;
	    }
	}
	return -1;

    }

    public int maxVal(){
	int n = a[0];
	for (int i =0; i <a.length; i++){
	    if (a[i] > n){
		n = a[i];
	    }
	}
	return n;
    }

    public int maxVal(int[] a){
	int n = a[0];
	for (int i =0; i <a.length; i++){
	    if (a[i] > n){
		n = a[i];
	    }
	}
	return n;
    }

    public int freq(int index){
	int n = a[index];
	int count = 0;
	for (int i = 0;i < a.length;i++){
	    if (a[i] == n){
		count += 1;
	    }
	}
	return count;
    }

    public int freqNum(int n){
        int count = 0;
	for (int i = 0;i < a.length;i++){
	    if (a[i] == n){
		count += 1;
	    }
	}
	return count;
    }


    public int mode(int[] a){
	int count = 0;
	int mode = a[0];
	for (int i =0;i<a.length;i++){
	    if (freq(i) > count){
		count = freq(i);
		mode = a[i];
	    }
	}
	System.out.println(mode);
	return count;
    }

    public int betterMode(int[] a){
	int[] freqArray = new int[maxVal(a) + 1];
	for(int i = 0;i<a.length;i++){
	    int n = a[i];
	    freqArray[n] += 1;
	}
	int modeCount =maxVal(freqArray);
	for (int i =0; i<freqArray.length;i++){
	    if (freqArray[i] == modeCount){
		System.out.println("mode:" + i);
	    }
	}
	return modeCount;
    }

    public static void main(String[] args) {
	int n= 100;
	if (args.length > 0){
	    n = Integer.parseInt(args[0]);
	}
	
	Arraystuff as = new Arraystuff(n);
	int modeType = 1;
	if (args.length > 1){
	    modeType = Integer.parseInt(args[1]);
        }
	    
	if (modeType == 1){
	    System.out.println("fast mode");
	    System.out.println(as.betterMode(as.a));
	}
	if (modeType == 2){
	    System.out.println("slow mode");
	    System.out.println(as.mode(as.a));
	}
	/*

	System.out.println();
	System.out.println(as.find(100));
	System.out.println(as.maxVal());  
	System.out.println(as.freq(2));	
	System.out.println();
	*/
	//System.out.println(as);
	//System.out.println(as.mode(as.a));
	//System.out.println("other mode method");
	//System.out.println(as.betterMode(as.a));
    }
}
