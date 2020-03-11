package ast.expression;

import ast.type.Type;
import visitor.Visitor;

public class Cast extends AbstractExpression {

    private Type type;
    private Expression expression;

    public Cast(int line, int column, Type type, Expression expression) {
        super(line, column);
        setExpression(expression);
        setType(type);
    }

    public Type getType() {
        return type;
    }

    private void setType(Type type) {
        this.type = type;
    }

    public Expression getExpression() {
        return expression;
    }

    private void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "Cast{" +
                "type=" + type +
                ", expression=" + expression +
                '}';
    }
    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
