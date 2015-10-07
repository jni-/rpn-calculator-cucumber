package ca.ulaval.glo4002.rpn_calculator.services;

public class CalculationResult {

    public int result;

    public CalculationResult(int result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object obj) {
        CalculationResult o = (CalculationResult) obj;
        return o != null && o.result == result;
    }

}
