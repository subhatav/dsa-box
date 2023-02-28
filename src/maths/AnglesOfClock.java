package maths;

// Problem Link: https://leetcode.com/problems/angle-between-hands-of-a-clock/
// Solution Link: https://leetcode.com/problems/angle-between-hands-of-a-clock/solutions/502738/java-python-c-simple-math-on-clock-angles/

// Approach: Find ABSOLUTE Difference b/w ANGLES formed by the HOUR & MINUTE Areas

public class AnglesOfClock {

    public double compute(int hour, int minutes) {

        // Degree(s) taken by the Hour HAND for:
        // EACH Hour == (360 Degrees / 12 Hours) &
        // EACH Minute == (30 Degrees / 60 Minutes)
        double hourArea = (hour % 12) * 30;
        double minutesArea = minutes * 0.5;

        // Degree(s) taken by the Minute HAND for:
        // EACH Minute == (360 Degrees / 60 Minutes)
        double minuteHand = minutes * 6;
        double hourHand = hourArea + minutesArea;

        double angle = Math.abs(minuteHand - hourHand);

        // Convert the Obtuse Angle [if] to Acute Angle
        return (angle <= 180) ? angle : (360.0 - angle);
    }
}