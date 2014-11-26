public class Sarray {

/*------------ Instance Variables -------------*/
    private int[] data;
    private int length; //# of elements


/*------------ Constructors -------------*/
    public Sarray() {
	data = new int[4];
	length = 0;
    }


/*------------ Methods -------------*/
    public String toString() {
	String s = "";
	for (int i=0;i<length;i++) {
	    s += i+": "+data[i] + "\n";
	}
	return s;
    }

    private void grow() {
	if (length >= data.length){
	    int[] newArray = new int[data.length + 10];
	    for (int i=0;i<data.length;i++) {
		newArray[i] = data[i];
	    }
	    data = newArray;
	}
    }

    private void error(int index){
	if (index >= length){
	    throw new ArrayIndexOutOfBoundsException();
	}
    }

    public boolean add(int i) {
	grow();
	data[length] = i;
	length +=1;
	return true;
    }
    

    public void  add(int index, int i){
	grow();
	error(index);
	for(int k = length;k > 0;k--){
	    if(k > index){
	        data[k] = data[k -1];
	    } else if (k == index){
		data[k] = i;
		length +=1;
	    }
	 }
    }
    
    public int size() {
	return length;
    }

   
    public int get(int index) {
	error(index);
        return data[index];
    }

    public int set(int index, int i){
	error(index);
	int old = data[index];
	data[index] = i;
	return old;
    }

    public int remove(int index){
	error(index);
	int old = data[index];
	for(int i = 0;i < length;i++){
	    if (i >= index){
		data[i] = data[i+1];
	    }
	}
	length -= 1;
	return old;	
    }


/*------------ Main -------------*/
    public static void main(String[] args) {
	Sarray s = new Sarray();
	s.add(5);
	s.add(7);
	System.out.println(s);
	s.add(25);
	s.add(6);
	System.out.println(s);
	s.add(2,89);
	System.out.println(s);
	try { 
	    s.add(5,5);
	    System.out.println("it's all good");
	} catch (Exception e){
	    System.out.println("Error: " + e);
	}
	System.out.println(s);
	System.out.println(s.size());
    }
}
