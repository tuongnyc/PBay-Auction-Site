import java.text.DecimalFormat;

public class AuctionItem extends Item {
    private int daysLeft;
    private double currentBid;
    private User highBidder;

    public AuctionItem(String nm, double lc, User ow, int numDays) {
        super(nm, lc, ow, true);
        currentBid = lc;
        highBidder = null;
        daysLeft = numDays;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public double getCurrentBid() {
        return currentBid;
    }

    public void advanceDay() {
        if(forSale == true && daysLeft <= 0 && highBidder != null) {
            toggleForSale();
            owner.updateBalance(owner.getAccountBalance() + currentBid);
            highBidder.updateBalance(highBidder.getAccountBalance() - currentBid);
            owner = highBidder;
        }
        else if(forSale == true && daysLeft > 0 && highBidder != null) {
            owner.updateBalance(owner.getAccountBalance() + currentBid);
            highBidder.updateBalance(highBidder.getAccountBalance() - currentBid);
            owner = highBidder;
            daysLeft--;
        }
        else if(forSale == true && daysLeft > 0 && highBidder == null) {
            daysLeft--;
        }
    }

    public String makeBid(User us, double bid) {
        if(forSale == true && bid > currentBid) {
            currentBid = bid;
            highBidder = us;
            return us.getName();
        }
        if(forSale == true && bid <= currentBid) {
            return owner.getName();
        }
        else {
            return highBidder.getName();
        }
    }

    public void resetAuction(double startingBid, int numDays){
        currentBid = startingBid;
        daysLeft = numDays;
    }

    public String toString() {
        DecimalFormat f = new DecimalFormat(".00");
        if(forSale && highBidder != null) {
            return name + "($ " + f.format(currentBid) + ", " + highBidder.getName() + ", " + daysLeft + " days left)";
        }
        return name + "($ " + f.format(listCost) + ", None," + daysLeft + " days left)";
    }
}
