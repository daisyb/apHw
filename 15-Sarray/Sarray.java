public class Sarray {

/*------------ Instance Variables -------------*/
    private int[] data;
    private int length; //# of elements


/*------------ Constructors -------------*/
    public Sarray() {
	data = new int[10];
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
	    int[] newArray = new int[data.length + 5];
	    for (int i=0;i<data.length;i++) {
		newArray[i] = data[i];
	    }
	    data = newArray;
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
        return data[index];
    }

    public int set(int index, int i){
	int old = data[index];
	data[index] = i;
	return old;
    }

    public int remove(int index){
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
    }
}
