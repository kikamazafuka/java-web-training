package by.training.module4.model;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ferry2 extends Thread {

    private static final Logger LOGGER = Logger.getLogger(Ferry.class);
    private int maxLoad;
    private AtomicInteger currentLoad;
    private boolean loaded = false;
    private Lock loadLock = new ReentrantLock();
    private List<Vehicle> vehicles ;
    private int currentIteration = 0;
    private int maxIteration = 2;

    public Ferry2(int maxLoad) {
        this.maxLoad = maxLoad;
        currentLoad = new AtomicInteger(0);
        vehicles = new ArrayList<>();
    }

    public boolean tryLoad(Vehicle vehicle) {
        loadLock.lock();
        LOGGER.info("ferry try LOAD begin..");
        if (!loaded/* && loadLock.tryLock()*/) {
            LOGGER.info("IF ferry try LOAD begin.."+" Ferry loaded: "+loaded);
            try {
                if (currentLoad.intValue()+ vehicle.getWeight() < maxLoad) {
                    LOGGER.info(" ferry try LOAD .. Current load: "+currentLoad+" "+" loaded: "+loaded);
                    vehicles.add(vehicle);
                    currentLoad.addAndGet(vehicle.getWeight());
                    vehicle.waitForDepart();
                    TimeUnit.SECONDS.sleep(5);
                    return true;
                } else {
                    LOGGER.info("ELSE ferry try LOAD begin.."+" loaded: "+loaded);
                    loaded = true;
                    this.depart();
                    LOGGER.info("ELSE ferry try LOAD begin.."+" loaded: "+loaded);
                    return false;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            } finally {
                loadLock.unlock();
            }
        } else {
            return false;
        }
    }

    public void depart() {
        LOGGER.info("ferry DEPART begin..");
        for (Vehicle vehicle : vehicles) {
            vehicle.depart();
        }
        loadLock.lock();
        loaded = false;
        currentLoad.set(0);
        currentIteration++;
        loadLock.unlock();
    }

    @Override
    public void run() {
        LOGGER.info("ferry RUN  begin..");
        while (currentIteration < maxIteration) {
            try {
                TimeUnit.SECONDS.sleep(1);
            LOGGER.info("ferry RUN while currentIteration<maxIteration begin..." + currentLoad +" curr Iteration "+currentIteration);
            if (!loaded) {
                LOGGER.info("ferry RUN IF  begin...loaded" + loaded);
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }

        }
    }
}

