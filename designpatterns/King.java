package designpatterns;

/**
 *
 * @author iris
 */
public class King extends Character{
    public King(){
        super(new KnifeBehavior());
    }
    @Override
    public void setWeapon(WeaponBehavior w) {
        super.setWeapon(w); 
    }
}
