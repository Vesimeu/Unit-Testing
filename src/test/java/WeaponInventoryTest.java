import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.ArrayList;

public class WeaponInventoryTest {

    @Test
    public void testSellerSellItem() {
        Seller seller = new Seller(1000);
        Weapon pistol = new Weapon("Пистолет", 200);
        Weapon rifle = new Weapon("Винтовка", 500);
        seller.addWeaponToArsenal(pistol);
        seller.addWeaponToArsenal(rifle);

        seller.sellItem(pistol, pistol.getPrice());
        List<Weapon> expectedInventory = new ArrayList<>();
        expectedInventory.add(rifle);
        Assert.assertEquals(seller.getArsenal(), expectedInventory);
        Assert.assertEquals(seller.getMoney(), 1200.0);
    }

    @Test
    public void testBuyerBuyItem() {
        Buyer buyer = new Buyer(500);
        Weapon pistol = new Weapon("Пистолет", 200);

        buyer.buyItem(pistol, pistol.getPrice());
        List<Weapon> expectedInventory = new ArrayList<>();
        expectedInventory.add(pistol);
        Assert.assertEquals(buyer.getInventory(), expectedInventory);
        Assert.assertEquals(buyer.getMoney(), 300.0);
    }

    @Test
    public void testSellerCannotBuyItem() {
        Seller seller = new Seller(1000);
        Weapon pistol = new Weapon("Пистолет", 200);

        seller.buyItem(pistol, pistol.getPrice());
        List<Weapon> expectedInventory = new ArrayList<>();
        Assert.assertEquals(seller.getArsenal(), expectedInventory);
        Assert.assertEquals(seller.getMoney(), 1000.0);
    }

    @Test
    public void testBuyerCannotSellItem() {
        Buyer buyer = new Buyer(500);
        Weapon pistol = new Weapon("Пистолет", 200);

        buyer.sellItem(pistol, pistol.getPrice());
        List<Weapon> expectedInventory = new ArrayList<>();
        Assert.assertEquals(buyer.getInventory(), expectedInventory);
        Assert.assertEquals(buyer.getMoney(), 500.0);
    }
}
