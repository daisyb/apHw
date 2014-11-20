/**
 * Creates a word search puzzle
 *
 */
public class WordSearch{

    private char[][] board;

    public WordSearch(int r, int c){
	board = new char[r][c];
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		board[i][j]='.';
	    }
	}
				
    }
    public WordSearch(){
	this(10,15);
    }

    public String toString(){
	String s = "";
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		s = s + board[i][j];
	    }
	    s = s + "\n";
	}
	return s;
    }


    public void addWordHF(String w,int row, int col){
	int r = row, c = col;
	//keeps word from going over
	if ((c + w.length()) > board[r].length){
	    c = c - ((c + w.length()) - board[r].length);
	}
	col = c;
	Boolean overlap = false;
	int slen = w.length();
	for (int i=0; i < slen;i++){
	   
	    if (board[r][c] != '.'){
		if (col <= c){
		    col = c + 1;
		    slen +=1;
		}
	    
		char current = board[r][c];
		int index = 0;
		for(int j = 0;j<w.length();j++){
		     if (w.charAt(j) == current){
	       		overlap = true;
			index = j;
			current = board[r][c +1];
		     } else if (overlap && current != '.'){
		     	 overlap = false;
		     } 
		}
	    if (overlap){
		board[r][c] = '.';
		col = c - index; 
	    	break;
	     }
	    }
	    c +=1;
	}
	c = col;

	for (int i=0;i<w.length();i++){
	    board[r][c] = w.charAt(i);
	    c++;
	}
    }

    public void addWordHB(String w,int row, int col){
	int r = row, c = col;
	//keeps word from going over
	if ((c + w.length()) > board[r].length){
	    c = c - ((c + w.length()) - board[r].length);
	}
	col = c;
	Boolean overlap = false;
	int slen = w.length();
	for (int i=0; i < slen;i++){
	   
	    if (board[r][c] != '.'){
		if (col <= c){
		    col = c + 1;
		    slen +=1;
		}
	    
		char current = board[r][c];
		int index = 0;
		for(int j = 0;j<w.length();j++){
		     if (w.charAt(j) == current){
	       		overlap = true;
			index = j;
			current = board[r][c +1];
		     } else if (overlap && current != '.'){
		     	 overlap = false;
		     } 
		}
	    if (overlap){
		board[r][c] = '.';
		col = c - index; 
	    	break;
	     }
	    }
	    c +=1;
	}
	c = col;

	for (int i=w.length() - 1;i>=0;i--){
	    board[r][c] = w.charAt(i);
	    c++;
	}
    }
    public static void main(String[] args) {
	WordSearch w = new WordSearch();
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
