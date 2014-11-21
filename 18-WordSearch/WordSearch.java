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
	this(10,20);
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


    public void addWord(String w,int row, int col, boolean forward, boolean horizontal){
	int r = row, c = col;
	if ((c + w.length()) > board[r].length){
	    c = c - ((c + w.length()) - board[r].length);
	}

	col = c;

	int slen = w.length();
	for (int i=0; i < slen;i++){
	   
	    if (board[r][c] != '.'){
		if (col <= c){
		    col = c + 1;
		    slen +=1;
		}
	    
		char current = board[r][c];
		int index = 0;
			Boolean overlap = false;
		for(int j = 0;j<w.length();j++){
		     if (w.charAt(j) == current){
			 if (overlap){
			     c+=1;
			     current = board[r][c + 1];
			 } else {
			     overlap = true;
			     current = board[r][c + 1];
			 }
			 index = j;
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
	if (c < 0){
	    c +=1;
	}
	if (horizontal){
	    if (forward){
		for (int i=0;i<w.length();i++){
		    board[r][c] = w.charAt(i);
		    c++;
		}
	    } else{
		for (int i=w.length() - 1;i>=0;i--){
		    board[r][c] = w.charAt(i);
		    c++;
		}
	    }
	} else{
	    if (forward){
		for (int i =0;i<w.length();i++){
		    board[r][c] = w.charAt(i);
		    r++;
		}
	    } else {
		System.out.println(c);
		System.out.println(r);
		for (int i = w.length() -1;i >=0;i--){
		    board[r][c] = w.charAt(i);
		    r++;
		}
	    }
	}
    }
 
   public void addWordHF(String w,int row, int col){
	addWord(w,row,col,true,true);
    }
    public void addWordHB(String w, int row, int col){
	addWord(w,row,col,false,true);
    }
    public void addWordVF(String w, int row,int col){
	addWord(w,col,row,true,false);
    }
    public void addWordVB(String w, int row, int col){
	addWord(w,col,row,false,false);
    }
   
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
