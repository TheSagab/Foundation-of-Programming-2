/**
 * Created by ASUS on 3/26/2017.
 */
public class Lab06 {
    public static void main(String[] args){
        System.out.println(reverse("Fasilkom"));
        System.out.println(reverse("SayasukaDDP"));
        System.out.println(checkDuplicate("fisdas"));
        System.out.println(checkDuplicate("maatdas"));
    }

    public static String reverse(String str){
        if (str.length() <= 1) return str;
        return reverse(str.substring(1)) + str.charAt(0);
    }

    public static boolean checkDuplicate(String str){
        if (str.length() <= 1) return false;
        if (str.charAt(0) == str.charAt(1)) return true;
        return checkDuplicate(str.substring(1));
    }
}
