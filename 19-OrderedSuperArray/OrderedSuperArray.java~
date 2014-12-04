public class OrderedSuperArray extends Sarray{
    private String[] OrderedData;
    private int length;
    
    public OrderedSuperArray(){
	OrderedData = super.getData();
	length = super.getLength();
    }

    public int orderedIndex(String s){
	OrderedData = super.getData();
	for(int i = 0; i < super.getLength();i++){
	    if ((OrderedData[i].compareTo(s)) >= 0){
		return i;
	    } else {
		return i+1;
	    }
	}
	return 0;
    }
    
    public boolean add(String s){
	int index = orderedIndex(s);
	add(index,s);
	return true;
    }

    public String set(String s){
	int index = orderedIndex(s);
	return super.set(index,s);
    }
}
