package com.sebss.Clase.Tema5.Tema5_5;

import java.util.concurrent.locks.*;
import java.util.Arrays;

public class Ejercicio6 {

    public static void main(String[] args) {
		new Ejercicio6().exec();
	}

    private void println(String msg){
        String name = Thread.currentThread().getName();
        System.out.println(name+": "+msg);
    }
    
    private static final int NUM_PROCESOS_TIPO = 1;
	private static final int ITERS = 5;
	private DataSourceManager dsManager = new DataSourceManager();

	public void ds0() {
		try {
			for(int i=0; i<ITERS; i++){
				Thread.sleep((long)(Math.random() * 500));
				dsManager.accessDataSource(0);
				println("Using DataSource 0");
                Thread.sleep((long)(Math.random() * 500));
				dsManager.freeDataSource(0);
                println("Free DataSource 0");
			}
		} catch (InterruptedException e) {
		}
	}

	public void ds1() {
		try {
			for(int i=0; i<ITERS; i++){
				Thread.sleep((long) (Math.random() * 500));
				dsManager.accessDataSource(1);
				println("Using DataSource 1");
                Thread.sleep((long)(Math.random() * 500));
				dsManager.freeDataSource(1);
                println("Free DataSource 1");
			}
		} catch (InterruptedException e) {
		}
	}

	public void dsAny() {
		try {
			for(int i=0; i<ITERS; i++){
				Thread.sleep((long) (Math.random() * 500));
				int ds = dsManager.accessAnyDataSource();
				println("Using DataSource Any (" + ds + ")");
                Thread.sleep((long)(Math.random() * 500));
				dsManager.freeDataSource(ds);
                println("Free DataSource Any (" + ds + ")");
			}
		} catch (InterruptedException e) {
		}
	}

	public void exec() {

		for (int i = 0; i < NUM_PROCESOS_TIPO; i++) {
			new Thread(()-> ds0(),"DS0-"+i).start();
			new Thread(()-> ds1(),"DS1-"+i).start();
			new Thread(()-> dsAny(),"ANY-"+i).start();
		}
	}

    private class DataSourceManager{

        private static final int NUM_DS = 2;
        private boolean[] busyDataSources = new boolean[NUM_DS];

        private ReentrantLock lock = new ReentrantLock(true);
        private Condition[] waitForDataSource = new Condition[NUM_DS];
        private Condition waitForAnyDataSource = lock.newCondition();
        
        public DataSourceManager() {
            for (int i = 0; i < NUM_DS; i++) {
                waitForDataSource[i] = lock.newCondition();
            }
            Arrays.fill(busyDataSources, false);
        }

        public int accessAnyDataSource() throws InterruptedException {
            lock.lock();
            try {
                while (getFreeDS()==-1) {
                    waitForAnyDataSource.await();
                }
                int ds=getFreeDS();
                if (!busyDataSources[ds]) {
                    busyDataSources[ds] = true;
                    return ds;
                }else{
                    return -1;
                }
            } finally {
                lock.unlock();
            }
        }

        public void accessDataSource(int dataSource) throws InterruptedException {
            lock.lock();
            try {
                while (busyDataSources[dataSource]) {
                    waitForDataSource[dataSource].await();
                }
                busyDataSources[dataSource] = true;
            } finally {
                lock.unlock();
            }
        }

        public void freeDataSource(int dataSource) {

            lock.lock();
            try {
                busyDataSources[dataSource] = false;
                if (lock.hasWaiters(waitForDataSource[dataSource])){
                    waitForDataSource[dataSource].signal();
                } else if (lock.hasWaiters(waitForAnyDataSource)) {
                    waitForAnyDataSource.signal();
                }
            } finally {
                lock.unlock();
            }
        }

        private int getFreeDS(){
            for(int i=0;i<NUM_DS;i++){
                if(!busyDataSources[i]) return i;
            }
            return -1;
        }

    }
}
