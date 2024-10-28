public class ArmorPlating extends Items {

    ArmorPlating(){
        super("Armor Plating", "Increases max defense by 1 for a max maximum of 15.");
    }

    @Override
    public void interaction(Player player) {
        if(player.getBasePlayerDefense() == 15) {
            System.out.println("Maximum defense reached.");
        }else{
                player.setBasePlayerDefense(player.getBasePlayerDefense() + 1);
                player.setDefense(player.getBasePlayerDefense());
            }
        }
    }
