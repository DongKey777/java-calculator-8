package calculator;

public class Application {
    public static void main(String[] args) {

        Delimiter delimiter = new Delimiter();
        Parser parser = new Parser(delimiter);
        Calculator calculator = new Calculator(parser);

        String input = IOHandler.readInput();
        int number = calculator.calculate(input);
        IOHandler.printResult(number);
    }
}