import java.io.*;
import java.util.*;

public class NameReadShow_Hash{
  static String [] name;
  public static void main(String [] args) throws Exception{
    File f = new File("HashNames.txt");
    FileReader fl = new FileReader(f);
    BufferedReader br = new BufferedReader(fl);
    
    int numberOfNames = Integer.parseInt(br.readLine());
    name = new String [numberOfNames+5];
    int nameErr = 0;
    String a;
    while((a=br.readLine())!=null){
      if(a.length()<=50){
//        HashQuadraticProb(a, numberOfNames);
        HashLinearProb(a, numberOfNames);
      }
      else
        nameErr++;
    }
    if(nameErr!=0)
      System.err.println(nameErr+" Names were unable to be added due to overlength.");
    System.out.println("Total number of names: "+name.length);
//    print(name);
    printList(name);
  }
  
  public static void HashLinearProb(String n, int a){
    int val = 0;
    for(int i=0; i<n.length(); i++)
      val+= (int)n.charAt(i);
    int col = 0;
    int prob = 0;
    int ASCII = val;
    
    System.err.print("Key-> ");
    while(true){
      prob++;
      int key = val%a;
      System.err.print(key+" ");
      if(name[key]==null){
        name[key] = n;
        break;
      }
      else{
        val++;
        col++;
      }
    }
    printHash(n, ASCII, prob, col);
    System.out.println(" [LinearProb]");
  }
  
  public static void HashQuadraticProb(String n, int a){
    int val = 0;
    for(int i=0; i<n.length(); i++)
      val+= (int)n.charAt(i);
    int col = 0;
    int prob = 0;
    int ASCII = val;
    int c = 1;
    
    System.err.print("Key-> ");
    while(true){
      prob++;
      int key = val%a;
      System.err.print(key+" ");
      if(name[key]==null){
        name[key] = n;
        break;
      }
      else{
        val+=(c*c); c++;
        col++;
      }
    }
    printHash(n, ASCII, prob, col);
    System.out.println(" [QuadraticProb]");
  }
  
  private static void printHash(String n, int ASCII, int prob, int col){
    System.out.print("\n"+n);
    for(int i=0; i<40-n.length(); i++)
      System.out.print(" ");
    System.out.print("(ASCII Code: "+ASCII);
    if(ASCII<1000 && prob<10) System.out.print(")  was probbed "+prob+"  times.");
    else if(ASCII<1000 && prob>=10) System.out.print(")  was probbed "+prob+" times.");
    else if(ASCII>=1000 && prob<10) System.out.print(") was probbed "+prob+"  times.");
    else System.out.print(") was probbed "+prob+" times.");
    
    if(col<10) System.out.print(" Collision occured "+col+"  times.");
    else System.out.print(" Collision occured "+col+" times.");
  }
  
  public static void print(String [] name){
    int c = 0;
    
    for(String a : name){
      if(a!=null){
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
    }
    System.out.println();
  }
  
  public static void printList(String [] name){
    System.out.println();
    for(int i=0; i<name.length; i++){
      if(name[i]!=null){
        if(i<10) System.out.print("0");
        System.out.println(i+". "+name[i]);
      }
    }
  }
}