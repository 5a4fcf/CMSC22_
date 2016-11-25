package designpatterns;

/**
 *
 * @author iris
 */
public class CharacterTest {
    public static void main(String args[]){
        Character q = new Queen();
        //q.setWeapon(new KnifeBehavior());
        q.fight();
        Character k = new King();
        k.setWeapon(new KnifeBehavior());
        k.fight();
        Character t = new Troll();
        t.setWeapon(new AxeBehavior());
        t.fight();
        Character kn = new Knight();
        kn.setWeapon(new SwordBehavior());
        kn.fight();
    }
}
