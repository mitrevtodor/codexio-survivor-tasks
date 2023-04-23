package task6;

public class SalesConsultant extends WorkerSkeleton{
    private double earnedMoney;

    public SalesConsultant() {
        super();
    }

    public void sellProduct(double price) {
        this.earnedMoney += Math.max(price, 0);
    }

    @Override
    public double getMoney() {
        return this.earnedMoney;
    }
}
