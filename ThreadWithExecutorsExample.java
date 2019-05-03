import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import static java.util.concurrent.Executors.callable;

public class ThreadWithExecutorsExample {
    public static void main(String[] args) throws InterruptedException {

        //Runnable
        ExecutorService ex = Executors.newSingleThreadExecutor();
        ex.submit(() -> {
                    String threadName = Thread.currentThread().getName();
                    System.out.println("Hello " + threadName);
                }
        );

        try {
            System.out.println("attempt to shutdown executor");
            ex.shutdown();
            ex.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        }
        finally {
            if (!ex.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            ex.shutdownNow();
            System.out.println("shutdown finished");
        }

        //Callable
        Callable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };

        ExecutorService ex1 = Executors.newFixedThreadPool(1);
        Future<Integer> future = ex1.submit(task);
        System.out.println("Future Done ?" + future.isDone());
        try {
            Integer result = future.get();
            System.out.println("future done? " + future.isDone());
            System.out.print("result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            ex1.shutdownNow();
        }

        //Invoke all method
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
                () -> "task1",
                () -> "task2",
                () -> "task3");

        try {
            executor.invokeAll(callables)
                    .stream()
                    .map(future1 -> {
                        try {
                            return future1.get();
                        }
                        catch (Exception e) {
                            throw new IllegalStateException(e);
                        }
                    })
                    .forEach(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //Invoke any
//        Callable<String> callable(String result, long sleepSeconds) {
//            return () -> {
//                TimeUnit.SECONDS.sleep(sleepSeconds);
//                return result;
//            };
//        }

        ExecutorService executor2 = Executors.newWorkStealingPool();

        //   List<Callable<String>> callables1 = Arrays.asList(
        //          callable("task1", 2),
        //          callable("task2", 1),
        //         callable("task3", 3));

        String result = null;
        // try {
        //      result = executor2.invokeAny(callables1);
        //  } catch (InterruptedException e) {
        //      e.printStackTrace();
        //  } catch (ExecutionException e) {
        //       e.printStackTrace();
        //  }
        System.out.println(result);

        // => task2

        //Scheduled executors
        ScheduledExecutorService executor3 = Executors.newScheduledThreadPool(1);

        Runnable task3 = () -> System.out.println("Scheduling: " + System.nanoTime());
        ScheduledFuture<?> future3 = executor3.schedule(task3, 3, TimeUnit.SECONDS);

        TimeUnit.MILLISECONDS.sleep(1337);

        long remainingDelay = future3.getDelay(TimeUnit.MILLISECONDS);
        System.out.printf("Remaining Delay: %sms", remainingDelay);
    }
}
