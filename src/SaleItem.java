public class SaleItem extends Item {
    private double discount;

    public SaleItem(String nm, double lc, User owner, double disc) {
        super(nm,lc,owner, true);
        discount = disc;
    }

    public String getDiscount() {
        return "" + discount * 100 + "%";
    }

    public void purchaseItem(User ow) {
        System.out.println("calling purchase Item..");
        double lc = listCost - (listCost * discount);
        owner = ow;
        ow.updateBalance(ow.getAccountBalance() - lc);
        toggleForSale();
    }

    public String toString() {
        if(forSale) {
            return name + "($ " + listCost + ", " + owner.getName() + ") ";
        }
        else
            return name + "($ " + listCost + ", " + owner.getName() + ") - Sold";
    }
}
