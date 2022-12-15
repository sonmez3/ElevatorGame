package ElevatorGame;



public class ElevatorPerson {
    
    private int enterTime;
    
    private int initialPosition;
    
    private int target;
    
    private Person person;

   

    
    
    
    //constructor with person, initialPosition and target
    public ElevatorPerson(Person p, int ip, int t) {
        this.person = p;
        this.initialPosition = ip;
        this.target = t;
        
       
        enterTime = Elevator.getTravelMeter();
        
    }

    public int getEnterTime() {
        return enterTime;
    } 
  
    public void setEnterTime(int enterTime) {
        this.enterTime = enterTime;
    }

    
    
    
    public Person getPerson() {
        return person;
    }
    
    public int getTarget() {
        return target;
    }
    
    @Override
    public String toString() {
        String happy;
        
        
        int travelTime = Math.abs(Elevator.getTravelMeter() - enterTime) + 1;
        
        if(travelTime <= Math.abs(target - initialPosition)) {
            happy = "happy";
        }
        else{
            happy = "unhappy";
        }
        
        
        return " I am " + person.getName() +
               ".\n I traveled " + travelTime + " floors.\n " +
               "I am " + happy + ".";
        
    }
    
    
}
