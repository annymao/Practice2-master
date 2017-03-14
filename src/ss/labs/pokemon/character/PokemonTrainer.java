package ss.labs.pokemon.character;

import ss.labs.pokemon.PokemonData;

import javax.lang.model.type.PrimitiveType;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Created by jerry on 2017/3/7.
 */
public class PokemonTrainer extends NPC{
    protected PokemonData pokemonData;
    protected int money;
    protected ArrayList<String> badges;
    //TODO solve the error
    public PokemonTrainer(String name, String job, String quote)
    {

        //TODO call super constructor
        super(name,job,quote);
        //TODO assign attributes
    }
    public PokemonTrainer(String name, String job, String quote, PokemonData data, int money)
    {

        //TODO call super constructor
        super(name,job,quote);
        //TODO assign attributes
        pokemonData=data;
        this.money=money;
        badges=new ArrayList<String>();
    }
    public int battle(PokemonTrainer trainer)
    {
        int win=0;
        Scanner scanner=new Scanner(System.in);
        System.out.println(name+": "+quote);
        scanner.nextLine();
        System.out.println("The Battle Start!");
		PokemonData poke=getPokemonData();
        System.out.println(getName()+": GO! "+poke.getName()+"!");
        while(trainer.getPokemonData().getCurrentHP()>0 && poke.getCurrentHP()>0)
        {
            if(trainer.getPokemonData().getSpeed()>=poke.getSpeed())
            {
                System.out.printf("%s use %s\n",trainer.getPokemonData().getName(),trainer.getPokemonData().getMove());
                poke.damage(trainer.getPokemonData().getAttack());
                System.out.printf("%s receive %d damage\n",poke.getName(),trainer.getPokemonData().getAttack());
                if(poke.getCurrentHP()>0)
                {
                    System.out.printf("%s has %d HP left.\n", poke.getName(), poke.getCurrentHP());
                }
                else
                {
                    System.out.printf("%s fainted.\n",poke.getName());
                    trainer.getPokemonData().attackUp();
                    trainer.getPokemonData().speedUp();
                    poke.healing();
                    win=1;
                    break;
                }
                scanner.nextLine();
                System.out.printf("%s use %s\n",poke.getName(),poke.getMove());
                trainer.getPokemonData().damage(poke.getAttack());
                System.out.printf("%s receive %d damage\n",trainer.getPokemonData().getName(),poke.getAttack());
                if(trainer.getPokemonData().getCurrentHP()>0)
                {
                    System.out.printf("%s has %d HP left.\n", trainer.getPokemonData().getName(), trainer.getPokemonData().getCurrentHP());
                    scanner.nextLine();
                }
                else
                {
                    System.out.printf("%s fainted.\n",trainer.getPokemonData().getName());
                    poke.healing();
                    win=0;
                    break;
                }
            }
            else
            {
                System.out.printf("%s use %s\n",poke.getName(),poke.getMove());
                trainer.getPokemonData().damage(poke.getAttack());
                System.out.printf("%s receive %d damage\n",trainer.getPokemonData().getName(),poke.getAttack());
                if(trainer.getPokemonData().getCurrentHP()>0)
                {
                    System.out.printf("%s has %d HP left.\n", trainer.getPokemonData().getName(), trainer.getPokemonData().getCurrentHP());

                }
                else
                {
                    System.out.printf("%s fainted.\n",trainer.getPokemonData().getName());
                    poke.healing();
                    win=0;
                    break;
                }
                scanner.nextLine();
                System.out.printf("%s use %s\n",trainer.getPokemonData().getName(),trainer.getPokemonData().getMove());
                poke.damage(trainer.getPokemonData().getAttack());
                System.out.printf("%s receive %d damage\n",poke.getName(),trainer.getPokemonData().getAttack());
                if(poke.getCurrentHP()>0)
                {
                    System.out.printf("%s has %d HP left.\n", poke.getName(), poke.getCurrentHP());
                    scanner.nextLine();
                }
                else
                {
                    System.out.printf("%s fainted.\n",poke.getName());
                    trainer.getPokemonData().attackUp();
                    trainer.getPokemonData().speedUp();
                    poke.healing();
                    win=1;
                    break;
                }
            }
        }
        return win;
    }
    @Override
    public void speak(PokemonTrainer trainer)
    {

        Scanner scanner=new Scanner(System.in);
        int win=battle(trainer);
        if(win==1)
        {
            trainer.getMoney(getMoney());
            System.out.printf("You win the battle, and you get %d dollars from %s\n",getMoney(),getName());
        }
        else
        {
            trainer.lose();
            System.out.println("You lose the battle, and all your money as well.");
            scanner.nextLine();

            System.out.println("Go to pokemon center...\nYou meet Joy, who is a nurse.");
            System.out.println("Joy: Do you need some help?");
            trainer.getPokemonData().healing();
            System.out.println("Joy: Your pokemon is full of HP! Here you go!");
        }
        scanner.nextLine();
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
    public ArrayList<String> getBadges()
    {
        return badges;
    }
    public void putBadges(String badge)
    {
        badges.add(badge);
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
