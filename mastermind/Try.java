import java.util.stream.Collectors;
import java.util.*;
public class Try{

public static void main(String[] args){
  ArrayList<Row> a = new ArrayList<Row>();
  a.add(new Row(new int[]{2,3,4,5}));
  a.add(new Row(new int[]{2,3,4,5}));
  Row b = new Row(new int[]{2,3,4,5});
  System.out.println(a.contains(b));
  //int[] ar = {1,2,3};
  //int[] ar1 = {1,2,3};
  //System.out.println(Arrays.equals(ar,ar1));
  //List<Row> b = a.stream().distinct().collect(Collectors.toList());
  //System.out.println(b);
}
}
