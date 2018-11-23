package net.edwardcooper.shuntingyard.evaluators;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class EvaluatorBaseTest {

    @Test
    public void testCartesian_3_3() {
        EvaluatorBase evaluator = new DefaultEvaluator();
        List<Double> set1 = Arrays.asList(1d, 2d, 3d);
        List<Double> set2 = Arrays.asList(4d, 5d, 6d);
        List<Double[]> expected = new ArrayList<>();

        expected.add(new Double[] {1d, 4d});
        expected.add(new Double[] {1d, 5d});
        expected.add(new Double[] {1d, 6d});

        expected.add(new Double[] {2d, 4d});
        expected.add(new Double[] {2d, 5d});
        expected.add(new Double[] {2d, 6d});

        expected.add(new Double[] {3d, 4d});
        expected.add(new Double[] {3d, 5d});
        expected.add(new Double[] {3d, 6d});

        List<Double[]> actual = evaluator.cartesian(set1, set2);

        assertCartesianResult(expected, actual);
    }

    @Test
    public void testCartesian_3_2() {
        EvaluatorBase evaluator = new DefaultEvaluator();
        List<Double> set1 = Arrays.asList(1d, 2d, 3d);
        List<Double> set2 = Arrays.asList(4d, 5d);
        List<Double[]> expected = new ArrayList<>();

        expected.add(new Double[] {1d, 4d});
        expected.add(new Double[] {1d, 5d});

        expected.add(new Double[] {2d, 4d});
        expected.add(new Double[] {2d, 5d});

        expected.add(new Double[] {3d, 4d});
        expected.add(new Double[] {3d, 5d});

        List<Double[]> actual = evaluator.cartesian(set1, set2);

        assertCartesianResult(expected, actual);
    }

    @Test
    public void testCartesian_2_3() {
        EvaluatorBase evaluator = new DefaultEvaluator();
        List<Double> set1 = Arrays.asList(1d, 2d);
        List<Double> set2 = Arrays.asList(4d, 5d, 6d);
        List<Double[]> expected = new ArrayList<>();

        expected.add(new Double[] {1d, 4d});
        expected.add(new Double[] {1d, 5d});
        expected.add(new Double[] {1d, 6d});

        expected.add(new Double[] {2d, 4d});
        expected.add(new Double[] {2d, 5d});
        expected.add(new Double[] {2d, 6d});

        List<Double[]> actual = evaluator.cartesian(set1, set2);

        assertCartesianResult(expected, actual);
    }

    private void assertCartesianResult(List<Double[]> expected, List<Double[]> actual) {
        // Lists must be same size
        if (expected.size() != actual.size()) {
            Assert.fail();
            return;
        }

        // Test that the expected list contains every element in the actual list
        for (Double[] pair1 : actual) {
            boolean found = false;

            for (Double[] pair2 : expected) {
                if (pair1[0].equals(pair2[0]) && pair1[1].equals(pair2[1])) {
                    found = true;
                }
            }

            Assert.assertTrue(found);
        }
    }
}