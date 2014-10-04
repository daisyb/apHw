public class Shapes {
    
    public String box(int r, int c){
        String s= "";
        int row = 0;
        int col;
        while (row<r){
            col = c;
            while (col>0){
                s = s + "*";
                col=col-1;
            }
            s=s+"\n";
            row=row+1;
        }
        return s;
    }

    public String tri1(int r){
        int c = 1;
        int row = r;
        String t = "";
        while(row > 0){
            int col = c;
            while (col > 0){
                t = t + '*';
                col = col - 1;
            }
            c = c + 1;
            row = row - 1;
            t = t + "\n";
        }
        return t;
    }

    public String tri2(int r){
        String tri = "";
	int row = r;
        int c = 1;
        while (row  >  0){
            int star = c;
            int space = r - c;
            while (space > 0){
                tri = tri + ' ';
                space = space -1;
            }
            while (star > 0) {
                tri = tri + '*';
                star = star - 1;
            }
            c = c + 1;
	    row = row - 1;
            tri = tri + "\n";
        }
        return tri;
    }

    //worked on in class with Camille
    public String tri3(int h){
	String tri = "";
	int row = 0;
	while (row < h){
	    for (int space = h - row -1; space > 0; space --) {
		tri = tri + " ";
	    }
	    for (int star = 2*row+1;star > 0; star -- ){
		tri = tri + "*";
	    }
	    row = row + 1;
	    tri = tri + "\n";
	}

	return tri;
    }
    
    public String diamond(int h){
	String s = "";
	int row = 0;
	int h2 = h/2;
	String firstHalf = tri3(h - h2);
	s = s + firstHalf;
	int numStars = h - 2;
	while (row < h2){
	    for (int space = 0;space <= row;space ++) {
		s = s + ' ';
		}
	    for (int star = 0;star < numStars; star ++){
		s = s + '*';
	    }
	    numStars = numStars - 2;
	    row = row + 1;
	    s = s + "\n";
	    }
	
        return s;
    }
	    
     public String tri4(int h){
	String tri = "";
	int row = 0;
	int numStars = h;
	while (row < h){	    
	    /*for (int space = 0;space <= row; space ++){
		tri += ' ';
		}*/
	    tri += line(row + 1,' ');
	    for (int star = 0;star < numStars;star ++){
		tri += '*';
	    }
	    numStars = numStars - 1;
	    row += 1;
	    tri += "\n";
	}
	return tri;
     }

    public String line(int n,char c){
	String s ="";
	for (int i = 0; i < n; i ++){
	    s += c;
	}
	return s;
    }

    public String frame(int r, int c){
	String s = "";
	s += line(c,'*') + "\n";
	for(int i = 0;i < r - 2; i ++){
	    s += '*' + line(c - 2,' ') + "*\n";
	}
	s += line(c, '*');
	return s;
    }       
		
	     
}


	    
