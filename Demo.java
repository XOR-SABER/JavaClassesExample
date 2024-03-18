import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Player p1 = new Player(100, "Lorenzo", new Action("Sword Slash", 25, "slashes"));
        p1.addAction(new Action("Fireball", 30, "exploads"));
        Enemy e1 = new Enemy("Annoying Rat", 60, 130, 1, new Action("bite", 50, "Just bit"));
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.println(p1);
            System.out.println(e1); 
            e1.damage(p1.selectAttack(scan));
            if(e1.isDead()) break;
            p1.damage(e1.useAttack(0));
            if(p1.isDead()) break;
        }
        scan.close();
    }
}