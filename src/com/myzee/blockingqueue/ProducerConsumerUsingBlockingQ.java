package com.myzee.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerUsingBlockingQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BlockingQueue<Integer> b = new ArrayBlockingQueue<Integer>(10);
		
		Thread pt = new Thread(new PThread(b));
		pt.start();
		
		Thread ct = new Thread(new CThread(b));
		ct.start();
	}

}

class PThread implements Runnable {
	BlockingQueue<Integer> b;
	public PThread(BlockingQueue<Integer> b){
		this.b = b;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 5; i++) {
			System.out.println("producer produced - " + i);
			try {
				b.put(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class CThread implements Runnable {
	
	BlockingQueue<Integer> b;
	
	public CThread(BlockingQueue<Integer> b) {
		this.b = b;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 5; i++) {
			try {
				System.out.println("Consumer consumes - " + b.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
