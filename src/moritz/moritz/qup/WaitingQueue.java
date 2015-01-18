package moritz.qup;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class WaitingQueue {
	
	private PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
	private ArrayList<QueueObserver> observers = new ArrayList<QueueObserver>();
	private ArrayList<Call> calls = new ArrayList<Call>();
	private int id;

	public WaitingQueue() {
		// TODO Auto-generated constructor stub
		this.id = 0;
	}

	public int getNummer() {
		
		id++;
		queue.add(id);
		updateObservers();
		return id;
	}
	
	public void addQueueObserver(QueueObserver ob){
		observers.add(ob);
	}
	
	public void updateObservers(){
		for (QueueObserver q : observers) {
			q.updateView();
		}
	}
	
	public Call getNextCall(DeskApp desk){
		if(queue.isEmpty()){
			return null;
		}else{
			Call call = new Call(queue.poll(), desk);
			// nicht nötig da poll automatisch entfernt: queue.remove(call); 
			calls.add(call);
			updateObservers();
			return call;
		}
	}
	
	public void confirmCall(Call call){
		calls.remove(call);
		updateObservers();
	}
	
	public Call getLastCall(){
		if(calls.isEmpty()){
			return null;
		}else{
			return calls.get(calls.size()-1);
		}	
	}
	
	public ArrayList<Call> getcurrentCalls(){
		return calls;
	}
	
	public int getWaitingClients(){
		return queue.size();
	}

}
