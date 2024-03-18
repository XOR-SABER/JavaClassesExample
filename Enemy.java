public class Enemy extends Entity implements ExpDrop {
    private int ExpAmt = 0;
    private int level = 1;

    Enemy(String name, int health, int ExpAmt, int level, Action act) {
        super(name, health);
        this.ExpAmt = ExpAmt;
        this.level = level;
        addAction(act);
    }

    @Override
    public boolean death() {
        this.isDead = true;
        System.out.println(String.format("%s is dead.", this.name));
        return true;
    }

    @Override
    public double expDrop() {
        return ExpAmt * Math.log1p(level);
    }

    
    @Override
    public String toString() {
        return String.format("\"%s\" Health: %d : Level %d", name, health, level);
    }
}
