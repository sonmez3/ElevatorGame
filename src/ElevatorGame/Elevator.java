package ElevatorGame;

public class Elevator {

    static int counter = 0;
     
    private static int travelMeter = 0;
    private int currentFloor;

    private int maxFloor = 10;
    private int minFloor = 0;

    private MyStack people;
   
    String a = "";
    
  
     

    public MyStack getPeople() {
        return people;
    }

    public void setPeople(MyStack people) {
        this.people = people;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    private int capacity;

    
    // no-args constructor
    public Elevator() {
        this(4, 0, 10);
        currentFloor = 0;

        
        people = new MyStack();

    }
    
    //constructor with capacity, min and max floors
    public Elevator(int size, int minFloor, int maxFloor) {

        
        this.capacity = size;

        this.maxFloor = maxFloor;
        this.minFloor = minFloor;

        currentFloor = 0;

        
        people = new MyStack();

    }

    public final static int getTravelMeter() {

        return travelMeter;
    }

    
    
    
    // firstly checking if the target is out of bounds, if yes throwing the exception
    //if not, checking if elevator is full, if yes return false
    //if not, adding person to stack, printing its name and " is in"
    public boolean enter(Person p, int target) throws IllegalArgumentException {

        ElevatorPerson elperson = new ElevatorPerson(p, currentFloor, target);

        if (target > maxFloor || target < minFloor) {
            throw new IllegalArgumentException("target " + target + " out of bounds");
        } else {
            if (!isFull()) {
                
                people.push(elperson);
                
                //System.out.println(elperson.getPerson().getName() + " is in.");
                return true;
            } else {
                return false;
            }
        }

    }
    
    
    
    //calculating travelMeter by getting abs of difference of current floor
    //checking if floor is out of bounds, if yes throw the exception
    //if not, in loop checking from the top of the stack if
    //current floor is matching with person's target, if yes pop that person nad print
    //if not stop the loop and print Elevator
    public void goToFloor(int floor) throws IllegalArgumentException {
        
       
        
        int previousFloor = currentFloor;
        currentFloor = floor;

        if (floor > maxFloor || floor < minFloor) {
            throw new IllegalArgumentException("floor " + floor + " out of bounds");
        }

        travelMeter += Math.abs(currentFloor - previousFloor);
        

        for (int i = people.getSize(); i > 0; i--) {
            Object p = people.peek();
            
            ElevatorPerson lastPerson = (ElevatorPerson) p;
            int lastTarget = lastPerson.getTarget();
            String lastName = lastPerson.getPerson().getName();
            
        

            if (floor == lastTarget) {
                
                a = lastPerson.toString();
                //System.out.println(lastName + " is out.");
                //System.out.println(lastPerson);
                people.pop();
               
                counter++;
                
                              
            }
        }

        //System.out.println(this);

    }

    
    // checking targets from top of the stack and invoking goToFloor until elevator is empty
    public void releaseEveryone() {

        do {
            Object p = people.peek();
            ElevatorPerson lastPerson = (ElevatorPerson) p;
            int lastTarget = lastPerson.getTarget();

            goToFloor(lastTarget);
        } while (isEmpty() != true);
    }

    
    //checking if elevator is full
    public boolean isFull() {

        if (people.getSize() == capacity) {
            return true;
        } else {
            return false;
        }

    }

    //checking if elevator is empty
    public boolean isEmpty() {

        if (people.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {

        return "Elevator is on floor: " + currentFloor + ", Number of people: " + people.getSize();

    }

}
