import java.util.Collection;
import java.util.Stack;

public class AddService {

    private final Stack<Integer> stack;
    private final CallBack callBack;
    private int sum;

    public AddService(final CallBack callBack) {
        this.stack = new Stack<>();
        this.callBack = callBack;
        this.sum = 0;
    }

    public void push(final Collection<Integer> numbers) {
        for (final int number : numbers) {
            stack.push(number);
            callBack.push(number);
            sum = sum + number;

            callBack.sum(sum);
        }
    }

    public int pop() {
        final int number = stack.pop();

        callBack.pop(number);
        sum = sum - number;

        callBack.sum(sum);

        return number;
    }

    public int getTotalCount() {
        return stack.size();
    }

    public interface CallBack {

        void push(final int number);

        void pop(final int number);

        void sum(final int sum);
    }
}
