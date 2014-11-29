public class Driver {

   public static void main(String[] args) {
       WordSearch w = new WordSearch(15,30);

       // System.out.println(w.addWord2("hello"));
       // System.out.println(w.addWord2("look"));
       // System.out.println(w.addWord2("pool"));
       // System.out.println(w);
       // w.addWordBetter("fool",false,2);
       // System.out.println(w);
       System.out.println();
       w.buildPuzzle(10);
       System.out.println(w);
       System.out.println(w.getWordBank());
       System.out.println();
       System.out.println(w.printKey());
    }

}
