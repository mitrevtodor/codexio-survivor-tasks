package task6;

public class MarketingSpecialist extends WorkerSkeleton{
    private double budget;

    public MarketingSpecialist() {
        super();
        this.budget = 5000.00;
    }

    public void spendMoney(double marketingCampaignCost) {
        this.budget -= Math.max(marketingCampaignCost, 0);
    }

    @Override
    public double getMoney() {
        return this.budget;
    }
}
