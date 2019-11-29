import java.util.*;
public class Main{
  public static void main(String[] args){
    Game [] choices = new Game[3];
    System.out.println("Which game would you like to play:\n1. One player mastermind\n2. Two player mastermind\n3. Solver mastermind\nPlease enter an number from the menu.");
    Scanner s = new Scanner(System.in);
    try{
      int choice = s.nextInt();
      if(choice==1) choices[0] = new Player();
      else if(choice==2) choices[1] = new TwoPlayer();
      else if(choice==3) choices[2] = new Solver();
      choices[choice-1].play();
    }catch(Exception e){
      System.out.println("That was not an appropriate integer.");
    }
  }
}
