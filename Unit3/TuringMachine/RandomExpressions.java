import java.util.Random;

public class RandomExpressions {

    public static Expression randomExpression(int depth) {
        if (depth == 0) {
            return new Constant(new Random().nextInt());
        } else {
            Operator op = Operator.values()[new Random().nextInt(Operator.values().length)];
            Expression left = randomExpression(depth - 1);
            Expression right = randomExpression(depth - 1);
            return new BinaryOperation(op, left, right);
        }
    }

}
