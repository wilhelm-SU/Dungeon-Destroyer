public class Room {

    private Room next;
    private Room previous;
    private boolean exit;
    private InteractableObjects interactableObjects;

    public Room(Room nextRoom, Room previousRoom, boolean exitRoom, InteractableObjects objects) {
        next = nextRoom;
        previous = previousRoom;
        exit = exitRoom;
        interactableObjects = objects;
    }

    //Getters
    public Room getNextRoom(){
        return next;
    }

    public Room getPreviousRoom(){
        return previous;
    }

    //Setters
    public void setNextRoom(Room nextRoom){
        next = nextRoom;
    }

    public void setPreviousRoom(Room previousRoom){
        previous = previousRoom;
    }

    //Exit
    public boolean isExit(){
        return exit;
    }

    //Entity
    public String entityName(){
        return interactableObjects.getName();
    }

    public InteractableObjects getEntity() {
        return interactableObjects;
    }

    public void removeEntity() {
        interactableObjects = null;
    }

}
