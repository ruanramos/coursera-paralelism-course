package java.edu.coursera.parallel;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

;

public class ASum extends RecursiveAction {

    private final int lowerBound, higherBound;
    private final int[] values;
    private int sum;

    public ASum(int lowerBound, int higherBound, int[] values) {
        this.lowerBound = lowerBound;
        this.higherBound = higherBound;
        this.values = values;
    }


    @Override
    protected void compute() {
        sum = 0;
        for (int i = lowerBound; i < higherBound; i++) {
            sum += values[i];
        }
        int middle = (lowerBound + higherBound) / 2;
        ForkJoinTask.invokeAll(new ASum(lowerBound, middle, values), new ASum(middle, higherBound, values));
    }
}
