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
	    int space = h - row - 1;
	    while (space > 0) {
		tri = tri + " ";
		space = space - 1;
	    }
	    int star = 2 * row + 1;
	    while (star > 0 ){
		tri = tri + "*";
		star = star - 1;
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
	    int space = 0;
	    while (space <= row) {
		s = s + ' ';
		space = space + 1;
		}
	    int star = 0;
	    while (star < numStars){
		s = s + '*';
		star = star + 1;
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
	    int space = 0;
	    while (space <= row){
		tri += ' ';
		space += 1;
	    }
	    int star = 0;
	    while (star < numStars){
		tri += '*';
		star += 1;
	    }
	    numStars = numStars - 1;
	    row += 1;
	    tri += "\n";
	}
	return tri;
     }
	     
}
