package ElevatorGame;
//Abdullah Bülbül, CENG201
//Stack example from the course book, uses an arraylist
import java.util.ArrayList;

public class MyStack {
    private ArrayList<Object> list = new ArrayList<>();
    
    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }

    public Object peek() {
        return list.get(getSize() - 1);
    }

    public Object pop() {
        Object o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    public void push(Object o) {
        list.add(o);
    }

    @Override /** Override the toString in the Object class */
    public String toString() {
        return  " "+list.toString();
    }
}