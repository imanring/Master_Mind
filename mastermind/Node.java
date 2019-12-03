public class Node{
  Node next;
  Row payload;
  
  Node(){
    next = null;
    payload = null;
  }

  Node(Row payload){
    this.payload = payload;
    next = null;
  }
  public void setNext(Node next){
    this.next = next;
  }
  public Node getNext(){
    return next;
  }
  public void setPayload(Row payload){
    this.payload = payload;
  }
  public Row getPayload(){
    return payload;
  }
}
