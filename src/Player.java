import java.util.Random;

public class Player {

    //What the player starts off with, essentially their current max stats
    private int basePlayerHealth = 15;
    private int basePlayerAttack = 5;
    private int basePlayerDefense = 10;
    private int basePlayerSpeed = 10;

    private int health = 0;
    private int attack = 0;
    private int defense = 0;
    private int speed = 0;

    Player() {
        health = basePlayerHealth;
        attack = basePlayerAttack;
        defense = basePlayerDefense;
        speed = basePlayerSpeed;
    }

    Random hitRNG = new Random();

    //Attack method
    public void attack(InteractableObjects targetMonster){
        int d20 = hitRNG.nextInt(20) + 1;
        System.out.println("You roll a " + d20 + " to attack.");
            if(d20 > targetMonster.getDefense()) {
                System.out.println("You hit!");
                int resultingHp = (targetMonster.getHealth()) - (this.getAttack());
                if (resultingHp > 0) {
                    targetMonster.setHealth(resultingHp);
                }
                if (resultingHp <= 0) {
                    targetMonster.setHealth(0);
                }
                System.out.println("Enemy health: " + targetMonster.getHealth());
            }
            else{
                System.out.println("You miss!");
            }
        }

    //Current stat getters
    public int getHealth() {
        return health;
    }

    public int getAttack(){
        return attack;
    }

    public int getDefense(){
        return defense;
    }

    public int getSpeed(){
        return speed;
    }

    public void getStats(){
        System.out.println("Health: " + this.getHealth());
        System.out.println("Attack " + this.getBasePlayerAttack());
        System.out.println("Defense " + this.getBasePlayerDefense());
        System.out.println("Speed " + this.getSpeed());
    }

    //Max stats getters
    public int getBasePlayerHealth(){
        return basePlayerHealth;
    }

    public int getBasePlayerAttack(){
        return basePlayerAttack;
    }

    public int getBasePlayerDefense(){
        return basePlayerDefense;
    }

    public int getBasePlayerSpeed(){
        return basePlayerSpeed;
    }

    //Current stat setters
    public void setHealth(int newHealth) {
        health = newHealth;
    }

    public void setDefense(int newDefense) {
        defense = newDefense;
    }

    public void setAttack(int newAttack){
        attack = newAttack;
    }

    //Max stats setters
    public void setBasePlayerHealth(int newHealth) {
        basePlayerHealth = newHealth;
    }

    public void setBasePlayerAttack(int newAttack){
        basePlayerAttack = newAttack;
    }

    public void setBasePlayerDefense(int newDefense){
        basePlayerDefense = newDefense;
    }

}
