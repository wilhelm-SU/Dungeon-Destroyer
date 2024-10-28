public interface InteractableObjects {

    void interaction(Player player);

    int getHealth();

    int getSpeed();

    int getDefense();

    void setHealth(int health);

    String getDescription();

    String getName();
}

//interaction method, for both attack and heal
//The attack, heal, whatever method will be stored in interaction and called from there.