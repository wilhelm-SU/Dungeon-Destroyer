import java.util.Random;

public class InteractableObjectInitializer{

    Random randomNumber = new Random();

    //Randomly picks a monster from the list
    public InteractableObjects randomMonster(){
        InteractableObjects[] monsterRoster = {new Goblin(), new Zombie(), new ZombieKnight()};
        int MonsterRNG = randomNumber.nextInt(monsterRoster.length);
        return monsterRoster[MonsterRNG];
    }

    //Randomly picks an item from the list
    //Health Potion is in twice to double its odds for balancing
    public InteractableObjects randomItem(){
        InteractableObjects[] itemRoster = {new HealthPotion(), new HealthPotion(), new ArmorPlating(), new Whetstone()};
        int ItemRNG = randomNumber.nextInt(itemRoster.length);
        return itemRoster[ItemRNG];
    }

    //Randomly populates an array with entities
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
        for(int i = 0; i < 3; i++){
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