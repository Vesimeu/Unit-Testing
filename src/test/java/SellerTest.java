import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;



public class SellerTest {

    @Test(groups = {"unit"})
    public void testSellItem() {
        final double EXPECTED_MONEY = 1200.0;
        // Arrange
        Seller seller = new Seller(1000);
        Weapon weapon = new Weapon("Пистолет", 200);
        seller.addWeaponToArsenal(weapon);

        // Act
        seller.sellItem(weapon, 200);

        // Assert
        Assert.assertEquals(seller.getMoney(), EXPECTED_MONEY); // Check if seller received money
        Assert.assertFalse(seller.getArsenal().contains(weapon)); // Check if weapon was removed from arsenal
    }

   @Test(groups = {"unit"})
    public void testInventory() {
        final double EXPECTED_MONEY = 1000.0;
        // Arrange
        Seller seller = new Seller(1000);
        Weapon pistol = new Weapon("Пистолет", 200);
        Weapon rifle = new Weapon("Винтовка", 500);
        seller.addWeaponToArsenal(pistol);
        seller.addWeaponToArsenal(rifle);

        // Act
        List<Weapon> inventory = seller.getArsenal();

        // Assert
        Assert.assertTrue(inventory.contains(pistol));
        Assert.assertTrue(inventory.contains(rifle));
        Assert.assertEquals(seller.getMoney(), EXPECTED_MONEY); // Check if seller's money is unchanged
    }
}
