import java.util.Random;

public class InteractableObjectInitializer{


    Random randomNumber = new Random();

    //Refills the roster with new monsters every floor, and randomly picks three
    public InteractableObjects randomMonster(){
        InteractableObjects[] monsterRoster = {new Goblin(), new Zombie(), new ZombieKnight()};
        int MonsterRNG = randomNumber.nextInt(monsterRoster.length);
        return monsterRoster[MonsterRNG];
    }

    public InteractableObjects randomItem(){
        InteractableObjects[] itemRoster = {new HealthPotion(), new ArmorPlating(), new Whetstone()};
        int ItemRNG = randomNumber.nextInt(itemRoster.length);
        return itemRoster[ItemRNG];
    }

    public InteractableObjects[] randomEntityRoster(){

        InteractableObjects[] entityRoster = new InteractableObjects[12];
        for(int i = 0; i < 3; i++){
            int entityRNG = randomNumber.nextInt(entityRoster.length - 1);
            if (entityRoster[entityRNG + 1] == null){
                entityRoster[entityRNG + 1] = randomMonster();
            }
            else{
                i--;
            }
        }
        for(int i = 0; i < 2; i++){
            int entityRNG = randomNumber.nextInt(entityRoster.length - 1);
            if (entityRoster[entityRNG + 1] == null){
                entityRoster[entityRNG + 1] = randomItem();
            }
            else{
                i--;
            }
        }
        return entityRoster;
    }



}