public class Driver{
    public static void main(String[] args){
	//System.out.println("apparrent".compareTo("apple"));
	OrderedSuperArray Oa = new OrderedSuperArray();
	//Sarray Oa = new Sarray();
	Oa.add("ate");
	Oa.add("dog");
	Oa.add("rabbit");
	System.out.println(Oa);
	Oa.set(1,"cat");
	System.out.println(Oa);
	Oa.add("rat");
	System.out.println(Oa);
    }
}
