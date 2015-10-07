package ca.ulaval.glo4002.rpn_calculator.domain;

public class UnbalancedEquationException extends RuntimeException {

    public UnbalancedEquationException() {
        super("The equation is unbalanced, double check it.");
    }

    /**
     * @return Always equal to self.
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof UnbalancedEquationException;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    private static final long serialVersionUID = 1L;

}
