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
    Random random = new Random();
    for(int i = 0; i < 4; i++){
      key[i] = random.nextInt(7);
    }
    System.out.println("Key: "+Arrays.toString(key));
  }//end setKey
  public abstract void play();
}
