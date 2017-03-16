package ss.labs.pokemon.character;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by anny on 2017/3/16.
 */
public class Fisherman extends NPC {
    public Fisherman(String name, String job, String quote) {
        super(name, job, quote);
    }
    //override speak()
    @Override
    public void speak(Player trainer) {
        super.speak(trainer);
        Scanner scanner = new Scanner(System.in);
        //if the player have enough money, he will cost $5 to rent a fishing rod and go fishing with the fisherman
        if (trainer.getMoney() > 5) {
            trainer.pay(5);
            System.out.println("You cost 5 dollars to rent a fishing rod.");
        } else {
            System.out.printf("%s:Oh no!You don't have enough money to rent a fishing rod QQ ", name);
        }
        scanner.nextLine();
    }
}
