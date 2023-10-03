import java.util.List;

public class Interceptor implements AddService.CallBack {

    AddService service;

    public Interceptor() {
        this.service = new AddService(this);
    }

    @Override
    public void push(final int number) {
        System.out.println("Pushed Element :" + number);
    }

    @Override
    public void pop(final int number) {
        System.out.println("Removed Element :" + number);
    }

    @Override
    public void sum(final int sum) {
        System.out.println("Sum of Elements: " + sum);
    }

    public int getTotalCount() {
        return service.getTotalCount();
    }

    public static void main(String[] args) {
        final Interceptor interceptor = new Interceptor();

        interceptor.service.push(List.of(3, 6));
        interceptor.service.pop();
        interceptor.service.pop();
        interceptor.service.push(List.of(9, 12));
        interceptor.service.pop();
        System.out.println("Total Count: " + interceptor.getTotalCount());
    }
}