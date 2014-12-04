public class OrderedSuperArray extends Sarray{
    
    public int orderedIndex(String s){
	for(int i = 0; i < super.size();i++){
	    if ((s.compareTo(get(i))) <= 0){
		return i;
	    } else if (i == size() -1){
		return size();
	    }
	}
	return 0;
    }
    
    public boolean add(String s){
	int index = orderedIndex(s);
	add(index,s);
	return true;
    }

    public String set(int index,String s){
	String old = super.remove(index);
	add(s);
	return old;
    }
}
