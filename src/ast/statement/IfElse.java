package ast.statement;

import ast.AbstractASTNode;
import ast.expression.Expression;

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.List;

public class IfElse extends AbstractASTNode implements Statement {

    private Expression condition;
    private List<Statement> ifBody = new ArrayList<>();
    private List<Statement> elseBody = new ArrayList<>();

    public IfElse(int line, int column, Expression condition, List<Statement> ifBody, List<Statement> elseBody) {
        super(line, column);
        setCondition(condition);
        setIfBody(ifBody);
        setElseBody(elseBody);
    }

    public IfElse(int line, int column){
        super(0,0);
    }

    public Expression getCondition() {
        return condition;
    }

    public void setCondition(Expression condition) {
        this.condition = condition;
    }

    public List<Statement> getIfBody() {
        return new ArrayList<>(ifBody);
    }

    public void setIfBody(List<Statement> ifBody) {
        this.ifBody = new ArrayList<>(ifBody);
    }

    public List<Statement> getElseBody() {
        return new ArrayList<>(elseBody);
    }

    public void setElseBody(List<Statement> elseBody) {
        this.elseBody = new ArrayList<>(elseBody);
    }
}
