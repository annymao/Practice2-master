package ss.labs.pokemon.character;

import ss.labs.pokemon.PokemonData;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by jerry on 2017/3/7.
 */
public class NPC extends AbstractCharacter {


    protected  String quote;

    public NPC(String name,String job,String quote){

        super(name,job);

        this.quote=quote;
    }

    public void interact(Player trainer)
    {
        speak(trainer);
    }

    public void speak(Player trainer){
        Scanner scanner=new Scanner(System.in);
        System.out.println(name+": "+quote);
        scanner.nextLine();
    }

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
