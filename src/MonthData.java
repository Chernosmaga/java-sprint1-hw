public class MonthData {
    static int[] days = new int[30];

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println("За " + (i + 1) + " день пройдено " + days[i] + " шагов");
        }
    }

    int sumStepsFromMonth() {
        int SumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            SumSteps += days[i];
        }
        return SumSteps;
    }

    int maxSteps() {
        int maxSteps = days[0];
        for (int i = 0; i < days.length; i++) {
            if (days[i] > maxSteps) {
                maxSteps = days[i];
            }
        }
        return maxSteps;
    }

    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] >= goalByStepsPerDay) {
                currentSeries++;
            } else {
                if (currentSeries > finalSeries) {
                    finalSeries = currentSeries;
                    currentSeries = 0;
                } else {
                    currentSeries = 0;
                }
            }
        } return finalSeries;
    }
}
