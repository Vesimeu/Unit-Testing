import java.util.ArrayList;
import java.util.List;

public class Seller implements InventoryItem {
    private double money;
    private List<Weapon> arsenal;

    public Seller(double money) {
        this.money = money;
        this.arsenal = new ArrayList<>();
    }

    @Override
    public void buyItem(Weapon weapon, double money) {
        // Продавец не должен покупать оружие
        System.out.println("Продавец не может покупать оружие.");
    }

    @Override
    public void sellItem(Weapon weapon, double price) {
        if (arsenal.contains(weapon)) {
            if (money >= price) {
                arsenal.remove(weapon);
                money += price;
                System.out.println("Оружие " + weapon.getWeaponName() + " продано за " + price + ".");
            } else {
                System.out.println("У продавца недостаточно денег для продажи.");
            }
        } else {
            System.out.println("Продавец не имеет этого оружия.");
        }
    }

    @Override
    public void displayInventory() {
        if (arsenal.isEmpty()) {
            System.out.println("Инвентарь пуст");
        } else {
            System.out.println("Инвентарь продавца:");
            for (Weapon weapon : arsenal) {
                System.out.println(weapon.getWeaponName() + " - Цена: " + weapon.getPrice());
            }
        }
    }

    public void addWeaponToArsenal(Weapon weapon) {
        arsenal.add(weapon);
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
    
    public List<Weapon> getArsenal() {
        return arsenal;
    }
}
