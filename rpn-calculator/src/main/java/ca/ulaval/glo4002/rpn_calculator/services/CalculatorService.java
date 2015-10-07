package ca.ulaval.glo4002.rpn_calculator.services;

import java.util.List;

import ca.ulaval.glo4002.rpn_calculator.domain.RpnCalculator;

public class CalculatorService {

    private RpnCalculator rpnCalculator;

    public CalculatorService(RpnCalculator rpnCalculator) {
        this.rpnCalculator = rpnCalculator;
    }

    public CalculationResult calculateRpn(String input) {
        if (input.length() == 0) {
            throw new EmptyInputException();
        }

        return new CalculationResult(rpnCalculator.calculate(input));
    }

    public CalculationResult sum(List<Integer> numbers) {
        String equations = joinNumbers(numbers) + " " + createAppropriateNumberOfPlusSigns(numbers);
        return new CalculationResult(rpnCalculator.calculate(equations));
    }

    private String joinNumbers(List<Integer> numbers) {
        StringBuilder result = new StringBuilder();
        for (Integer number : numbers) {
            result.append(number.toString()).append(" ");
        }
        return result.toString().trim();
    }

    private String createAppropriateNumberOfPlusSigns(List<Integer> numbers) {
        StringBuilder result = new StringBuilder();
        int requiredNumberOfPlusSigns = numbers.size() - 1;
        for (int i = 0; i < requiredNumberOfPlusSigns; i++) {
            result.append("+ ");
        }
        return result.toString().trim();
    }

}
