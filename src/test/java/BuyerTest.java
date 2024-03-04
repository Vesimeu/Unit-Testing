import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class BuyerTest {
    private static final double DELTA = 1e-4;

    @Test(groups = {"unit"})
    public void testBuyItem() {
        // Arrange
        final double EXPECTED_MONEY = 800.0;
        Buyer buyer = new Buyer(1000);
        Weapon weapon = new Weapon("Пистолет", 200);

        // Act
        buyer.buyItem(weapon, 200);

        // Assert
        Assert.assertEquals(buyer.getMoney(), EXPECTED_MONEY , DELTA); // Check if buyer spent money
        Assert.assertTrue(buyer.getInventory().contains(weapon)); // Check if weapon was added to inventory
    }

//!
    @Test(groups = {"unit"})
    public void testDisplayInventory() {
        // Arrange
        Buyer buyer = new Buyer(500);
        Weapon pistol = new Weapon("Пистолет", 200);
        Weapon rifle = new Weapon("Винтовка", 500);
        buyer.buyItem(pistol, pistol.getPrice());
        buyer.buyItem(rifle, rifle.getPrice());

        // Redirect System.out to ByteArrayOutputStream
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act
        List<Weapon> inventory = buyer.displayInventory();

        // Assert
        Assert.assertTrue(inventory.contains(pistol));
        Assert.assertFalse(inventory.contains(rifle)); // Поскольку ружье отсутствует в инвентаре покупателя


        //Способ 1 
        // Assert.assertEquals(outContent.toString().trim() , "Инвентарь покупателя:\nПистолет - Цена: 200.0".trim());


        //Способ 2
        // String expectedOutput = "Инвентарь покупателя:\nПистолет - Цена: 200.0";
        // String actualOutput = outContent.toString().trim();
        // Assert.assertEquals(actualOutput, expectedOutput);

        //Способ 3
        String expectedOutput1 = "Инвентарь покупателя:";
        String expectedOutput2 = "Пистолет - Цена: 200.0";
        String actualOutput = outContent.toString().trim(); // Убираем лишние символы в конце и начале строки
        Assert.assertTrue(actualOutput.contains(expectedOutput1));
        Assert.assertTrue(actualOutput.contains(expectedOutput2));

    }

    @Test(groups = {"unit"})    
    public void testBuyItemWithEnoughMoney() {
        // Arrange
        final double EXPECTED_MONEY = 800.0;
        Buyer buyer = new Buyer(1000);
        Weapon pistol = new Weapon("Пистолет", 200);

        // Act
        buyer.buyItem(pistol, pistol.getPrice());

        // Assert
        List<Weapon> inventory = buyer.getInventory();
        Assert.assertTrue(inventory.contains(pistol));
        Assert.assertEquals(buyer.getMoney(), EXPECTED_MONEY , DELTA);
    }

    @Test(groups = {"unit"})
    public void testBuyItemWithoutEnoughMoney() {
        // Arrange
        final double EXPECTED_MONEY = 100.0;
        Buyer buyer = new Buyer(100);
        Weapon pistol = new Weapon("Пистолет", 200);

        // Act
        buyer.buyItem(pistol, pistol.getPrice());

        // Assert
        List<Weapon> inventory = buyer.getInventory();
        Assert.assertFalse(inventory.contains(pistol));
        Assert.assertEquals(buyer.getMoney(), EXPECTED_MONEY, DELTA); // Проверяем, что деньги не изменились
    }


}
