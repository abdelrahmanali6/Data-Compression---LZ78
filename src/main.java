import java.util.ArrayList;

public class main {
    public static void main(String[] args)
    {
        String test = "ABAABBAAB";
        ArrayList<ArrayList<String>> combined = new ArrayList<ArrayList<String>>();
        combined=LZ78.Compression(test);
        for(int i=0; i<combined.size(); i++)
        {
            System.out.println(combined.get(i));
        }
       System.out.println(LZ78.Decompression(combined));
    }
}