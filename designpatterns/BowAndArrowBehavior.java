package designpatterns;

/**
 *
 * @author iris
 */
public class BowAndArrowBehavior implements WeaponBehavior{
    @Override
    public void useWeapon() {
        System.out.println("Thwaack...Thud!");
    }
}
