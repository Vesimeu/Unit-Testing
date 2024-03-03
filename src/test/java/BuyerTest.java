import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;


public class BuyerTest {

    @Test(groups = {"unit"})
    public void testBuyItem() {
        // Arrange
        Buyer buyer = new Buyer(1000);
        Weapon weapon = new Weapon("Пистолет", 200);

        // Act
        buyer.buyItem(weapon, 200);

        // Assert
        Assert.assertEquals(buyer.getMoney(), 800.0); // Check if buyer spent money
        Assert.assertTrue(buyer.getInventory().contains(weapon)); // Check if weapon was added to inventory
    }

    @Test(groups = {"unit"})
    public void testDisplayInventory() {
        Buyer buyer = new Buyer(500);
        Weapon pistol = new Weapon("Пистолет", 200);
        Weapon rifle = new Weapon("Винтовка", 500);
        buyer.buyItem(pistol, pistol.getPrice());
        buyer.buyItem(rifle, rifle.getPrice());

        List<Weapon> inventory = buyer.displayInventory();
        System.out.println(inventory);
        Assert.assertTrue(inventory.contains(pistol));
        Assert.assertTrue(!inventory.contains(rifle));
    }
}
