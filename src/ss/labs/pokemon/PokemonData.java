package ss.labs.pokemon;

/**
 * Created by jerry on 2017/3/7.
 */
public class PokemonData{
    public PokemonData(int id,String name,String type,String move,int maxHP,int currentHP,int speed,int attack){
        this.id = id;
        this.name = name;
        this.type = type;
        this.move = move;
        this.maxHP= maxHP;
        this.currentHP=currentHP;
        this.speed=speed;
        this.attack=attack;
    }

    private int id;
    private String name;
    private String type;
    private String move;
    private int maxHP;
    private int currentHP;
    private int speed;
    private int attack;

    //calculate damage
    public void damage(int dmg)
    {
        if(currentHP-dmg>0)
            currentHP=currentHP-dmg;
        else currentHP=0;
    }

    public void speedUp()
    {
        speed=speed+2;
    }

    public void attackUp()
    {
        attack=attack+5;
    }

    public void healing()
    {
        currentHP=maxHP;
    }

    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getType()
    {
        return type;
    }
    public String getMove()
    {
        return move;
    }
    public int getMaxHP()
    {
        return maxHP;
    }
    public int getCurrentHP()
    {
        return currentHP;
    }
    public int getSpeed()
    {
        return speed;
    }
    public int getAttack()
    {
        return attack;
    }

}
