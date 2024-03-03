import java.util.List;


public interface InventoryItem {
    void buyItem(Weapon weapon, double money);
    void sellItem(Weapon weapon, double money);
    List<Weapon> displayInventory();
}
