package ss.labs.pokemon;

import ss.labs.pokemon.character.NPC;
import ss.labs.pokemon.character.NPCGenerator;
import ss.labs.pokemon.character.PokemonGymLeader;
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

                    ((PokemonTrainer) npc).interact(morris);

                }
                else if(npc.getJob().equals("Gym Leader"))
                {
                    ((PokemonGymLeader)npc).interact(morris);
                }
                else
                {
                    npc.interact(morris);
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
        System.out.printf("The money you have: $%d\n",morris.getMoney());
        if(morris.getBadges().size()!=0)
        {
            System.out.println("The badges you get:\n");
            for (String badge : morris.getBadges())
            {
                System.out.println(badge);
            }
        }
        else
        {
            System.out.println("You don't get any badges!");
        }
    }
}
