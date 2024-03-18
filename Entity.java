import java.util.ArrayList;

public abstract class Entity {
    protected String name;
    protected ArrayList<Action> actions = new ArrayList<>();
    protected int health = 0;
    protected Boolean isDead = false;

    Entity(String name, int health) {
        this.name = name;
        this.health = health;
    }
    
    public boolean damage(int totalDamage) {
        health -= totalDamage;
        if(health <= 0) {
            death();
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public abstract boolean death();
    public boolean isDead() {
        return isDead;
    }
    
    
    public void addAction(Action at) {
        actions.add(at);
    }
    public void removeAction(int index) {
        actions.remove(index);
    }

    public int useAttack(int index) {
        if(index >= actions.size()) return -1;
        return actions.get(index).doAttack(this.name);
    }
}
