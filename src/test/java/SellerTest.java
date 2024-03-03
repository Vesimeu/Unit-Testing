import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.ArrayList;

public class SellerTest {

    @Test
    public void testAddWeaponToArsenal() {
        // Arrange
        Seller seller = new Seller(1000);
        Weapon weapon = new Weapon("Пистолет", 200);

        // Act
        seller.addWeaponToArsenal(weapon);
        List<Weapon> arsenal = seller.getArsenal();

        // Assert
        Assert.assertEquals(arsenal.size(), 1);
        Assert.assertEquals(arsenal.get(0), weapon);
    }

    @Test
    public void testSellItem() {
        // Arrange
        Seller seller = new Seller(1000);
        Weapon weapon = new Weapon("Пистолет", 200);
        seller.addWeaponToArsenal(weapon);
        double initialMoney = seller.getMoney();
        double expectedMoney = initialMoney + weapon.getPrice();

        // Act
        seller.sellItem(weapon, weapon.getPrice());

        // Assert
        Assert.assertEquals(seller.getArsenal().size(), 0);
        Assert.assertEquals(seller.getMoney(), expectedMoney);
    }

    @Test
    public void testDisplayInventory() {
        // Arrange
        Seller seller = new Seller(1000);
        Weapon weapon = new Weapon("Пистолет", 200);
        seller.addWeaponToArsenal(weapon);

        // Act
        seller.displayInventory();
        // Since this method only prints output, we cannot assert its behavior programmatically.
    }
}
