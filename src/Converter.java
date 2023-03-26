public class Converter {

    int distance = 75;
    int kilocalories = 50;

    int convertToKm(int SumSteps) {
        int sum = (distance * SumSteps) / 100_000;
        return sum;
    }

    int convertStepsToKilocalories(int SumSteps) {
        int answer = SumSteps * kilocalories / 1_000;
        return answer;
    }
}