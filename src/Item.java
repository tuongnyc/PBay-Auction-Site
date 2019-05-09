public class Item {
    protected String name;
    protected double listCost;
    protected User owner;
    protected boolean forSale;

    public Item(String nm, double lc, User ow, boolean fs) {
        name = nm;
        listCost = Math.round(lc * 100.0) / 100.0;  // round to two decimal places.
        owner = ow;
        forSale = fs;
    }

    public String getName() {
        return name;
    }

    public double getListCost() {
        return listCost;
    }

    public User getOwner() {
        return owner;
    }

    public boolean getForSale() {
        return forSale;
    }

    public void setOwner(User ow) {
        owner = ow;
    }

    public void setListCost(double lc) {
        listCost = lc;
    }

    public void toggleForSale() {
        if(forSale == true)
            forSale = false;
        else
            forSale = true;
    }

    public void purchaseItem(User ow, double bal) {
        User newowner = ow;
        newowner.updateBalance(bal);
        owner = newowner;
        toggleForSale();
    }

    public String toString() {
        return name + "($" + listCost + " - " + owner.getName() + " )";
    }
}
