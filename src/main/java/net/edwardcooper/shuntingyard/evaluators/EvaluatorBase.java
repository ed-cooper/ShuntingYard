package net.edwardcooper.shuntingyard.evaluators;

import java.util.ArrayList;
import java.util.List;

public abstract class EvaluatorBase implements Evaluator {
    /**
     * Gets the cartesian product of 2 lists.
     * @param set1              The first set of values.
     * @param set2              The second set of values.
     * @return                  The cartesian product of 2 lists.
     */
    protected List<Double[]> cartesian(List<Double> set1, List<Double> set2) {
        // Create output
        ArrayList<Double[]> output = new ArrayList<>();

        // For each item from set 1
        for (double n : set1) {
            // For each item from set 2
            for (double m : set2) {
                // Add pair
                output.add(new Double[] {m, n});
            }
        }

        return output;
    }
}
