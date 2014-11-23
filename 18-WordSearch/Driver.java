public class Driver {

   public static void main(String[] args) {
	WordSearch w = new WordSearch();
	//w.addWordH("hello",1,3,true);
	//System.out.println(w);
	//w.addWordH("look",1,0,true);
	//w.addWordH("a",3,8,true);
	//w.addWordH("rabbit",3,7,true);
	//w.addWordH("bannana",5,20,false);
	//w.addWordV("table",0,20, false);
	//w.addWordV("pool",20,20, true);
	//w.addWordH("hello",100,5);
	//w.addWordH("hello",30,555);
				
	//w.addWordDRB("soup",0,0);
	System.out.println(w.addWord("hello"));
	System.out.println(w.addWord("look"));
	System.out.println(w.addWord("pool"));
	System.out.println(w.addWord("school"));

	System.out.println(w);
    }

}
