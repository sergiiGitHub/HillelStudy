
import org.testng.annotations.Test;

/*
https://www.baeldung.com/awaitlity-testing
 */
public class TestNg {

    @Test(threadPoolSize = 2, invocationCount = 10, timeOut = 700)
    public void testMultiple() throws InterruptedException {
        Thread.sleep(200);
        for (int i = 0; i < 5 ; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
        System.out.println("-------------------");
    }

    //        RetryPolicy retryPolicy = new RetryPolicy().retryOn(IllegalArgumentException.class)
//                                                    .withDelay(5, TimeUnit.SECONDS)
//                                                    .withMaxRetries(3);
//
//        String result = Failsafe.with(retryPolicy).get(() -> {
//
//            boolean x = false;
//
//            if (x == false) {
//                Thread.sleep(3000);
//                System.out.println("Retry");
//                throw new IllegalArgumentException();
//            }
//            else return "Ok";
//
//        });
}