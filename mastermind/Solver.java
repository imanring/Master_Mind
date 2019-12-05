import java.util.*;
public class Solver extends Game{
  LinkedList keyValues = new LinkedList();
  
  //set all possible key values.
  public void setKeyValues(){
    for(int i = 0; i < 7;i++){
      for(int j = 0; j < 7; j++){
        for(int k = 0; k < 7; k++){
          for(int l = 0; l < 7; l++){
            keyValues.append(new Row(new int[]{i,j,k,l}));
          }
        }
      }
    }
  }
  public void solve(){
    boolean keepGoing = true;
    Row guess;
    Random random = new Random();
    //while mastermind has not been solved
    while(keepGoing){
      //randomly pick a guess
      guess = keyValues.get(random.nextInt(keyValues.size()));
      String Gscore = guess.scoreGuess(key);
      System.out.println(guess+"  "+Gscore);
      for(int i = 0; i < keyValues.size(); i++){
        //remove all key values that do not score guess the same as the key.
        if(!Gscore.equals(guess.scoreGuess(keyValues.get(i).getGuess()))){
          keyValues.delete(i);
          i--;
        }//end if
      }//end for
      //if we are left with only 1 element in keyValues we have solved mastermind
      if(keyValues.size()==1){
        keepGoing = false;
        System.out.println("My answer: "+Arrays.toString(keyValues.get(0).getGuess()));
      }//end if
    }//end while
  }//end solve

  public void recursiveSolve(LinkedList possibleKeys){
    if(possibleKeys.size()==1){
      System.out.println("Answer: "+possibleKeys.get(0));
    }else{
      Random r = new Random();
      Row guess = possibleKeys.get(r.nextInt(possibleKeys.size()));
      String Gscore = guess.scoreGuess(key);
      System.out.println(guess+"  "+Gscore);
      for(int i = 0; i < possibleKeys.size(); i++){
        if(!Gscore.equals(guess.scoreGuess(possibleKeys.get(i).getGuess()))){
          keyValues.delete(i);
          i--;
        }//end if
      }//end for
      recursiveSolve(possibleKeys);
    }
  }
  public void permutations(Row array, int i, int n){
    //array is the Row to find the permutations of
    //i is the index last fixed position in array.
    //n is the size of the array (in the case of a row 4).
    //base case
    if(i==n-1){
      //if the permutation is not already in keyValues
      if(keyValues.get(array)==-1){
        keyValues.append(array);
      }
    }
    else{
      //When no positions are fixed do 4 swaps, when i position in the array is fixed do 3 swaps etc.
      for(int k = 0; k<n-i;k++){
        try{
          //swap a position in array and increase i
          permutations(swap(array.clone(),i,i+k),i+1,n);
        }catch(Exception e){
          System.out.println(e.getMessage());
        }
      }
    }
  }
  //swap the values at index a and b in the Row array.
  Row swap(Row array, int a, int b){
    int temp = array.getVal(a);
    array.makeGuess(a,array.getVal(b));
    array.makeGuess(b,temp);
    return array;
  }
  //randomly swap several positions in the key.
  public void shuffleKey(){
    Random r = new Random();
    for(int i = 0; i<4; i++){
      int randIndex = r.nextInt(4);
      int temp = key[randIndex];
      int randIndex2 = r.nextInt(4);
      key[randIndex] = key[randIndex2];
      key[randIndex2] = temp;
    }
    System.out.println("Key: "+Arrays.toString(key));
  }
  public void solveShuffle(){
    boolean keepGoing = true;
    Row guess;
    Random random = new Random();
    int count = 0;//the number of guesses made.
    while(keepGoing){
      if(count==3){
        shuffleKey();
        for(int i = 0; i<keyValues.size();i++){
          permutations(keyValues.get(i),0,4);
        }
      }
      count++;
      guess = keyValues.get(random.nextInt(keyValues.size()));
      String Gscore = guess.scoreGuess(key);
      System.out.println(guess+"  "+Gscore);
      for(int i = 0; i < keyValues.size(); i++){
        if(!Gscore.equals(guess.scoreGuess(keyValues.get(i).getGuess()))){
          keyValues.delete(i);
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
  public void play(){
    setKey();
    setKeyValues();
    long sTime = System.currentTimeMillis();
    solve();
    sTime = System.currentTimeMillis()-sTime;
    System.out.println("Time for looping function: "+sTime);
    keyValues.clear();
    setKeyValues();
    sTime = System.currentTimeMillis();
    recursiveSolve(keyValues);
    sTime = System.currentTimeMillis() - sTime;
    System.out.println("Time for the recursive function: "+sTime);
    
    System.out.println("Shuffle solve with the same key: ");
    keyValues.clear();
    setKeyValues();
    solveShuffle();
  }
}
