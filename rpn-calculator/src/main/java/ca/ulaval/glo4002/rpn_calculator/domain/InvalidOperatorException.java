package ca.ulaval.glo4002.rpn_calculator.domain;

public class InvalidOperatorException extends RuntimeException {

    private String operator;

    public InvalidOperatorException(String operator) {
        super("Invalid operator: " + operator);
        this.operator = operator;
    }

    /**
     * @return Equality is based on the invalid operator.
     */
    @Override
    public boolean equals(Object obj) {
        InvalidOperatorException o = (InvalidOperatorException) obj;
        return o != null && o.operator.equals(operator);
    }

    @Override
    public int hashCode() {
        return operator.hashCode();
    }

    private static final long serialVersionUID = 1L;

}
