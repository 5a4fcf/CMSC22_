package designpatterns;

/**
 *
 * @author iris
 */
public class KnifeBehavior implements WeaponBehavior{
    @Override
    public void useWeapon() {
        System.out.println("Whook!");
    }
}
