import java.io.*;
import java.util.*;

public class Driver2{
    public static void main(String[] args){
	Random rnd = new Random();
	//implement and comparTo were added to abstract Basechar class

	//Array
	Mage[] ma = new Mage[10];
	for(int i =0;i<ma.length;i++){
	    String name = "";
	    name += (char)('A' + rnd.nextInt(26));
	    ma[i] = new Mage();
	    ma[i].setName(name);
	}
	System.out.println(Arrays.toString(ma));
	Arrays.sort(ma);
	System.out.println(Arrays.toString(ma));

	//ArrayList
	ArrayList<Warrior> wl = new ArrayList<Warrior>();
	for(int i =0;i<10;i++){
	    String name = "";
	    name += (char)('A' + rnd.nextInt(26));
	    Warrior joe = new Warrior();
	    joe.setName(name);
	    wl.add(joe);
	}
	System.out.println(wl);
	Collections.sort(wl);
	System.out.println(wl);
      
    }
}
