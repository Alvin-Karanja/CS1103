import java.util.Random;

public class UnaryOpNode extends ExpNode {

    private final int function;
    private final ExpNode operand;

    public UnaryOpNode(int function, ExpNode operand) {
        this.function = function;
        this.operand = operand;
    }

    @Override
    public double evaluate(double x) {
        switch (function) {
            case 0: // sin
                return Math.sin(x);
            case 1: // cos
                return Math.cos(x);
            case 2: // exp
                return Math.exp(x);
            case 3: // abs
                return Math.abs(x);
            default:
                throw new IllegalArgumentException("Unknown function");
        }
    }

    @Override
    public ExpNode copy() {
        return new UnaryOpNode(function, operand.copy());
    }

    @Override
    public String toString() {
        return function + "(" + operand + ")";
    }

}
