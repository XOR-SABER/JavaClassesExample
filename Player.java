
import java.util.Random;
import java.util.Scanner;

public class Player extends Entity {
    private Random rand; 
    private int currentExp = 0; 
    private int level = 1; 
    Player(int health, String name, Action attack) {
        super(name, health);
        this.currentExp = 0;
        this.level = 1;
        addAction(attack);
        long seed = System.currentTimeMillis();
        rand = new Random(seed);
    }

    public void addExp(int amount) {
        int nextLevel = (int)(Math.log1p(this.level + 1) * 1000) + 100;
        currentExp += amount;
        if(!(currentExp >= nextLevel)) return;
        this.level++;
        System.out.println(String.format("%s has leveled up to %d!", this.name, this.level));
        currentExp %= nextLevel;
    }

    public int selectAttack(Scanner scan) {
        System.out.println(String.format("\nSelect a attack for %s", this.name));
        int i = 0;
        for (Action action : actions) {
            System.out.println(String.format("%d: %s", i, action.toString()));
            i++;
        }
        int nextAttack, attackDMG;
        do{
            nextAttack = scan.nextInt();
            attackDMG = this.useAttack(nextAttack);
        }while(attackDMG == -1);
        return attackDMG;
    }

    
    
    @Override
    public boolean death() {
        // lol Nice try.. I have plot armor.
        if(rand.nextDouble() < 0.25) {
            System.out.println(String.format("%s has survied his injuries!! +100 Health!", this.name));
            health += 100;
            return false;
        }
        this.isDead = true;
        System.out.println(String.format("%s has fainted.. He is dead.", this.name));
        return true;
    }
    
    @Override
    public String toString() {
        return String.format("\"%s\" Health: %d : Level %d : current Exp Total %d : Next level in %dXP" , name, health, level, currentExp, (int)(Math.log1p(this.level + 1) * 1000) + 100);
    }
}
