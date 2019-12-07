import java.util.*;

public abstract class Game{
  int[] key = new int[4];
  Row [] board = new Row[9];
  int indexAt;
  int currentRow;
  
  public Game(){
    this.indexAt = 0;
    this.currentRow = 0;
    for(int i = 0; i<9;i++){
      board[i] = new Row();
    }
  }
  public void setKey(){
    //Randomly set the key
    boolean keepGoing = true;
    while(keepGoing){
      System.out.println("What level would you like to play at?\n1. Easy\n2. Medium\n3. Hard");
      Scanner s = new Scanner(System.in);
      String choice = s.next();
      Random random = new Random();
      //easy - only two values possible in the key.
      if(choice.equals("1")){
        keepGoing = false;
        int[] vals = new int[]{random.nextInt(7),random.nextInt(7)};
        for(int i = 0; i < 4; i++){
          //randomly pick one of the two values from vals
          key[i] = vals[random.nextInt(2)];
        }
      }
      //medium - all different numbers
      else if(choice.equals("2")){
        keepGoing = false;
        ArrayList<Integer> vals = new ArrayList();
        vals.add(new Integer(0));vals.add(new Integer(1));vals.add(new Integer(2));vals.add(new Integer(3));
        vals.add(new Integer(4));vals.add(new Integer(5));vals.add(new Integer(6));
        int temp;
        for(int i = 0; i < 4; i++){
          temp = random.nextInt(vals.size());
          key[i] = vals.get(temp).intValue();
          vals.remove(temp);
        }
      }
      //hard - random integers
      else if(choice.equals("3")){
        keepGoing = false;
        for(int i = 0; i < 4; i++){
          key[i] = random.nextInt(7);
        }
      }
    } 
    System.out.println("Key: "+Arrays.toString(key));
  }//end setKey
  public abstract void play();
}
