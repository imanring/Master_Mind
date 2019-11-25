import java.util.*;
public class Solver extends Game{
  ArrayList<Row> keyValues = new ArrayList<Row>();
  public void setKeyValues(){
    for(int i = 0; i < 7;i++){
      for(int j = 0; j < 7; j++){
        for(int k = 0; k < 7; k++){
          for(int l = 0; l < 7; l++){
            keyValues.add(new Row(new int[]{i,j,k,l}));
          }
        }
      }
    }
  }
  public void solve(){
    boolean keepGoing = true;
    Row guess;
    Random random = new Random();
    while(keepGoing){
      guess = keyValues.get(random.nextInt(keyValues.size()));
      String Gscore = guess.scoreGuess(key);
      System.out.println(guess+"  "+Gscore);
      for(int i = 0; i < keyValues.size(); i++){
        if(!Gscore.equals(guess.scoreGuess(keyValues.get(i).getGuess()))){
          keyValues.remove(i);
          i--;
        }//end if
      }//end for
      if(keyValues.size()==1){
        keepGoing = false;
        System.out.println("My answer: "+Arrays.toString(keyValues.get(0).getGuess()));
      }//end if
    }//end while
  }//end solve
  Solver(){}
  public void GUIsetUp(){}
  //public void keySet(){key = new int[]{1,3,2,5};}
  public static void main(String[] args){
    Solver a = new Solver();
    a.setKey();
    //a.keySet();
    a.setKeyValues();
    a.solve();
  }
}
