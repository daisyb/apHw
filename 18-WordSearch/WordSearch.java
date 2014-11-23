
import java.util.*;

public class WordSearch{
    private char[][] board;
    private Random r;

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

    public Boolean addWord(String w){
	r = new Random();
       	int row = r.nextInt(board.length);
	int col = r.nextInt(board[0].length);
	boolean again = true;
	boolean forward = false;
	if (r.nextInt(2) == 0){
	    forward = true;
	}
	int type = r.nextInt(3);
	if (type == 0){
	    try{
		addWordH(w,row,col,forward);
	    } catch(Exception UnsupportedOperation) {
		again = false;
	    }
	} else if (type == 1){
	    try{
		addWordV(w,row,col,forward);
	    } catch(Exception UnsupportedOperation) {
		again = false;
	    }
	} else {
	    int direction = r.nextInt(2);
	    if (direction == 0){
		if (forward){
		    try{
			addWordDRF(w,row,col);
		    } catch(Exception UnsupportedOperation){
			again = false;
		    }
		} else {
		    try{
			addWordDRB(w,row,col);
		    } catch(Exception UnsupportedOperation){
			again = false;
		    }
		}
	    } else {
		if (forward){
		    try{
			addWordDLF(w,row,col);
		    } catch(Exception UnsupportedOperation){
			again = false;
		    }
		} else {
		    try{
			addWordDLB(w,row,col);
		    } catch(Exception UnsupportedOperation){
			again = false;
		    }
		}
	    }
	}
		    
	return again;
    }

	

    public void overlap(String w, int row,int col, boolean forward){
	int r = row, c = col;
	boolean overlap = true;
        for(int i = 0; i <w.length();i++){
	    if (board[r][c] != '.'){
		if (board[r][c] != w.charAt(i)){
		   throw new UnsupportedOperationException();
		}
	    }
	    if (forward){
		c++;
	    } else{
		r++;
	    }
			    
	}
       
    }
    public void addWordH(String w, int row, int col, boolean forward){
	int r = row, c = col;
	if ((c + w.length()) > board[r].length){
	    c = c - ((c+w.length()) - board[r].length);
	}
	overlap(w, r, c,true);
	if(forward){
	    for(int i = 0;i<w.length();i++){
		board[r][c] = w.charAt(i);
		c++;
	    }
	} else {
	    for(int i = w.length() -1;i >= 0;i--){
		board[r][c]=w.charAt(i);
		c++;
	    }
	}
    }

    public void addWordV(String w,int row, int col, boolean forward){
	int r = row,  c = col;
	if ((r + w.length()) > board.length){
	    r = r - ((r + w.length()) - board.length);
	}
	if ((c + w.length()) > board[r].length){
	    c = c - ((c+w.length()) - board[r].length);
	}
	overlap(w, r, c,false);
	if(forward){
	    for(int i = 0;i<w.length();i++){
		board[r][c] = w.charAt(i);
		r++;
	    }
	} else {
	    for(int i = w.length() -1;i >= 0;i--){
		board[r][c]=w.charAt(i);
		r++;
	    }
	}
    }

  
    //diagonal to the right going forward
     public void addWordDRF(String w, int row, int col){
	int r=row, c = col;
	if ((r + w.length()) > board.length){
	    r = r - ((r + w.length()) - board.length);
	}
	if ((c + w.length()) > board[r].length){
	    c = c - ((c+w.length()) - board[r].length);
	}
	col = c;
	row = r;
        for(int i = 0; i <w.length();i++){
	    if (board[r][c] != '.'){
		if (board[r][c] != w.charAt(i)){
		     throw new UnsupportedOperationException();
		}
	    }
	    r++;
	    c++;
			    
	}
	c = col;
	r =row;
	for (int i =0;i<w.length();i++){
	    board[r][c]= w.charAt(i);
	    r++;
	    c++;
	}
    }

    //diagonal to the right goint backward
    public void addWordDRB(String w, int row, int col){
    	int r=row, c = col;
	if ((r + w.length()) > board.length){
	    r = r - ((r + w.length()) - board.length);
	}
	if ((c + w.length()) > board[r].length){
	    c = c - ((c+w.length()) - board[r].length);
	}
	col = c;
	row = r;

 	for (int i = w.length()-1;i>=0;i--){
	    if (board[r][c] != '.'){
		if (board[r][c] != w.charAt(i)){
		    throw new  UnsupportedOperationException();
		}
	    }    	   
    	    r++;
    	    c++;
    	}
	c = col;
	r =row;
	
 	for (int i = w.length()-1;i>=0;i--){
    	    board[r][c]= w.charAt(i);
    	    r++;
    	    c++;
    	}
    }

    //diagonal to the left forward
    public void addWordDLF(String w, int row, int col){
    	int r=row, c = col;

	if ((r + w.length()) > board.length){
	    r = r - ((r + w.length()) - board.length);
	}
	if ((c + w.length()) > board[r].length){
	    c = c - ((c+w.length()) - board[r].length);
	}
	if((c - w.length())<0){
	    c= c + w.length() -1;
	}
	col = c;
	row = r;

 	for (int i = 0; i <w.length();i++){
	    if (board[r][c] != '.'){
		if (board[r][c] != w.charAt(i)){
		    throw new  UnsupportedOperationException();
		}
	    }    	   
    	    r++;
    	    c--;
    	}
	c = col;
	r =row;

    	for (int i = 0; i <w.length();i++){

    	    board[r][c]= w.charAt(i);
    	    r++;
    	    c--;
    	}
    }
  
    //daigonal to the left backward
    public void addWordDLB(String w, int row, int col){
    	int r=row, c = col;
    	if ((r + w.length()) > board.length){
    	    r = r - ((r + w.length()) - board.length);
    	}
    	if ((c + w.length()) > board[r].length){
    	    c = c - ((c+w.length()) - board[r].length);
    	}
	if ((r - w.length()) < 0){
	    r = r + w.length() - 1;
	}
	col = c;
	row = r;
	
    	for (int i = 0;i<w.length();i++){
	    if (board[r][c] != '.'){
		if (board[r][c] != w.charAt(i)){
		    throw new  UnsupportedOperationException();
		}
	    }
	   
    	    r--;
    	    c++;
    	}
	c = col;
	r =row;

    	for (int i =0;i<w.length();i++){
    	    board[r][c]= w.charAt(i);
    	    r--;
    	    c++;
    	}
    }
  
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
