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
        while (row > 0){
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
}
