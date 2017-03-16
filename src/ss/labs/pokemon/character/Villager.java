package ss.labs.pokemon.character;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by anny on 2017/3/16.
 */
public class Villager extends NPC {
    public Villager(String name, String job, String quote) {
        super(name, job, quote);
    }

    @Override
    //get random amount of money
    public void speak(Player trainer) {
        super.speak(trainer);
        Scanner scanner = new Scanner(System.in);
        Random num = new Random();
        int award = num.nextInt(30) + 1;
        trainer.getMoney(award);
        System.out.printf("%s gives you %d dollars!\n", name, award);
        System.out.printf("%s : Thank you!\n", trainer.getName());
        scanner.nextLine();
    }
}
