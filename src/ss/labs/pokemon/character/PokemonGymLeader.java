package ss.labs.pokemon.character;

import ss.labs.pokemon.PokemonData;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by anny on 2017/3/10.
 */
public class PokemonGymLeader extends NPC{
    protected ArrayList<PokemonData> pokemonList;
    protected String badge;
    protected int visited;
    public PokemonGymLeader(String name, String job, String quote, ArrayList<PokemonData> data, String badge,int visited)
    {

        //TODO call super constructor
        super(name,job,quote);
        //TODO assign attributes
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
    public void speak()
    {
        if(visited==0)
        {
            super.speak();
        }
        else
        {
            System.out.println(name+": Well... I think you had get the badge already!");
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
        return super.toString();
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
