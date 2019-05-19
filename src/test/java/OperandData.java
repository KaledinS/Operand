
public class OperandData {

    private int operand1;
    private int operand2;
    private int result;
    private char operation;

    public OperandData withOperand1(int operand1) {
        this.operand1 = operand1;
        return this;
    }

    public OperandData withOperand2(int operand2) {
        this.operand2 = operand2;
        return this;
    }

    public OperandData withResult(int result) {
        this.result = result;
        return this;
    }

    public OperandData withOperation(char operation) {
        this.operation = operation;
        return this;
    }

    public int getOperand1() {
        return operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public int getResult() {
        return result;
    }

    public char getOperation() {
        return operation;
    }

    public int evaluate() {
        int result = 0;
        switch (getOperation()) {
            case ('+'):
                result = getOperand1() + getOperand2();
                break;
            case ('-'):
                result = getOperand1() - getOperand2();
                break;
            case ('*'):
                result = getOperand1() * getOperand2();
                break;
            case ('/'):
                result = getOperand1() / getOperand2();
                break;
            default:
                throw new IllegalArgumentException();
        }
        return result;
    }

}
