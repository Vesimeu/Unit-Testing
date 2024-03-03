import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.ArrayList;

public class BuyerTest {

    @Test
    public void testBuyItem() {
        // Arrange
        Buyer buyer = new Buyer(500);
        Weapon weapon = new Weapon("Пистолет", 200);
        double initialMoney = buyer.getMoney();
        double expectedMoney = initialMoney - weapon.getPrice();

        // Act
        buyer.buyItem(weapon, weapon.getPrice());

        // Assert
        Assert.assertEquals(buyer.getInventory().size(), 1);
        Assert.assertEquals(buyer.getMoney(), expectedMoney);
    }

    @Test
    public void testDisplayInventory() {
        // Arrange
        Buyer buyer = new Buyer(500);
        Weapon weapon = new Weapon("Пистолет", 200);
        buyer.buyItem(weapon, weapon.getPrice());

        // Act
        buyer.displayInventory();
        // Since this method only prints output, we cannot assert its behavior programmatically.
    }
}
