package designpatterns;

/**
 *
 * @author iris
 */
public class Character {
    WeaponBehavior weapon;
    
    public Character(WeaponBehavior w){
        this.weapon = w;
    }
    
    public void fight(){
        weapon.useWeapon();
    }
    
    public void setWeapon(WeaponBehavior w){
        this.weapon = w;
    }
    
}
