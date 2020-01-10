import domain.Function;
import domain.FunctionType;
import domain.Functions;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        while (true) {
            OutputView.printMainScreen();
            final int functionNumber = InputView.inputFunctionNumber();
            final FunctionType functionType = FunctionType.valueOf(functionNumber);
            final Function function = Functions.get(functionType);
            function.call();
        }
    }
}
