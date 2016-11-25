package designpatterns;

/**
 *
 * @author iris
 */
public class Troll extends Character {
    public Troll(){
        super(new AxeBehavior());
    }
    @Override
    public void setWeapon(WeaponBehavior w) {
        super.setWeapon(w); 
    }
}
