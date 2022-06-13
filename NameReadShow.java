import java.io.*;
import java.util.*;

public class NameReadShow{
  public static void main(String [] args) throws Exception{
    ArrayList<String> name = new ArrayList<String>();
    File f = new File("Names.txt");
    FileReader fl = new FileReader(f);
    BufferedReader br = new BufferedReader(fl);

    int nameErr = 0;
    String a;
    while((a=br.readLine())!=null){
      if(a.length()<=50){
        name.add(a);
      }
      else
        nameErr++;
    }
    System.err.println(nameErr+" Names were unable to be added due to overlength.");
    System.out.println("Total number of names: "+name.size());
    print(name);
  }
  
  public static void print(ArrayList<String> name){
    int c = 0;

    for(String a : name){
      if(c%3==0){
        //for(int i=0; i<156; i++) System.err.print("_");
        System.out.println();
      }
      System.err.print("|");
      int count = 50-a.length();
      for(int i=0; i<(count-count/2); i++)
        System.out.print(" ");
      System.out.print(a);
      for(int i=0; i<(count/2); i++)
        System.out.print(" ");
      System.err.print("|");
      c++;
    }
    System.out.println();
  }
}