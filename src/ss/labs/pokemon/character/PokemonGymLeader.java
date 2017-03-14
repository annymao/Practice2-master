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

        PokemonData poke=getPokemonData();
        Scanner scanner=new Scanner(System.in);
        System.out.println(name+": "+quote);
        scanner.nextLine();
        if(getVisited()==0)
        {
            System.out.println("The Battle Start!");
            System.out.println(getName()+": GO! "+poke.getName()+"!");
            while (trainer.getPokemonData().getCurrentHP() > 0 && poke.getCurrentHP() > 0)
            {
                if (trainer.getPokemonData().getSpeed() >= poke.getSpeed())
                {
                    System.out.printf("%s use %s\n", trainer.getPokemonData().getName(), trainer.getPokemonData().getMove());
                    poke.damage(trainer.getPokemonData().getAttack());
                    System.out.printf("%s receive %d damage\n", poke.getName(), trainer.getPokemonData().getAttack());
                    if (poke.getCurrentHP() > 0)
                    {
                        System.out.printf("%s has %d HP left.\n", poke.getName(), poke.getCurrentHP());
                    }
                    else
                    {
                        System.out.printf("%s fainted.\n", poke.getName());
                        giveBadge();
                        trainer.putBadges(getBadge());
                        System.out.println(trainer.getName() + ": Thank you!");
                        getVisited(1);
                        trainer.getPokemonData().attackUp();
                        trainer.getPokemonData().speedUp();
                        poke.healing();
                        scanner.nextLine();
                        break;
                    }
                    scanner.nextLine();
                    System.out.printf("%s use %s\n", poke.getName(), poke.getMove());
                    trainer.getPokemonData().damage(poke.getAttack());
                    System.out.printf("%s receive %d damage\n", trainer.getPokemonData().getName(), poke.getAttack());
                    if (trainer.getPokemonData().getCurrentHP() > 0)
                    {
                        System.out.printf("%s has %d HP left.\n", trainer.getPokemonData().getName(), trainer.getPokemonData().getCurrentHP());
                        scanner.nextLine();
                    }
                    else
                    {
                        System.out.printf("%s fainted.\n", trainer.getPokemonData().getName());
                        System.out.println("You lose the battle.");
                        win();
                        poke.healing();
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
                    System.out.printf("%s use %s\n", poke.getName(), poke.getMove());
                    trainer.getPokemonData().damage(poke.getAttack());
                    System.out.printf("%s receive %d damage\n", trainer.getPokemonData().getName(), poke.getAttack());
                    if (trainer.getPokemonData().getCurrentHP() > 0)
                    {
                        System.out.printf("%s has %d HP left.\n", trainer.getPokemonData().getName(), trainer.getPokemonData().getCurrentHP());

                    }
                    else
                    {
                        System.out.printf("%s fainted.\n", trainer.getPokemonData().getName());
                        System.out.println("You lose the battle.");
                        win();
                        poke.healing();
                        scanner.nextLine();

                        System.out.println("Go to pokemon center...\nYou meet Joy, who is a nurse.");
                        System.out.println("Joy: Do you need some help?");
                        trainer.getPokemonData().healing();
                        System.out.println("Joy: Your pokemon is full of HP! Here you go!");
                        scanner.nextLine();
                        break;
                    }
                    scanner.nextLine();
                    System.out.printf("%s use %s\n", trainer.getPokemonData().getName(), trainer.getPokemonData().getMove());
                    poke.damage(trainer.getPokemonData().getAttack());
                    System.out.printf("%s receive %d damage\n", poke.getName(), trainer.getPokemonData().getAttack());
                    if (poke.getCurrentHP() > 0)
                    {
                        System.out.printf("%s has %d HP left.\n", poke.getName(), poke.getCurrentHP());
                        scanner.nextLine();
                    }
                    else
                    {
                        System.out.printf("%s fainted.\n", poke.getName());
                        giveBadge();
                        trainer.putBadges(getBadge());
                        System.out.println(trainer.getName() + ": Thank you!");
                        getVisited(1);
                        trainer.getPokemonData().attackUp();
                        trainer.getPokemonData().speedUp();
                        poke.healing();
                        scanner.nextLine();
                        break;
                    }
                }
            }
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
