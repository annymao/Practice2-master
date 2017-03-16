package ss.labs.pokemon.character;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by anny on 2017/3/16.
 */
public class Nurse extends NPC {
    public Nurse(String name,String job,String quote){
        super(name,job,quote);
    }
    @Override
    public void speak(Player trainer)
    {
        super.speak(trainer);
        Scanner scanner =new Scanner(System.in);
        if(trainer.getPokemonData().getCurrentHP()<trainer.getPokemonData().getMaxHP())
        {
            trainer.getPokemonData().healing();
            System.out.println("Joy: Your pokemon is full of hp! Here you go!");
        }
        else
        {
            System.out.println("Your pokemon is very healthy!");
        }
        scanner.nextLine();
    }
}
