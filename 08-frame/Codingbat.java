public class Codingbat {

    public String stringSplosion(String str) {
	String s = "";
	for(int i = 0;i <= str.length();i ++){
	    s += str.substring(0,i);
	}
	return s;
    }

    public String stringX(String str) {
	String s = "";
	for(int i = 0;i < str.length();i ++){
	    char c = str.charAt(i);
	    if (c != 'x'){
		s += c;
	    }else if (i == 0 || i == str.length() -1){
		s += c;
	    }
	}
	return s;
    }
}
