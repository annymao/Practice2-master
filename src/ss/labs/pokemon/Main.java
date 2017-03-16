package ss.labs.pokemon;

import ss.labs.pokemon.character.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // create a character generator
        NPCGenerator character = new NPCGenerator();
        // get all characters from character generator
        ArrayList<NPC> npcList = character.getNpcTemplates();
        //create player
        PokemonData morrisPokemon = new PokemonData(1, "Bulbsoar", "Grass", "Vinewhip", 100, 100, 15, 15);
        ArrayList<PokemonData> morrisPokeList = new ArrayList<>();
        morrisPokeList.add(morrisPokemon);
        Player morris = new Player("Morris", "Pokemon Trainer", "Hello", morrisPokeList, 30);
        System.out.println("Game Start!");
        System.out.println("Welcome to the world of Pokemon!\nHere is your information:");
        System.out.printf("Name: %s\nJob: %s\nPokemon: %s\nMoney: $%d\n", morris.getName(), morris.getJob(), morrisPokemon.getName(), morris.getMoney());
        System.out.println("Press enter to continue...");
        scanner.nextLine();

        while (true) {
            // random generate NPC
            Random random = new Random();
            NPC npc = npcList.get(random.nextInt(npcList.size()));
            //show the pokemon's name, type, and move's name
            System.out.printf("You meet a %s.\n", npc.getJob());
            npc.showInformation();
            System.out.println("Enter your reaction(talk/ignore/quit):");
            String reaction = scanner.next().toLowerCase();
            scanner.nextLine();
            //avoid entering wrong command
            while ((!reaction.equals("quit")) && (!reaction.equals("talk")) && (!reaction.equals("ignore"))) {
                System.out.println("Please Enter the correct reaction(talk/ignore/quit):");
                reaction = scanner.next().toLowerCase();
                scanner.nextLine();
            }
            if (reaction.equals("talk")) {
                    npc.interact(morris);
            } else if (reaction.equals("quit")) {
                System.out.println("You quit the game.\n");
                break;
            } else {
                System.out.printf("You ignore %s...\n", npc.getName());
                scanner.nextLine();
            }
        }
        System.out.printf("The money you have: $%d\n", morris.getMoney());
        if (morris.getBadges().size() != 0) {
            System.out.println("The badges you get:");
            for (String badge : morris.getBadges()) {
                System.out.println(badge);
            }
        } else {
            System.out.println("You don't get any badges!");
        }
    }
}
