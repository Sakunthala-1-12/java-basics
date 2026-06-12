package queue;
class MyQueue{
    private Bike front,rear;
    public String getFront (){
        return (front!=null)?front.model:"Empty";
    }
    public String getRear(){
        return (rear!=null)?raer.model:"Empty";
    }
    public boolean isEmpty(){
        return front==null;
    }
}
public void enqueue (string value){
    Bike obj = new Bike(value);       
    if(is empty()){
        front=rear=obj;
        System.out.println(value+"added empty queue");
    }
    else{
        rear.next=obj
    }
    }