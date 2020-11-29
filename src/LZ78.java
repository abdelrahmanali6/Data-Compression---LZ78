import java.util.ArrayList;
import java.util.Arrays;

public class LZ78 {
    public static ArrayList<ArrayList<String>> Compression(String Seq)
    {
        ArrayList<ArrayList<String>> Listed = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> Combined = new ArrayList<ArrayList<String>>();
        String temp="";
        int pos=0;

        Listed.add(new ArrayList<String>(Arrays.asList("1", String.valueOf(Seq.charAt(0)))));
        Combined.add(new ArrayList<String>(Arrays.asList("0",String.valueOf(Seq.charAt(0)))));

        for(int i=1; i<Seq.length(); i++)
        {
            temp+=Seq.charAt(i);

            for(int j=0; j<Listed.size(); j++)
            {
                if(Listed.get(j).get(1).equals(temp))
                {
                    pos = Integer.valueOf(Listed.get(j).get(0));
                    break;
                }
                else if(j==Listed.size()-1)
                {
                    Combined.add(new ArrayList<String>(Arrays.asList(String.valueOf(pos),String.valueOf(temp.charAt(temp.length()-1)))));
                    Listed.add(new ArrayList<String>(Arrays.asList(String.valueOf(Listed.size()+1),temp)));
                    pos=0;
                    temp="";
                    break;
                }
            }
        }
        return Combined;
    }

    public static String Decompression(ArrayList<ArrayList<String>> Listed)
    {
        String Seq = "";
        String Prev = "";
        String Next = "";
        Integer Index ;
        for(int i=0; i<Listed.size(); i++)
        {
            if(Integer.parseInt(Listed.get(i).get(0)) == 0)
            {
                Seq += Listed.get(i).get(1);
            }
            else
            {
                Index = i;
                while(true)
                {
                    if(Integer.parseInt(Listed.get(Index).get(0)) == 0)
                    {
                        Prev = Listed.get(Index).get(1);
                        Next = Prev + Next;
                        Seq += Next;
                        Prev ="";
                        Next ="";
                        break;
                    }
                    else
                    {
                        Prev = Listed.get(Index).get(1);
                        Next = Prev + Next;
                        Index = Integer.parseInt(Listed.get(Index).get(0))-1;
                    }
                }
            }
        }
        return Seq;
    }

}