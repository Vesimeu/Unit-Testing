import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Buyer implements InventoryItem {
    private double money;
    private List<Weapon> inventory;

    public Buyer(double money) {
        this.money = money;
        this.inventory = new ArrayList<>();
    }

    @Override
    public void buyItem(Weapon weapon, double price) {
        if (money >= price) {
            inventory.add(weapon);
            money -= price;
            System.out.println("Оружие " + weapon.getWeaponName() + " куплено за " + price + ".");
        } else {
            System.out.println("У покупателя недостаточно денег для покупки.");
        }
    }

    @Override
    public void sellItem(Weapon weapon, double money) {
        // Покупатель не должен продавать оружие
        System.out.println("Покупатель не может продавать оружие.");
    }

    @Override
    public List<Weapon> displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Инвентарь покупателя пуст");
            return Collections.emptyList(); // Возвращаем пустой список
        }
        System.out.println("Инвентарь покупателя:");
        for (Weapon weapon : inventory) {
            System.out.println(weapon.getWeaponName() + " - Цена: " + weapon.getPrice());
        }
        return inventory;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public List<Weapon> getInventory() {
        return inventory;
    }
}
