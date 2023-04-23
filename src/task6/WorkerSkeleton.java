package task6;

public abstract class WorkerSkeleton implements Worker{
    private Shop workingShop;
    public WorkerSkeleton() {
        this.workingShop = Shop.getInstance();
        this.workingShop.addWorker(this);
    }
}
