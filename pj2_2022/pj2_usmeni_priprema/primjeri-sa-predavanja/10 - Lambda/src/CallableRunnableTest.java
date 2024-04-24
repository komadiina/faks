import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableRunnableTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		call();
	}

	public static void call() throws InterruptedException, ExecutionException {
		Callable<Integer> r = () -> {
			Thread.sleep(1);
			int sum = 0;
			for (int i = 0; i < 100; i++) {
				sum += i;
			}
			return sum;
		};
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<Integer> result = executorService.submit(r);
		System.out.println(result.get());
	}
	
	public static void run() {
		Runnable r = () -> {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			int sum = 0;
			for (int i = 0; i < 100; i++) {
				sum += i;
			}
			System.out.println(sum);
		};
		new Thread(r).start();
	}
	
	public static void call2() {
		Callable<Void> r = () -> {
			Thread.sleep(1);
			int sum = 0;
			for (int i = 0; i < 100; i++) {
				sum += i;
			}
			System.out.println(sum);
			return null;
		};
	}
}
