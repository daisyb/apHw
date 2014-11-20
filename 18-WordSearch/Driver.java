public class Driver {

    public static void main(String[] args) {
	WordSearch w = new WordSearch();
	System.out.println(w);
	w.addWordHB("hello",1,4);
	System.out.println(w);
	w.addWordHB("look",1,3);
	w.addWordHF("a",3,8);
	w.addWordHF("a",2,8);
	w.addWordHF("rabbit",3,6);
	w.addWordHB("bannana",5,20);
	// System.out.println(w.overlap("look",3,6));
	// w.addWordH("look",3,5);
	// w.addWordH("hello",100,5);
	// w.addWordH("hello",30,555);
				
	System.out.println(w);
    }
}
