public class Weapon {
    private String weaponName;
    private double price;

    public Weapon(String weaponName, double price) {
        this.weaponName = weaponName;
        this.price = price;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
