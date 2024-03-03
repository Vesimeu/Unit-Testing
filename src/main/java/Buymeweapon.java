public class Buymeweapon {
    public static void main(String[] args) {
        Seller seller = new Seller(1000); // Продавец с 1000 денег
        Buyer buyer = new Buyer(500); // Покупатель с 500 денег

        Weapon pistol = new Weapon("Пистолет", 200);
        Weapon rifle = new Weapon("Винтовка", 500);

        seller.addWeaponToArsenal(pistol);
        seller.addWeaponToArsenal(rifle);

        System.out.println("Информация о продавце:");
        System.out.println(seller.displayInventory());
        System.out.println("Информация о покупателе:");
        System.out.println(buyer.displayInventory());

        buyer.buyItem(pistol, pistol.getPrice());
        seller.sellItem(pistol, pistol.getPrice());

        System.out.println("Информация о продавце после продажи:");
        System.out.println(seller.displayInventory());
        System.out.println("Информация о покупателе после покупки:");
        System.out.println(buyer.displayInventory());
    }
}
