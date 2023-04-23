package task6;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private static final Shop instance = new Shop();
    private List<Worker> workers = new ArrayList<>();
    private Shop() {}

    public static Shop getInstance() {
        return instance;
    }

    public void addWorker(Worker worker) {
        this.workers.add(worker);
    }

    public double getTurnOver() {
        return calculateTurnover();
    }

    private double calculateTurnover() {
        double turnOver = 0.0;
        for (Worker worker: this.workers) {
            turnOver+=worker.getMoney();
        }

        return turnOver;
    }
}
