import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.ArrayList;

public class WeaponInventoryTest {
    private static final double DELTA = 1e-4;


    @Test
    public void testSellerSellItem() {
        //ARANGE
        final double EXCPECTED_MONEY = 1200.0;
        Seller seller = new Seller(1000);
        Weapon pistol = new Weapon("Пистолет", 200);
        Weapon rifle = new Weapon("Винтовка", 500);
        List<Weapon> expectedInventory = new ArrayList<>();
        seller.addWeaponToArsenal(pistol);
        seller.addWeaponToArsenal(rifle);
        expectedInventory.add(rifle);

        //ACT
        seller.sellItem(pistol, pistol.getPrice());

        //ASSERT
        Assert.assertEquals(seller.getArsenal(), expectedInventory);
        Assert.assertEquals(seller.getMoney(), EXCPECTED_MONEY, DELTA);
    }

    @Test
    public void testBuyerBuyItem() {
        //ARANGE
        final double EXPECTED_MONEY = 300.0;
        Buyer buyer = new Buyer(500);
        Weapon pistol = new Weapon("Пистолет", 200);
        buyer.buyItem(pistol, pistol.getPrice());
        List<Weapon> expectedInventory = new ArrayList<>();

        //ACT
        expectedInventory.add(pistol);

        //ASSERT
        Assert.assertEquals(buyer.getInventory(), expectedInventory);
        Assert.assertEquals(buyer.getMoney(), EXPECTED_MONEY, DELTA);
    }

    @Test
    public void testSellerCannotBuyItem() {
        //ARANGE
        final double EXPECTED_MONEY = 1000.0;
        Seller seller = new Seller(1000);
        Weapon pistol = new Weapon("Пистолет", 200);

        //ACT
        seller.buyItem(pistol, pistol.getPrice());
        List<Weapon> expectedInventory = new ArrayList<>();

        //ASSERT
        Assert.assertEquals(seller.getArsenal(), expectedInventory);
        Assert.assertEquals(seller.getMoney(), EXPECTED_MONEY, DELTA);
    }

    @Test
    public void testBuyerCannotSellItem() {
        //ARANGE
        final double EXPECTED_MONEY = 500.0;
        Buyer buyer = new Buyer(500);
        Weapon pistol = new Weapon("Пистолет", 200);

        //ACT
        buyer.sellItem(pistol, pistol.getPrice());
        List<Weapon> expectedInventory = new ArrayList<>();

        //ASSERT
        Assert.assertEquals(buyer.getInventory(), expectedInventory);
        Assert.assertEquals(buyer.getMoney(), EXPECTED_MONEY, DELTA);
    }
}
