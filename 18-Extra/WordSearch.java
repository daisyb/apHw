/*
  This version of the word search makes overlaps much more likely.
  Most changes to original were done in the addBetter and addWord2 methods.
*/


import java.util.*;
import java.io.*;

public class WordSearch{
    private Random r;
    private char[][] board;
    private char[][] key;
    private ArrayList<String> words; 
    private ArrayList<String> wordBank;
    

   public WordSearch(int r, int c){
	words =new ArrayList<String>();
	wordBank = new ArrayList<String>();
	board = new char[r][c];
	fillWordList();
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		board[i][j]='.';
	    }
	}
				
    }

    public WordSearch(){
	this(15,30);
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
    
    public void buildPuzzle(int numWords){ 
	r = new Random();
	while(numWords>0){
	    int wordIndex = r.nextInt(words.size());
	    String word = words.get(wordIndex);
	    int tries = 0;
	    boolean worked = false;
	    while (tries < 10 && !worked){
		worked = addWord2(word);
		tries +=1;
	    }
	    if (worked){
		numWords --;
		words.remove(wordIndex);
		wordBank.add(word);
	    }
	}
	makeKey();
	fillGrid();
    }

    private void makeKey(){
	key = new char[board.length][board[0].length];
	for(int i = 0;i<board.length;i++){
	    for(int j =0;j<board[0].length;j++){
		key[i][j] = board[i][j];
	    }
	}
    }

    public ArrayList<String> getWordBank(){
	return wordBank;
    }

    public String printKey(){
	String s = "";
	for (int i = 0; i < key.length; i++) {
	    for (int j = 0; j < key[i].length; j++) {
		s = s + key[i][j];
	    }
	    s = s + "\n";
	}
	return s;
    }

    public Boolean addWord(String w){
	r = new Random();
       	int row = r.nextInt(board.length);
	int col = r.nextInt(board[0].length);
	boolean success = true;
	boolean forward = false;
	if (r.nextInt(2) == 0){
	    forward = true;
	}
	int type = r.nextInt(3);
	if (type == 0){
	    try{
		addWordH(w,row,col,forward);
	    } catch(Exception UnsupportedOperation) {
		success = false;
	    }
	} else if (type == 1){
	    try{
		addWordV(w,row,col,forward);
	    } catch(Exception UnsupportedOperation) {
		success = false;
	    }
	} else {
	    int direction = r.nextInt(2);
	    if (direction == 0){
		if (forward){
		    try{
			addWordDRF(w,row,col);
		    } catch(Exception UnsupportedOperation){
			success = false;
		    }
		} else {
		    try{
			addWordDRB(w,row,col);
		    } catch(Exception UnsupportedOperation){
			success = false;
		    }
		}
	    } else {
		if (forward){
		    try{
			addWordDLF(w,row,col);
		    } catch(Exception UnsupportedOperation){
			success = false;
		    }
		} else {
		    try{
			addWordDLB(w,row,col);
		    } catch(Exception UnsupportedOperation){
			success = false;
		    }
		}
	    }
	}
		    
	return success;
    }

   
    public void fillGrid(){
	r = new Random();
	for(int i = 0; i < board.length;i++){
	    for(int j = 0; j < board[i].length;j++){
		if (board[i][j] == '.'){
		    board[i][j] = (char)('a' + r.nextInt(26));
		}
	    }
	}
    }

    private void fillWordList(){
        Scanner sc = null;
	try {
	    sc = new Scanner(new File("words.txt"));
	} catch (Exception e) {
	    System.out.println("Can't open file");
	    System.exit(0);
	}
	while (sc.hasNext()) {
	    String s = sc.next();
	    words.add(s.toLowerCase());
	}
    }



    public void overlap(String w, int row,int col, boolean horizontal){
	int r = row, c = col;
	    for(int i = 0; i <w.length();i++){
	    if (board[r][c] != '.'){
		if (board[r][c] != w.charAt(i)){
		   throw new UnsupportedOperationException();
		}
	    }
	    if (horizontal){
		c++;
	    } else{
		r++;
	    }
			    
	}
    }

    //modified addWord for use with addWordBetter
    public Boolean addWord2(String w){
	r = new Random();
	boolean success = true;
	int type = r.nextInt(3);
	boolean forward = false;
	if (r.nextInt(2) == 0){
	    forward = true;
	}
	try{
	    addWordBetter(w,forward,type);
	} catch (Exception UnsupportedOperation){
	    success = false;
	}		    
	return success;
    }

    //returns true if the word is within bounds, false if not
    //used in addWordBetter
    public boolean overBoard(int length,int row, int col){
	if (col + length < board[0].length && col  > 0){
	    return true;
	} else if (row + length < board.length && row > 0){
	    return true;
	} else {
	    return false;
	}
    }

    //makes overlaps more likely, one function for all add types
    public void addWordBetter(String w, boolean forward, int type){
       	Random rnd = new Random();                                 
	int r  = 0, c = 0;
	int rAdd = 0, cAdd =0;
        boolean overlap = false;
	int index = 0;
	if(!forward){
	    w = new StringBuilder(w).reverse().toString();
	}

	if (type == 0){ //horizontal
	    cAdd = 1;
	} else if (type == 1){ //vertical
	    rAdd = 1;
	} else if (rnd.nextInt(2) == 0){ //Diagonal right
	    cAdd = 1;
	    rAdd = 1;
	} else {  //Diagonal left;
	    cAdd = -1;
	    rAdd = 1;
	}

	for(int i =0;i<board.length;i++){
	    for(int j =0;j<board[r].length;j++){
		char current = board[i][j];
		for(int k=0;k<w.length();k++){
		    if (overBoard(w.length(), i - k  , j - k)){
                        if(current != '.'){
                            if(w.charAt(k)==current){
				if(overlap){
				    if (type == 0) j +=1;
				    else if (type == 1) i +=1;
				    else { 
					i+= rAdd; 
					j+= cAdd;
				    }
				}
                                overlap = true;
				index = k;
				current = board[i + rAdd][j+ cAdd];
			    } else if (overlap){
				overlap = false;
				break;
			    }else {
                                overlap = false;
			     }
                        } else if (overlap){
                            current = board[i + rAdd][j+cAdd];
                        }
		    }
		}
		if (overlap){
		    if (type == 0){
			r = i;
			c = j - index;
			break;
		    } else if (type == 1){
			r = i -index;
			c = j;
			break;
		    } else {
			r = i - index;
			c = j - index;
			break;
		    }
		}
	    }

	    if (overlap){
		break;
	    }
               
	}
	if (!overlap){
	    r = rnd.nextInt(board.length);
	    c = rnd.nextInt(board[r].length);
	}
        if (type == 0){
	    addWordH(w,r,c,true);
	}else if (type == 1){
	    addWordV(w,r,c,true);
	} else {
	    if (cAdd > 0){
		addWordDRF(w,r,c);
	    } else {
		addWordDLF(w,r,c);
	    }
	}

    }

    public void addWordH(String w, int row, int col, boolean forward){
	int r = row, c = col;
	if ((c + w.length()) > board[r].length){
	    c = c - ((c+w.length()) - board[r].length);
	}
	overlap(w, r, c,true);
	if (!forward){
	    w = new StringBuilder(w).reverse().toString();
	}
	for(int i = 0;i<w.length();i++){
	    board[r][c] = w.charAt(i);
	    c++;
	}
    }

    public void addWordV(String w,int row, int col, boolean forward){
	int r = row,  c = col;
	if ((r + w.length()) > board.length){
	    r = r - ((r + w.length()) - board.length);
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
        w.buildPuzzle(10);

	System.out.println(w);
	System.out.println(w.getWordBank());
	System.out.println(w.printKey());
    }

}
