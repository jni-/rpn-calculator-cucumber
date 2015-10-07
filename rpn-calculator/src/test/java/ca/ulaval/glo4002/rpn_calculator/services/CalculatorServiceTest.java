package ca.ulaval.glo4002.rpn_calculator.services;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ca.ulaval.glo4002.rpn_calculator.domain.RpnCalculator;
import ca.ulaval.glo4002.rpn_calculator.services.CalculationResult;
import ca.ulaval.glo4002.rpn_calculator.services.CalculatorService;
import ca.ulaval.glo4002.rpn_calculator.services.EmptyInputException;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorServiceTest {

    @Mock
    private RpnCalculator rpnCalculator;

    @InjectMocks
    private CalculatorService service;

    @Test(expected = EmptyInputException.class)
    public void throwsAnExceptionWhenInputIsEmptyForPrnCalculation() {
        service.calculateRpn("");
    }

    @Test
    public void canCalculatePrnInputWithPrnCalculator() {
        final String input = "anything";
        final Integer expectedResult = 0;

        willReturn(expectedResult).given(rpnCalculator).calculate(input);

        CalculationResult result = service.calculateRpn(input);

        assertEquals(new CalculationResult(expectedResult), result);
    }

    @Test
    public void canSumAListOfNumbers() {
        final List<Integer> input = Arrays.asList(new Integer[]{1, 2, 3, 4});
        final String inputAsEquation = "1 2 3 4 + + +";
        final Integer expectedResult = 10;

        willReturn(expectedResult).given(rpnCalculator).calculate(inputAsEquation);

        CalculationResult result = service.sum(input);

        assertEquals(new CalculationResult(expectedResult), result);
    }

}
