package threads.main;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ThreadsMainRunner {
  public static volatile boolean keepRoutingTraffic;

  public static void main(String[] args) {
    BlockingQueue<Car> parking = new LinkedBlockingQueue<>(7);
    keepRoutingTraffic = true;
    new Thread(() -> CarTraffic.routeTrafficToTheParking(parking)).start();
    try {
      TimeUnit.SECONDS.sleep(60);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    keepRoutingTraffic = false;
  }
}
