package ca.ulaval.glo4002.rpn_calculator.domain;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import ca.ulaval.glo4002.rpn_calculator.domain.InvalidOperatorException;
import ca.ulaval.glo4002.rpn_calculator.domain.RpnCalculator;
import ca.ulaval.glo4002.rpn_calculator.domain.UnbalancedEquationException;

@RunWith(Parameterized.class)
public class RpnCalculatorTest {

    @Parameters(name = "Test #{index} : {0} = {1}")
    public static Collection<Object[]> createCalculator() {
        Object[][] inputOutput = new Object[][]{
                {"1", 1},
                {"1 2 +", 3},
                {"14 2 5 + /", 2},
                {"10 4 3 + 2 * -", -4},
                {"4 2 %", new InvalidOperatorException("%")},
                {"4 2 2 +", new UnbalancedEquationException()},
                {"4 2 + + + + +", new UnbalancedEquationException()}
        };

        return Arrays.asList(inputOutput);
    }

    private RpnCalculator calculator = new RpnCalculator();

    @Parameter(0)
    public String input;

    @Parameter(1)
    public Object expectedResult;

    @Test
    public void runParametrizedTests() {
        assertEquals(expectedResult, calculateResult());
    }

    private Object calculateResult() {
        try {
            return calculator.calculate(input);
        } catch (Throwable e) {
            return e;
        }
    }

}
