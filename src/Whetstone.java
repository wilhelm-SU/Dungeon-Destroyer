public class Whetstone extends Items{

    Whetstone(){
        super("Whetstone", "Increases max damage by 1.");
    }

    public void interaction(Player player){
        player.setBasePlayerAttack(player.getBasePlayerAttack() + 1);
        player.setAttack(player.getBasePlayerAttack());
    }
}
