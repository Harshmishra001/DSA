
import java.util.ArrayList;

public class swapNo {   //SWAP IT WITHOUT USING TEMPORARY VARIABLE
    static ArrayList <Integer> get(int a,int b)
    {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        list.add(b);
        list.add(a);
        return list;
        
    }
    public static void main(String[] args) {
        int a = 13;
        int b = 9;
        ArrayList <Integer> swapped = get(a, b);
        System.out.println("Swapped values: " + swapped.get(0) + " " + swapped.get(1));
    }
}
