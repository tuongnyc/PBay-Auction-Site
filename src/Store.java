import java.util.ArrayList;
import java.util.List;

public class Store {
    public ArrayList<SaleItem> saleItems;
    public ArrayList<AuctionItem> auctionItems;

    public static String printItems(List myList) {
        String s = "Available items:\n";
        for (Object i : myList) {
            s += i + "\n";
        }
        return s;
    }

    public static void advanceDay(ArrayList<AuctionItem> myList) {
        for (AuctionItem ai : myList) {
            ai.advanceDay();
        }
    }

    public static void main(String[] args) {
        Store myStore = new Store();
        myStore.saleItems = new ArrayList<SaleItem>();
        myStore.auctionItems = new ArrayList<AuctionItem>();


        User u1 = new User("Anna");
        User u2 = new User("Blake");
        User u3 = new User("Caitlyn");
        User u4 = new User("Dad");

        myStore.saleItems.add(new SaleItem("Super fun stick", 2.50, u4, 0.1));
        myStore.saleItems.add(new SaleItem("Volleyball", 22.49, u2, 0.2));
        myStore.saleItems.add(new SaleItem("10,000-piece puzzle", 100.00, u3, 0.25));

        myStore.auctionItems.add(new AuctionItem("Programming textbook", 10.00, u1, 10));
        myStore.auctionItems.add(new AuctionItem("Cat pajamas", 8.25, u2, 8));
        myStore.auctionItems.add(new AuctionItem("Bottlecap collection", 25.00, u3, 5));
        myStore.auctionItems.add(new AuctionItem("Cup of joe", 1.99, u4, 5));

        System.out.println(printItems(myStore.saleItems));

        System.out.println(printItems(myStore.auctionItems));

        advanceDay(myStore.auctionItems);


        myStore.auctionItems.get(0).makeBid(u2,11.00);
        myStore.auctionItems.get(0).makeBid(u3,11.00);
        myStore.auctionItems.get(1).makeBid(u1, 12.00);
        myStore.auctionItems.get(2).makeBid(u2, 25.00);

        System.out.println(printItems(myStore.auctionItems));

        advanceDay(myStore.auctionItems);

        System.out.println(printItems(myStore.auctionItems));

        myStore.saleItems.get(0).purchaseItem(u1);

        System.out.println(printItems(myStore.saleItems));
        System.out.println(printItems(myStore.auctionItems));

    }
}