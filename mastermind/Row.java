import java.util.*;
public class Row{
  final static int length = 4;
  protected int[] guess;
  protected String score;

  public String scoreGuess(int[] key){
    ArrayList<int[]> usedBlack = new ArrayList<int[]>();
    ArrayList<int[]> usedWhite = new ArrayList<int[]>();
    for(int g = 0; g < length; g++){
      for(int k = 0; k < length; k++){
        if(key[k]==guess[g]){
          if(g==k){
            usedBlack.add(new int[]{k,g});
          }else{
            usedWhite.add(new int[]{k,g});
          }//end else
        }//end if
      }//end for
    }//end for
    ArrayList<int[]> used = new ArrayList<int[]>();
    used.addAll(usedBlack);
    used.addAll(usedWhite);
    used = removeDuplicate(used);
    String theScore = "";
    for(int[] currentArr : used){
      if(usedBlack.indexOf(currentArr)!=-1){
        theScore += "b";
      }else{
        theScore += "w";
      }
    }
    usedBlack.clear();usedWhite.clear();used.clear();
    return theScore;
  }
  private ArrayList<int[]> removeDuplicate(ArrayList<int[]> used){
    for(int r = 0;r<4;r++){
    for(int i = 0; i < used.size()-1; i++){
      for(int j = i+1; j < used.size(); j++){
        if(used.get(i)[0]==used.get(j)[0] || used.get(i)[1]==used.get(j)[1]){
          used.remove(j);j--;
        }
      }
    }
    }
    return used;
  }
  Row(int[] guess){
    this.guess = guess;
  }
  Row(){
    guess = new int[]{-1,-1,-1,-1};
  }
  public int[] getGuess(){
    return guess;
  }
  @Override
  public String toString(){
    return Arrays.toString(guess);
  }
  public void makeGuess(int index, int value){
    guess[index] = value;
  }
  public static void main(String[] args){
    Row a = new Row(new int[]{5,2,2,5});
    System.out.println(a.scoreGuess(new int[]{4,2,6,2}));
  }
}
