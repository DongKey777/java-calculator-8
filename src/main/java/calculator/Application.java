package calculator;

public class Application {
    public static void main(String[] args) {
        Parser parser = new Parser();
        Calculator calculator = new Calculator(parser);

        String input = IOHandler.readInput();
        int number = calculator.calculate(input);
        IOHandler.printResult(number);
    }
}