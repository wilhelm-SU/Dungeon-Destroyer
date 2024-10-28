abstract class Items implements InteractableObjects{

    String name;
    String description;

    Items(String itemName, String itemDescription){
        name = itemName;
        description = itemDescription;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth(){ return 0; }

    @Override
    public int getSpeed(){ return 0; }

    @Override
    public void setHealth(int newHealth){
    }

    @Override
    public int getDefense(){ return 0; }

    public String getDescription() {
        return description;
    }
}
