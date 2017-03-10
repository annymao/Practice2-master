package ss.labs.pokemon.character;

import ss.labs.pokemon.PokemonData;

import java.util.ArrayList;

/**
 * Created by jerry on 2017/3/7.
 * In this practice you will see the power of polymorphism
 * practice to inherit and
 */
public class NPCGenerator {
    //no modifier is private
    private ArrayList<NPC> npcTemplates;
    public NPCGenerator()
    {
        npcTemplates = new ArrayList<>();
        //villager
        NPC npcJohn=new NPC("John","Villager","Hello! Have a nice day!");
        npcTemplates.add(npcJohn);
        //fisherman
        NPC npcHarry=new NPC("Harry","Fisherman","Let's go fishing!");
        npcTemplates.add(npcHarry);
        //mom
        NPC npcMom=new NPC("Mom","Housewife","You finally remember to go home,huh?");
        npcTemplates.add(npcMom);
        //nurse
        NPC npcJoy=new NPC("Joy","Nurse","Can I help you?");
        npcTemplates.add(npcJoy);


        //trainer
        PokemonData maryPokemon=new PokemonData(25,"Pikachu","Electric","Thunderbolt",100,100,10,10);
        PokemonTrainer trainerMary=new PokemonTrainer("Mary","Pokemon Trainer","Let's battle!!!",maryPokemon,10);
        npcTemplates.add(trainerMary);
        //trainer
        PokemonData annyPokemon=new PokemonData(120,"Staryu","Water","Water Gun",100,100,10,15);
        PokemonTrainer trainerAnny=new PokemonTrainer("Anny","Pokemon Trainer","You'd better not take me too lightly! My water-type pokemon is tough!",annyPokemon,15);
        npcTemplates.add(trainerAnny);
        //trainer
        PokemonData tomPokemon=new PokemonData(123,"Scyther","Grass","Wing Attack",100,100,15,20);
        PokemonTrainer trainerTom=new PokemonTrainer("Tom","Pokemon Trainer","Hi man!I challenge you!!",tomPokemon,15);
        npcTemplates.add(trainerTom);
        //trainer
        PokemonData bluePokemon=new PokemonData(65,"Alakazam","Psychic","Confusion",100,100,20,30);
        PokemonTrainer trainerBlueOak=new PokemonTrainer("Blue Oak","Pokemon Trainer","Let's Check out our Pokemon! Come on,I'll take you on!",bluePokemon,30);
        npcTemplates.add(trainerBlueOak);

        //Gym leader
        ArrayList<PokemonData> jasmineList=new ArrayList<PokemonData>();
        PokemonData jasminePokemonOne=new PokemonData(81,"Magnemite","Electric/Steel","Thunder Wave",120,120,30,40);
        jasmineList.add(jasminePokemonOne);
        PokemonData jasminePokemonTwo=new PokemonData(208,"Steelix","Steel/Ground","Iron Tail",130,130,20,50);
        jasmineList.add(jasminePokemonTwo);
        PokemonGymLeader leaderJasmine=new PokemonGymLeader("Jasmine","Gym Leader","Um...Hello. Shall we start?",jasmineList,"Olivine",0);
        npcTemplates.add(leaderJasmine);
    }

    //Try ctrl-N or command-N, click on Getter, you will see something useful
    //TODO write a public method to return npctemplates
    public ArrayList<NPC> getNpcTemplates()
    {
        return npcTemplates;
    }

}
