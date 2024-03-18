public class Action {
    private String name;
    private int dmg;
    private String action;
    Action(String name, int dmg, String action) {
        this.name = name;
        this.dmg = dmg;
        this.action = action;
    }

    int doAttack(String user) {
        System.out.println(String.format("\n%s uses %s %s.. ",user, this.name, this.action));
        return dmg;
    }

    @Override
    public String toString() {
        return String.format("%s that does %d", this.name, this.dmg);
    }
}
