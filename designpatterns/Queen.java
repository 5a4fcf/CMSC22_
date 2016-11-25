package designpatterns;

/**
 *
 * @author iris
 */
public class Queen extends Character{
    public Queen(){
        super(new BowAndArrowBehavior());
    }
    @Override
    public void setWeapon(WeaponBehavior w) {
        super.setWeapon(w); 
    }
}
