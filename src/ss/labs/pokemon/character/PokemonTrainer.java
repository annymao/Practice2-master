package ss.labs.pokemon.character;

import ss.labs.pokemon.PokemonData;

import javax.lang.model.type.PrimitiveType;

/**
 * Created by jerry on 2017/3/7.
 */
public class PokemonTrainer extends NPC{
    protected PokemonData pokemonData;
    protected int money;
    //TODO solve the error
    public PokemonTrainer(String name, String job, String quote, PokemonData data, int money)
    {

        //TODO call super constructor
        super(name,job,quote);
        //TODO assign attributes
        pokemonData=data;
        this.money=money;
    }

    //TODO override toString()
    public void getMoney(int award)
    {
        money=money+award;
    }
    public int getMoney()
    {
        return money;
    }
    public PokemonData getPokemonData()
    {
        return pokemonData;
    }
    public void lose()
    {
        money=0;
    }
    @Override
    public String toString()
    {
        return super.toString()+"Pokemon data:\n"
                +"  id: "+pokemonData.getId()+"\n"
                +"  name: "+pokemonData.getName()+"\n"
                +"  type: "+pokemonData.getType()+"\n"
                +"  move: "+pokemonData.getMove()+"\n";
    }
}
