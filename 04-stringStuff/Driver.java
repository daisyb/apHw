
public class Driver {
    public boolean mixStart(String str) {
         if (str.length() < 1) return false;
         return str.substring(1).startsWith("ix");
    }
        
    public String makeOutWord(String out, String word) {
         return out.substring(0,2) + word + out.substring(2);
    }
        
    public String firstHalf(String str) {
        int len = str.length();
        return str.substring(0,len/2);
    }
    //public static void main(String[] args){}
}
