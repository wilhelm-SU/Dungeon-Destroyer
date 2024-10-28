public class HealthPotion extends Items{

    HealthPotion(){
        super("Health Potion", "Increases current health by 5.");
    }

    @Override
    public void interaction(Player player) {
        player.setHealth(player.getHealth() + 5);
        if(player.getHealth() > player.getBasePlayerHealth()){
            player.setHealth(player.getBasePlayerHealth());
        }
    }


}
