package ss.labs.pokemon.character;



import java.util.List;

/**
 * Created by jerry on 2017/3/7.
 * AbstractCharacter is an abstract class
 * why???
 */
public abstract class AbstractCharacter {
    //give attribute to character
    protected String name;
    protected String job;

    public AbstractCharacter(String name, String job)
    {
        this.name = name;
        this.job = job;

    }

    public abstract void showInformation();

    //Why do we need do use override here? if you don't know then find the answer
    //another way to concat variables into String: String.format("%d %s",1,"test");
    @Override
    public String toString() {

        return name+" "+job+"\n";
    }
}

