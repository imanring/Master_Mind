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

  public void recursiveSolve(ArrayList<Row> possibleKeys){
    if(possibleKeys.size()==1){
      System.out.println("Answer: "+possibleKeys.get(0));
    }else{
      Random r = new Random();
      Row guess = possibleKeys.get(r.nextInt(possibleKeys.size()));
      String Gscore = guess.scoreGuess(key);
      System.out.println(guess+"  "+Gscore);
      for(int i = 0; i < possibleKeys.size(); i++){
        if(!Gscore.equals(guess.scoreGuess(possibleKeys.get(i).getGuess()))){
          keyValues.remove(i);
          i--;
        }//end if
      }//end for
      recursiveSolve(possibleKeys);
    }
  }
  public static void permutations(Row array, int i, int n){
    if(i==n-1){
      System.out.println(array);
    }
    else{
      for(int k = 0; k<n-i;k++){
        try{
          permutations(swap(array.clone(),i,i+k),i+1,n);
        }catch(Exception e){
          System.out.println(e.getMessage());
        }
      }
    }
  }
  static Row swap(Row array, int a, int b){
    int temp = array.getVal(a);
    array.makeGuess(a,array.getVal(b));
    array.makeGuess(b,temp);
    return array;
  }
  Solver(){}
  public void GUIsetUp(){}
  public static void main(String[] args){
    Solver a = new Solver();
    permutations(new Row(new int[]{1,2,3,4}),0,4);
    a.setKey();
    a.setKeyValues();
    long sTime = System.currentTimeMillis();
    a.solve();
    sTime = System.currentTimeMillis()-sTime;
    System.out.println("Time for looping function: "+sTime);
    a.keyValues.clear();
    a.setKeyValues();
    sTime = System.currentTimeMillis();
    a.recursiveSolve(a.keyValues);
    sTime = System.currentTimeMillis() - sTime;
    System.out.println("Time for the recursive function: "+sTime);
  }
}
