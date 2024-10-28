import java.util.Random;

public class DungeonInitializer extends InteractableObjectInitializer {

    private int size;
    private Room front;
    private Room tail;
    private Room occupiedRoom;

    public DungeonInitializer() {
        size = 0;
        front = null;
        tail = null;
    }

    //Adds rooms in a circular list
    public void addRoom(boolean exit, InteractableObjects entity) {
        if (front == null) {
            Room newBox = new Room(null, null, exit, entity);
            front = newBox;
            tail = front;

        } else {
            Room current = tail;
            Room newBox = new Room(null, current, exit, entity);
            current.setNextRoom(newBox);
            tail = current.getNextRoom();
            front.setPreviousRoom(tail);
            tail.setNextRoom(front);

        }
        size++;
    }

    //Sets everything to null, essentially wiping the floor
    public void clearRoom(){
        front = null;
        tail = null;
    }

    //Removes entity, used when player kills or uses entity
    public void removeEntity(){
        occupiedRoom.removeEntity();
    }

    //Sets whatever is in front to occupied room, which is where our player will be
    public void getStartingPosition(){
        occupiedRoom = front;
    }

    //Getters
    public String getEntityName(){
        return occupiedRoom.entityName();
    }

    public InteractableObjects getEntity(){
        return occupiedRoom.getEntity();
    }

    //Movement
    public void moveRight(){
        occupiedRoom = occupiedRoom.getNextRoom();
    }

    public void moveLeft(){
        occupiedRoom = occupiedRoom.getPreviousRoom();
    }

    //Will return true if the current room occupied is an exit room
    public boolean isRoomExit(){
        return occupiedRoom.isExit();
    }

    //Will randomly make one of the 12 rooms the exit room
    public boolean[] exitRoom(){
        Random randomNumber = new Random();
        boolean[] exits = new boolean[12];
        int RoomRNG = randomNumber.nextInt(exits.length - 1);
        exits[RoomRNG+1] = true;
        return exits;
    }

    //Flavor text
    public void introduction(){
        System.out.println("You awaken in a dimly lit dungeon room with nothing but a sword and the clothes on your back.");
        System.out.println("To your left is a door, and to the right is the same.");
        System.out.println("You don't know where you are, all you know is that you must escape.");
        System.out.println("Type: 'HELP' for controls.");
    }

    public void instructions(){
        System.out.println();
        System.out.println("CONTROLS:");
        System.out.println("Type: 'HELP' for controls.");
        System.out.println("Type: 'RIGHT' to move right.");
        System.out.println("Type: 'LEFT' to move left.");
        System.out.println("Type: 'ATTACK' to attack.");
        System.out.println("Type: 'FLEE' to disengage.");
        System.out.println("Type: 'ESCAPE' to exit.");
        System.out.println("Type: 'INTERACT' to use.");
        System.out.println("Type: 'IGNORE' to ignore.");
        System.out.println("Type: 'STATS' for player stats.");
    }

    public void invalidInput(){
        System.out.println("Invalid input. Please try again.");
    }

    //Indents to make more readable
    public void textIndentornator(){
        System.out.println();
        System.out.println("---");
    }

    public void floorLevel(int x){
        System.out.println("Floor level: " + x);
    }




}

