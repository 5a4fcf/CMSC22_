package designpatterns;

/**
 *
 * @author iris
 */
public class Knight extends Character{
    public Knight(){
        super(new SwordBehavior());
    }
    @Override
    public void setWeapon(WeaponBehavior w) {
        super.setWeapon(w); 
    }
}
