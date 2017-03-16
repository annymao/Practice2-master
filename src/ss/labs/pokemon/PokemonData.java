package ss.labs.pokemon;

import java.util.Scanner;

/**
 * Created by jerry on 2017/3/7.
 */
public class PokemonData {
    public PokemonData(int id, String name, String type, String move, int maxHP, int currentHP, int speed, int attack) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.move = move;
        this.maxHP = maxHP;
        this.currentHP = currentHP;
        this.speed = speed;
        this.attack = attack;
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
    public void damage(int dmg) {
        if (currentHP - dmg > 0)
            currentHP = currentHP - dmg;
        else currentHP = 0;
    }

    public void speedUp() {
        speed = speed + 2;
    }

    public void attackUp() {
        attack = attack + 5;
    }

    //the battle between two pokemon
    public int fight(PokemonData trainer) {
        int win = 0;
        Scanner scanner = new Scanner(System.in);
        while (trainer.getCurrentHP() > 0 && getCurrentHP() > 0) {
            if (trainer.getSpeed() >= getSpeed()) {
                System.out.printf("%s use %s\n", trainer.getName(), trainer.getMove());
                damage(trainer.getAttack());
                System.out.printf("%s receive %d damage\n", getName(), trainer.getAttack());
                if (getCurrentHP() > 0) {
                    System.out.printf("%s has %d HP left.\n", getName(), getCurrentHP());
                } else {
                    System.out.printf("%s fainted.\n", getName());
                    trainer.attackUp();
                    trainer.speedUp();
                    healing();
                    win = 1;
                    break;
                }
                scanner.nextLine();
                System.out.printf("%s use %s\n", getName(), getMove());
                trainer.damage(getAttack());
                System.out.printf("%s receive %d damage\n", trainer.getName(), getAttack());
                if (trainer.getCurrentHP() > 0) {
                    System.out.printf("%s has %d HP left.\n", trainer.getName(), trainer.getCurrentHP());
                    scanner.nextLine();
                } else {
                    System.out.printf("%s fainted.\n", trainer.getName());
                    healing();
                    win = 0;
                    break;
                }
            } else {
                System.out.printf("%s use %s\n", getName(), getMove());
                trainer.damage(getAttack());
                System.out.printf("%s receive %d damage\n", trainer.getName(), getAttack());
                if (trainer.getCurrentHP() > 0) {
                    System.out.printf("%s has %d HP left.\n", trainer.getName(), trainer.getCurrentHP());

                } else {
                    System.out.printf("%s fainted.\n", trainer.getName());
                    healing();
                    win = 0;
                    break;
                }
                scanner.nextLine();
                System.out.printf("%s use %s\n", trainer.getName(), trainer.getMove());
                damage(trainer.getAttack());
                System.out.printf("%s receive %d damage\n", getName(), trainer.getAttack());
                if (getCurrentHP() > 0) {
                    System.out.printf("%s has %d HP left.\n", getName(), getCurrentHP());
                    scanner.nextLine();
                } else {
                    System.out.printf("%s fainted.\n", getName());
                    trainer.attackUp();
                    trainer.speedUp();
                    healing();
                    win = 1;
                    break;
                }
            }
        }
        return win;
    }

    //recover
    public void healing() {
        currentHP = maxHP;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getMove() {
        return move;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getSpeed() {
        return speed;
    }

    public int getAttack() {
        return attack;
    }

}
