package ss.labs.pokemon.character;

import ss.labs.pokemon.PokemonData;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by jerry on 2017/3/7.
 */
public class NPC extends AbstractCharacter {

    //TODO more attributes are needed
    protected  String quote;
    //TODO solve the error
    public NPC(String name,String job,String quote){
        //TODO call super constructor
        super(name,job);
        //TODO assign attribute
        this.quote=quote;
    }

    public void interact(PokemonTrainer trainer)
    {
        speak(trainer);
    }

    public void speak(PokemonTrainer trainer){
        //TODO NPC say something...
        Scanner scanner=new Scanner(System.in);
        System.out.println(name+": "+quote);
        if(job.equals("Villager"))
        {
            Random num=new Random();
            int award=num.nextInt(30)+1;
            trainer.getMoney(award);
            System.out.printf("%s gives you %d dollars!\n",name,award);
            System.out.println("trainer: Thank you!");
            scanner.nextLine();
        }
        else if(job.equals("Nurse"))
        {
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
        else
        {
            scanner.nextLine();
        }
    }

    //TODO override toString()
    @Override
    public String toString()
    {
        return "name: "+name+"\n"+"job: "+job+"\n";
    }
    @Override
    public void showInformation()
    {
        System.out.println(toString());
    }

    public String  getName()
    {
        return name;
    }

    public String getJob()
    {
        return job;
    }

}
