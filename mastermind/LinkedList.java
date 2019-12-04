public class LinkedList{
  Node head;

  LinkedList(){
    head = null;
  }

  public void append(Row element){
    if(head==null) head = new Node(element);
    else{
      Node a = head;
      while(a.getNext()!=null){
        a = a.getNext();
      }
      a.setNext(new Node(element));
    }
  }

  public Row get(int i){
    Node it = head;
    int count = 0;
    while(it.getNext()!=null&&count != i){
      count++;
      it = it.getNext();
    }
    return it.getPayload();
  }
  @Override
  public String toString(){
    String s = "[";
    Node it = head;
    while(it!=null){
      s += it.getPayload().toString() + ",";
      it = it.getNext();
    }
    if(s.length()==1) s = "[]";
    else s = s.substring(0,s.length()-1)+"]";
    return s;
  }
  public Row delete(int i){
    if(i==0){
      Row headRow = head.getPayload();
      head = head.getNext();
      return headRow;
    }
    Node currentNode = head;
    Node previousNode = head;
    Row payload = null;
    int count = 0;
    while(currentNode!=null){
      payload = currentNode.getPayload();
      if(count==i){
        previousNode.setNext(currentNode.getNext());
      }
      count++;
      previousNode = currentNode;
      currentNode = currentNode.getNext();
    }
     
    return payload;
  }
  public int get(Row r){
    Node it = head;
    int count = 0;
    while(it!=null){
      if(it.getPayload().equals(r))return count;
      count++;
      it = it.getNext();
    }
    return -1;
  }
  public int size(){
    int count = 0;
    Node n = head;
    while(n!=null){
      count++;
      n = n.getNext();
    }
    return count;
  }
  public void clear(){
    head = null;
  }
  public static void main(String [] args){
    LinkedList a = new LinkedList();
    a.append(new Row(new int[]{0,0,0,0}));
    a.append(new Row(new int[]{3,3,3,3}));
    a.append(new Row(new int[]{3,2,4,5}));
    a.append(new Row(new int[]{3,3,2,3}));
    if(a.get(new Row(new int[]{3,3,2,3}))==-1)a.append(new Row(new int[]{3,3,2,3}));
    System.out.println(a);
  }
}
