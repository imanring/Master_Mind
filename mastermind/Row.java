import java.util.*;
public class Row implements Cloneable{
  final static int length = 4;
  protected int[] guess;

  public Row clone() throws CloneNotSupportedException{
    Row r = (Row)super.clone();
    r.guess = Arrays.copyOf(this.guess,this.guess.length);
    return r;
  }  

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
    //to recognize errors
    if(used.size()>4){
      System.out.println(Arrays.toString(key)+" guess "+Arrays.toString(guess));
      for(int[] er : used) System.out.print(Arrays.toString(er));
      System.out.println();
    }
    String theScore = "";
    for(int[] currentArr : used){
      if(usedBlack.indexOf(currentArr)!=-1){
        theScore += "b";
      }else{
        theScore += "w";
      }
    }
    return theScore;
  }
  private ArrayList<int[]> removeDuplicate(ArrayList<int[]> used){
    //I cannot remember why I add this extra for loop but it was for a good reason.
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
  public int getVal(int index){
    return guess[index];
  }
  boolean equals(Row other){
    if(null == other) return false;
    if(guess != other.getGuess()) return false;
    return true;
  }
  public static void main(String[] args){
    Row a = new Row(new int[]{5,2,2,5});
    System.out.println(a.scoreGuess(new int[]{4,2,6,2}));
  }
}
