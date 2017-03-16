package ss.labs.pokemon.character;

import ss.labs.pokemon.PokemonData;

import java.util.ArrayList;

/**
 * Created by anny on 2017/3/16.
 */
public class Player extends NPC {

    protected int money;
    protected ArrayList<String> badges;
    protected ArrayList<PokemonData> pokemonList;

    public Player(String name, String job, String quote, ArrayList<PokemonData> data, int money) {
        super(name, job, quote);
        pokemonList = data;
        this.money = money;
        badges = new ArrayList<String>();
    }
    //get money from others
    public void getMoney(int award) {
        money = money + award;
    }
    //pay for something
    public void pay(int cost) {
        money = money - cost;
    }
    //get the total money the player have
    public int getMoney() {
        return money;
    }
    //get the pokemon from the list(now only have one pokemon)
    public PokemonData getPokemonData() {
        return pokemonList.get(0);
    }
    //get the badges ArrayList
    public ArrayList<String> getBadges() {
        return badges;
    }
    //add badges into arraylist
    public void putBadges(String badge) {
        badges.add(badge);
    }
    //you lose the battle and give all your money
    public void lose() {
        money = 0;
    }
}
