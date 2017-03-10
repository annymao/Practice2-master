package ss.labs.pokemon;

import ss.labs.pokemon.character.NPC;
import ss.labs.pokemon.character.NPCGenerator;
import ss.labs.pokemon.character.PokemonTrainer;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
	    //TODO create a character generator
        NPCGenerator character = new NPCGenerator();
        //TODO get all characters from character generator
        ArrayList<NPC> npcList=character.getNpcTemplates();
        //TODO print out characters' information, you can choose to use toString or showDescription
        PokemonData morrisPokemon = new PokemonData(1,"Bulbsoar","Grass","Vinewhip",100,100,15,15);
        PokemonTrainer morris = new PokemonTrainer("Morris","Pokemon Trainer","Hello",morrisPokemon,30);
        System.out.println("Game Start!");
        System.out.println("Welcome to the world of Pokemon!\nHere is your information:");
        System.out.printf("Name: %s\nJob: %s\nPokemon: %s\nMoney: $%d\n",morris.getName(),morris.getJob(),morrisPokemon.getName(),morris.getMoney());
        System.out.println("Press enter to continue...");
        scanner.nextLine();
        while(true)
        {
            // random generate NPC
            Random random= new Random();
            NPC npc = npcList.get(random.nextInt(npcList.size()));
            //show the pokemon's name, type, and move's name
            System.out.printf("You meet a %s.\n",npc.getJob());
            npc.showInformation();
            System.out.println("Enter your reaction(talk/ignore/quit):");
            String reaction= scanner.next().toLowerCase();
            scanner.nextLine();
            //avoid entering wrong command
            while((!reaction.equals("quit"))&&(!reaction.equals("talk"))&&(!reaction.equals("ignore")))
            {
                System.out.println("Please Enter the correct reaction(talk/ignore/quit):");
                reaction = scanner.next().toLowerCase();
                scanner.nextLine();
            }
            if(reaction.equals("talk"))
            {

                if(npc.getJob().equals("Pokemon Trainer"))
                {
                    npc.interact();
                    System.out.println("The Battle Start!");
                    PokemonTrainer component=(PokemonTrainer)npc;
                    PokemonData poke=component.getPokemonData();
                    while(morrisPokemon.getCurrentHP()>0 && poke.getCurrentHP()>0)
                    {
                        if(morrisPokemon.getSpeed()>=poke.getSpeed())
                        {
                            System.out.printf("%s use %s\n",morrisPokemon.getName(),morrisPokemon.getMove());
                            poke.damage(morrisPokemon.getAttack());
                            System.out.printf("%s receive %d damage\n",poke.getName(),morrisPokemon.getAttack());
                            if(poke.getCurrentHP()>0)
                            {
                                System.out.printf("%s has %d HP left.\n", poke.getName(), poke.getCurrentHP());
                            }
                            else
                            {
                                System.out.printf("%s fainted.\n",poke.getName());
                                System.out.printf("You win the battle, and you get %d dollars from %s\n",component.getMoney(),component.getName());
                                morris.getMoney(component.getMoney());
                                morrisPokemon.attackUp();
                                morrisPokemon.speedUp();
                                poke.healing();
                                scanner.nextLine();
                                break;
                            }
                            scanner.nextLine();
                            System.out.printf("%s use %s\n",poke.getName(),poke.getMove());
                            morrisPokemon.damage(poke.getAttack());
                            System.out.printf("%s receive %d damage\n",morrisPokemon.getName(),poke.getAttack());
                            if(morrisPokemon.getCurrentHP()>0)
                            {
                                System.out.printf("%s has %d HP left.\n", morrisPokemon.getName(), morrisPokemon.getCurrentHP());
                                scanner.nextLine();
                            }
                            else
                            {
                                System.out.printf("%s fainted.\n",morrisPokemon.getName());
                                System.out.println("You lose the battle, and all your money as well.");
                                morris.lose();
                                poke.healing();
                                scanner.nextLine();

                                System.out.println("Go to pokemon center...\nYou meet Joy, who is a nurse.");
                                System.out.println("Joy: Do you need some help?");
                                morrisPokemon.healing();
                                System.out.println("Joy: Your pokemon is full of HP! Here you go!");
                                scanner.nextLine();
                                break;
                            }
                        }
                        else
                        {
                            System.out.printf("%s use %s\n",poke.getName(),poke.getMove());
                            morrisPokemon.damage(poke.getAttack());
                            System.out.printf("%s receive %d damage\n",morrisPokemon.getName(),poke.getAttack());
                            if(morrisPokemon.getCurrentHP()>0)
                            {
                                System.out.printf("%s has %d HP left.\n", morrisPokemon.getName(), morrisPokemon.getCurrentHP());

                            }
                            else
                            {
                                System.out.printf("%s fainted.\n",morrisPokemon.getName());
                                System.out.println("You lose the battle, and all your money as well.");
                                morris.lose();
                                poke.healing();
                                scanner.nextLine();

                                System.out.println("Go to pokemon center...\nYou meet Joy, who is a nurse.");
                                System.out.println("Joy: Do you need some help?");
                                morrisPokemon.healing();
                                System.out.println("Joy: Your pokemon is full of HP! Here you go!");
                                scanner.nextLine();
                                break;
                            }
                            scanner.nextLine();
                            System.out.printf("%s use %s\n",morrisPokemon.getName(),morrisPokemon.getMove());
                            poke.damage(morrisPokemon.getAttack());
                            System.out.printf("%s receive %d damage\n",poke.getName(),morrisPokemon.getAttack());
                            if(poke.getCurrentHP()>0)
                            {
                                System.out.printf("%s has %d HP left.\n", poke.getName(), poke.getCurrentHP());
                                scanner.nextLine();
                            }
                            else
                            {
                                System.out.printf("%s fainted.\n",poke.getName());
                                System.out.printf("You win the battle, and you get %d dollars from %s\n",component.getMoney(),component.getName());
                                morris.getMoney(component.getMoney());
                                morrisPokemon.attackUp();
                                morrisPokemon.speedUp();
                                poke.healing();
                                scanner.nextLine();
                                break;
                            }
                        }
                    }
                }
                else if(npc.getJob().equals("Villager"))
                {
                    npc.interact();
                    Random num=new Random();
                    int award=num.nextInt(30)+1;
                    morris.getMoney(award);
                    System.out.printf("%s gives you %d dollars!\n",npc.getName(),award);
                    System.out.println("Morris: Thank you!");
                    scanner.nextLine();
                }
                else if(npc.getJob().equals("Nurse"))
                {
                    npc.interact();
                    if(morrisPokemon.getCurrentHP()<morrisPokemon.getMaxHP())
                    {
                        morrisPokemon.healing();
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
                    morris.interact();
                    npc.interact();

                    System.out.println("Morris:Bye-bye!");
                    scanner.nextLine();
                }
            }
            else if(reaction.equals("quit"))
            {
                System.out.println("You quit the game.\n");
                break;
            }
            else
            {
                System.out.printf("You ignore %s...\n",npc.getName());
                scanner.nextLine();
            }
        }
        System.out.printf("The money you have: $%d",morris.getMoney());
    }
}
