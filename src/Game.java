import java.util.Scanner;

public class Game {

    DungeonInitializer game = new DungeonInitializer();
    Player user = new Player();
    Scanner userInput = new Scanner(System.in);

    boolean nextFloor = false;
    int floorNumber = 1;

    //Creates a randomized floor
    public void initializeGame() {
        boolean[] exitRoomRandom = game.exitRoom();
        InteractableObjects[] entityRoster = game.randomEntityRoster();

        for (int i = 0; i < 12; i++) {
            game.addRoom(exitRoomRandom[i], entityRoster[i]);
        }
        game.getStartingPosition();
    }

    //Is called whenever the player needs to move
    public void timeToMove() {
        game.textIndentornator();
        System.out.println("Will you go LEFT or RIGHT?");
        String input = "";
        String left = "LEFT";
        String right = "RIGHT";
        String help = "HELP";
        String stats = "STATS";
        while (!input.equals(left) && !input.equals(right)) {
            input = userInput.next();
            if (input.equals(right)) {
                game.moveRight();
            } else if (input.equals(left)) {
                game.moveLeft();
            } else if (input.equals(help)) {
                game.instructions();
            } else if (input.equals(stats)) {
                user.getStats();
            }
            else {
                game.invalidInput();
            }
        }
        if(game.getEntity() == null) {
            if(game.isRoomExit()){
                this.timeToLeave();
            }
            else {
                game.textIndentornator();
                System.out.println("The room is empty.");
                this.timeToMove();
            }
        }
        else {
            if (game.getEntity() instanceof Monster) {
                this.timeToAttack();
            } else if (game.getEntity() instanceof Items) {
                this.timeToInteract();
            } if (game.isRoomExit()) {
                this.timeToLeave();
            }
        }
    }

    //Called whenever the player finds an item
    public void timeToInteract(){
        game.textIndentornator();
        System.out.println("You come across a " + game.getEntityName());
        System.out.println("Will you INTERACT or IGNORE?");
        String input = "";
        String interact = "INTERACT";
        String ignore = "IGNORE";
        while (!input.equals(interact) && !input.equals(ignore)) {
            input = userInput.next();
            if (input.equals(interact)) {
                game.getEntity().interaction(user);
                System.out.println(game.getEntity().getDescription());
                game.removeEntity();
                if (game.isRoomExit()) {
                    this.timeToLeave();
                    break;
                }
                this.timeToMove();
                break;
            }
            if(input.equals(ignore)) {
                this.timeToMove();
                break;
            }
            else{
                game.invalidInput();
            }

        }

    }

    //Called whenever the player finds an exit
    public void timeToLeave(){
        game.textIndentornator();
        System.out.println("You come across what looks like an exit.");
        System.out.println("Will you ESCAPE or IGNORE?");
        String input = "";
        String escape = "ESCAPE";
        String ignore = "IGNORE";
        while (!input.equals(escape) && !input.equals(ignore)) {
            input = userInput.next();
            if(input.equals(escape)) {
                System.out.println("You climb a ladder, proceeding to the next floor.");
                floorNumber++;
                game.clearRoom();
                this.newFloor();

            }
            if(input.equals(ignore)) {
                this.timeToMove();
            }
            else{
                game.invalidInput();
            }
        }
    }

//Called whenever the player encounters an enemy
    public void timeToAttack(){
        game.textIndentornator();
        System.out.println("You encounter a " + game.getEntityName());
        System.out.println("Will you ATTACK or FLEE?");
        String input = "";
        String attack = "ATTACK";
        String flee = "FLEE";
        while (!input.equals(attack) && !input.equals(flee)) {
            input = userInput.next();
            if (input.equals(attack)) {
                if(user.getSpeed() > game.getEntity().getSpeed()){
                    while(user.getHealth() > 0 && game.getEntity().getHealth() > 0){
                        user.attack(game.getEntity());
                        if(game.getEntity().getHealth() == 0){
                            System.out.println("You have slayed the enemy.");
                            game.removeEntity();
                            if (game.isRoomExit()) {
                                this.timeToLeave();
                                break;
                            }
                            this.timeToMove();
                            break;
                        }
                        game.getEntity().interaction(user);
                        if(user.getHealth() == 0){
                            System.out.println("You have succumb to the dungeon. Game over.");
                            break;
                        }
                    }
                }
                if(user.getSpeed() < game.getEntity().getSpeed()){
                    while(user.getHealth() > 0 && game.getEntity().getHealth() > 0){
                        game.getEntity().interaction(user);
                        if(user.getHealth() == 0){
                            System.out.println("You have succumb to the dungeon. Game over.");
                            break;
                        }
                        user.attack(game.getEntity());
                        if(game.getEntity().getHealth() == 0){
                            System.out.println("You have slayed the enemy.");
                            game.removeEntity();
                            if (game.isRoomExit()) {
                                this.timeToLeave();
                                break;
                            }
                            this.timeToMove();
                            break;
                        }
                    }
                }
            }
            if(input.equals(flee)){
                System.out.println("You attempt to flee, the enemy attempts to strike!");
                game.getEntity().interaction(user);
                if(user.getHealth() == 0){
                    System.out.println("You have succumb to the dungeon. Game over");
                    break;
                }
                this.timeToMove();
                break;
            }
            else{
                game.invalidInput();
            }
        }

    }

    //Starts the game
    public void beginGame(){
        game.introduction();
        this.newFloor();
    }

    //Creates a new floor
    public void newFloor(){
        this.initializeGame();
        game.floorLevel(floorNumber);
        this.timeToMove();

    }
}