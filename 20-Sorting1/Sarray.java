public class Sarray {

/*------------ Instance Variables -------------*/
    private String[] data;
    private int length; //# of elements


/*------------ Constructors -------------*/
    public Sarray() {
	data = new String[4];
	length = 0;
    }


/*------------ Methods -------------*/
    public String toString() {
	String s = "[";
	for (int i=0;i<length;i++) {
	    s += data[i] + ",";
	}
	return s + "]";
    }

    public void grow() {
	if (length >= data.length){
	    String[] newArray = new String[data.length + 10];
	    for (int i=0;i<data.length;i++) {
		newArray[i] = data[i];
	    }
	    data = newArray;
	}
    }
    
    private void error(int index){
	if (index >= length){
	    //throw new ArrayIndexOutOfBoundsException();
	}
    }
    

    public boolean add(String s) {
	grow();
	data[length] = s;
	length +=1;
	return true;
    }
    

    public void  add(int index, String s){
	grow();
	error(index);
	for(int k = length;k >= 0;k--){
	    if(k > index){
	        data[k] = data[k -1];
	    } else if (k == index){
		data[k] = s;
		length +=1;
	    }
	 }
	
    }
    
    public int size() {
	return length;
    }

   
    public String get(int index) {
	error(index);
        return data[index];
    }

    public String set(int index, String s){
	error(index);
	String old = data[index];
	data[index] = s;
	return old;
    }

    public String remove(int index){
	error(index);
	String old = data[index];
	for(int i = 0;i < length;i++){
	    if (i >= index){
		data[i] = data[i+1];
	    }
	}
	length -= 1;
	return old;	
    }
    
    public void isort() {
	String n;
	for(int j = 0; j <length;j++){
	    n =remove(j);
	    length+=1;
	    int i;
	    for (i = length -1; i > 0 && n.compareTo(data[i-1]) < 0; i--) {
		data[i] = data[i - 1];
	    }
	    data[i] = n;
	}


    }

    public void Ssort(){
	//int minIndex = data[0];
	for(int i =0;i<data.length;i++){
	    int minIndex = i;
	    for(int j= i;j<length;j++){
		System.out.println(data[j]);
		if(data[j].compareTo(data[minIndex]) < 0){
		    minIndex =j;
		}
	    }
	    String n = data[minIndex];
	    data[minIndex] = data[i];
	    data[i] = n;
	}
    }
    
    
/*------------ Main -------------*/
    public static void main(String[] args) {
	Sarray s = new Sarray();
	s.add("eggplant");
	s.add("fig");
	s.add("banana");
	s.add("apple");
	s.add("coconut");
	s.add("Cucumber");
	s.add("date");
	System.out.println(s);
	s.Ssort();
	System.out.println(s);
    }
}
