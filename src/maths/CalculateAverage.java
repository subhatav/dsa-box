package maths;

// Approach Link: https://stackoverflow.com/questions/1930454/what-is-a-good-solution-for-calculating-an-average-where-the-sum-of-all-values-e

public class CalculateAverage {

    public double compute(int[] numbers) {

        double mean = 0, count = 0;

        for (int number : numbers) {

            mean += (number - mean) / (count += 1);
        }

        return mean;
    }
}
