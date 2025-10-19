package calculator;

public class Application {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        int number = calculator.calculate(IOHandler.readInput());
        IOHandler.printResult(number);
    }
}