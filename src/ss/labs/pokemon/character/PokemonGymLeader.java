package ss.labs.pokemon.character;

import ss.labs.pokemon.PokemonData;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by anny on 2017/3/10.
 */
public class PokemonGymLeader extends PokemonTrainer{
    protected ArrayList<PokemonData> pokemonList;
    protected String badge;
    protected int visited;

    public PokemonGymLeader(String name, String job, String quote, ArrayList<PokemonData> data, String badge,int visited)
    {

        super(name,job,quote);
        pokemonList=data;
        this.badge=badge;
        this.visited=visited;
    }

    public PokemonData getPokemonData()
    {
        Random random=new Random();
        return pokemonList.get(random.nextInt(pokemonList.size()));
    }
    public String getBadge()
    {
        return badge;
    }
    public void getVisited(int i)
    {
        visited=i;
    }
    public int getVisited()
    {
        return visited;
    }
    @Override
    public void speak(PokemonTrainer trainer)
    {
        Scanner scanner=new Scanner(System.in);
        if(getVisited()==0)
        {
            int win=battle(trainer);
            if(win==1)
            {
                giveBadge();
                trainer.putBadges(getBadge());
                System.out.println(trainer.getName() + ": Thank you!");
                getVisited(1);
                scanner.nextLine();
            }
            else
            {
                win();
                scanner.nextLine();

                System.out.println("Go to pokemon center...\nYou meet Joy, who is a nurse.");
                System.out.println("Joy: Do you need some help?");
                trainer.getPokemonData().healing();
                System.out.println("Joy: Your pokemon is full of HP! Here you go!");
                scanner.nextLine();
            }
        }
        else
        {
            System.out.println(name+": Well... I think you had get the badge already!");
            scanner.nextLine();
        }
    }
    public void giveBadge()
    {
        System.out.println(name+": Here is the badge, good luck!");
    }
    public  void win()
    {
        System.out.println(name+": If you keep training without giving up, I'm sure we'll see each other again.");
    }
    @Override
    public String toString()
    {
        return "name: "+name+"\n"+"job: "+job+"\n";
    }
    @Override
    public void showInformation()
    {
        super.showInformation();
        System.out.println("Pokemon data:");
        for(PokemonData pokemonData : pokemonList)
        {
            System.out.println("  id: "+pokemonData.getId()+"\n"
                    +"  name: "+pokemonData.getName()+"\n"
                    +"  type: "+pokemonData.getType()+"\n"
                    +"  move: "+pokemonData.getMove()+"\n");
        }
    }
}
