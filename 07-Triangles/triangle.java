public class triangle {
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

}
