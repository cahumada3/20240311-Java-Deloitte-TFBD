package Java.Day2.MultiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DoingLaundry {

    //you have to wait for the washing machine to be finished before you can put more clothes into it
    public static Lock washerLock = new ReentrantLock();
    public static Lock dryerLock = new ReentrantLock();
    public static Lock folderLock = new ReentrantLock();

    public static void main(String[] args) {
        List<Laundry> laundryTodo = new ArrayList<>(3);
        laundryTodo.add(new Laundry("whites", "dirty"));
        laundryTodo.add(new Laundry("delicates", "dirty"));
        laundryTodo.add(new Laundry("bedding", "dirty"));

        Thread washer;
        Thread dryer;
        Thread folder;

        for(Laundry laundry : laundryTodo) {
            washer = new Thread(new WashingMachine(laundry));
            dryer = new Thread(new DryingMachine(laundry));
            folder = new Thread(new FoldingMachine(laundry));

            washer.start();
            dryer.start();
            folder.start();
        }
    }
}

class Laundry {
    String type;
    String status;

    public Laundry() { }

    public Laundry(String type, String status) {
        this.type = type;
        this.status = status; // dirty, washed, dried, folded
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    } 
}

class WashingMachine implements Runnable {

    Laundry currentLoad;
    public WashingMachine(Laundry currentLoad) {
        this.currentLoad = currentLoad;
    }

    @Override
    public void run() {
        // loop until the current load has been set to dirty
        while(!currentLoad.getStatus().equals("dirty")) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // will actually lock our washer
        DoingLaundry.washerLock.lock();

        System.out.println("The washing machine has started " + currentLoad.getType());

        try {
            // simulating washer
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("The washing machine has finished " + currentLoad.getType());
        currentLoad.setStatus("washed");

        //once the load has finished, unlock the washer
        DoingLaundry.washerLock.unlock();
    }   
}

class DryingMachine implements Runnable {

    Laundry currentLoad;
    public DryingMachine(Laundry currentLoad) {
        this.currentLoad = currentLoad;
    }

    @Override
    public void run() {
        // loop until the current load has been set to washed
        while(!currentLoad.getStatus().equals("washed")) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // will actually lock our dryer
        DoingLaundry.dryerLock.lock();

        System.out.println("The drying machine has started " + currentLoad.getType());

        try {
            // simulating dryer
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("The dryer machine has finished " + currentLoad.getType());
        currentLoad.setStatus("dried");

        //once the load has finished, unlock the dryer
        DoingLaundry.dryerLock.unlock();
    }
}

class FoldingMachine implements Runnable {

    Laundry currentLoad;
    public FoldingMachine(Laundry currentLoad) {
        this.currentLoad = currentLoad;
    }

    @Override
    public void run() {
        // loop until the current load has been set to dried
        while(!currentLoad.getStatus().equals("dried")) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // will actually lock our folder
        DoingLaundry.folderLock.lock();

        System.out.println("The folding machine has started " + currentLoad.getType());

        try {
            // simulating folder
            Thread.sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("The folder machine has finished " + currentLoad.getType());
        currentLoad.setStatus("folder");

        //once the load has finished, unlock the folder
        DoingLaundry.folderLock.unlock();
    }
}
