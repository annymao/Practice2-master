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
    @Override
    public void speak(PokemonTrainer trainer)
    {

        Scanner scanner=new Scanner(System.in);
        super.speak(trainer);
        System.out.println("The Battle Start!");
        while(trainer.getPokemonData().getCurrentHP()>0 && pokemonData.getCurrentHP()>0)
        {
            if(trainer.getPokemonData().getSpeed()>=pokemonData.getSpeed())
            {
                System.out.printf("%s use %s\n",trainer.getPokemonData().getName(),trainer.getPokemonData().getMove());
                pokemonData.damage(trainer.getPokemonData().getAttack());
                System.out.printf("%s receive %d damage\n",pokemonData.getName(),trainer.getPokemonData().getAttack());
                if(pokemonData.getCurrentHP()>0)
                {
                    System.out.printf("%s has %d HP left.\n", pokemonData.getName(), pokemonData.getCurrentHP());
                }
                else
                {
                    System.out.printf("%s fainted.\n",pokemonData.getName());
                    System.out.printf("You win the battle, and you get %d dollars from %s\n",getMoney(),getName());
                    trainer.getMoney(getMoney());
                    trainer.getPokemonData().attackUp();
                    trainer.getPokemonData().speedUp();
                    pokemonData.healing();
                    scanner.nextLine();
                    break;
                }
                scanner.nextLine();
                System.out.printf("%s use %s\n",pokemonData.getName(),pokemonData.getMove());
                trainer.getPokemonData().damage(pokemonData.getAttack());
                System.out.printf("%s receive %d damage\n",trainer.getPokemonData().getName(),pokemonData.getAttack());
                if(trainer.getPokemonData().getCurrentHP()>0)
                {
                    System.out.printf("%s has %d HP left.\n", trainer.getPokemonData().getName(), trainer.getPokemonData().getCurrentHP());
                    scanner.nextLine();
                }
                else
                {
                    System.out.printf("%s fainted.\n",trainer.getPokemonData().getName());
                    System.out.println("You lose the battle, and all your money as well.");
                    trainer.lose();
                    pokemonData.healing();
                    scanner.nextLine();

                    System.out.println("Go to pokemon center...\nYou meet Joy, who is a nurse.");
                    System.out.println("Joy: Do you need some help?");
                    trainer.getPokemonData().healing();
                    System.out.println("Joy: Your pokemon is full of HP! Here you go!");
                    scanner.nextLine();
                    break;
                }
            }
            else
            {
                System.out.printf("%s use %s\n",pokemonData.getName(),pokemonData.getMove());
                trainer.getPokemonData().damage(pokemonData.getAttack());
                System.out.printf("%s receive %d damage\n",trainer.getPokemonData().getName(),pokemonData.getAttack());
                if(trainer.getPokemonData().getCurrentHP()>0)
                {
                    System.out.printf("%s has %d HP left.\n", trainer.getPokemonData().getName(), trainer.getPokemonData().getCurrentHP());

                }
                else
                {
                    System.out.printf("%s fainted.\n",trainer.getPokemonData().getName());
                    System.out.println("You lose the battle, and all your money as well.");
                    trainer.lose();
                    pokemonData.healing();
                    scanner.nextLine();

                    System.out.println("Go to pokemon center...\nYou meet Joy, who is a nurse.");
                    System.out.println("Joy: Do you need some help?");
                    trainer.getPokemonData().healing();
                    System.out.println("Joy: Your pokemon is full of HP! Here you go!");
                    scanner.nextLine();
                    break;
                }
                scanner.nextLine();
                System.out.printf("%s use %s\n",trainer.getPokemonData().getName(),trainer.getPokemonData().getMove());
                pokemonData.damage(trainer.getPokemonData().getAttack());
                System.out.printf("%s receive %d damage\n",pokemonData.getName(),trainer.getPokemonData().getAttack());
                if(pokemonData.getCurrentHP()>0)
                {
                    System.out.printf("%s has %d HP left.\n", pokemonData.getName(), pokemonData.getCurrentHP());
                    scanner.nextLine();
                }
                else
                {
                    System.out.printf("%s fainted.\n",pokemonData.getName());
                    System.out.printf("You win the battle, and you get %d dollars from %s\n",getMoney(),getName());
                    trainer.getMoney(getMoney());
                    trainer.getPokemonData().attackUp();
                    trainer.getPokemonData().speedUp();
                    pokemonData.healing();
                    scanner.nextLine();
                    break;
                }
            }
        }
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
