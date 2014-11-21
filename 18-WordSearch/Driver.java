public class Driver {

    public static void main(String[] args) {
	WordSearch w = new WordSearch();
	w.addWordHF("hello",1,3);
	System.out.println(w);
	w.addWordHF("look",1,2);
	w.addWordHF("a",3,8);
	w.addWordHF("rabbit",3,6);
	w.addWordHB("bannana",5,20);
	w.addWordVB("table",4,5);
	w.addWordVF("plant",15,3);
	// w.addWordH("hello",100,5);
	// w.addWordH("hello",30,555);
				
	System.out.println(w);
    }
}
