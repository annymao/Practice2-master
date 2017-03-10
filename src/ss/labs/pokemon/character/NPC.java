package ss.labs.pokemon.character;

import ss.labs.pokemon.PokemonData;

/**
 * Created by jerry on 2017/3/7.
 */
public class NPC extends AbstractCharacter {

    //TODO more attributes are needed
    protected  String quote;
    //TODO solve the error
    public NPC(String name,String job,String quote){
        //TODO call super constructor
        super(name,job);
        //TODO assign attribute
        this.quote=quote;
    }

    public void interact()
    {
        speak();
    }

    public void speak(){
        //TODO NPC say something...
        System.out.println(name+": "+quote);
    }

    //TODO override toString()
    @Override
    public String toString()
    {
        return "name: "+name+"\n"+"job: "+job+"\n";
    }
    @Override
    public void showInformation()
    {
        System.out.println(toString());
    }

    public String  getName()
    {
        return name;
    }

    public String getJob()
    {
        return job;
    }

}
