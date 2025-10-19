package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        int number = calculator.calculate(readLine());
        System.out.println("결과 : " + number);
    }
}