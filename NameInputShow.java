import java.util.*;

public class NameInputShow{
  public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    ArrayList<String> name = new ArrayList<String>();
    
    int nameCount = 0;
    while(true){
      System.out.print("Please enter a name");
      String a = sc.nextLine();
      if(a.length()<16){
        name.add(a);
        nameCount++;
      }
      else
        System.err.println("Name length too long. Try again.");
      if(nameCount%5==0){
        System.out.println("You have entered "+nameCount+" names! Press 'N' if you wish to exit.");
        String check = sc.nextLine();
        if(check.equals("N") || check.equals("n"))
          break;
      }
    }
    
    print(name);
  }
  
  public static void print(ArrayList<String> name){
    int c = 0;
    for(String a : name){
      if(c%5==0) System.out.println();
      System.err.print("|");
      int count = 16-a.length();
      for(int i=0; i<(count/2); i++)
        System.out.print(" ");
      System.out.print(a);
      for(int i=0; i<(count-count/2); i++)
        System.out.print(" ");
      System.err.print("|");
      c++;
    }
    System.out.println();
  }
}