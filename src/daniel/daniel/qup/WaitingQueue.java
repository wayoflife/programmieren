package daniel.qup;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class WaitingQueue {
	
	private PriorityQueue<Integer> qu = new PriorityQueue<>();
	private ArrayList<QueueObserver> observers = new ArrayList<>();
	private ArrayList<Call> calls = new ArrayList<Call>();
	private int lastQueueNumber = 0;
	
	public WaitingQueue() {
		// TODO Auto-generated constructor stub
	}

	/**erzeugt eine neue Warteschlangennummer
	 * 
	 * @return
	 */
	public int getNextQueueNumber() {
		lastQueueNumber++;
		qu.add(lastQueueNumber);
		updateOberservers();
		return lastQueueNumber;
	}
	
	public void addQueueObeserver(QueueObserver ob){
		observers.add(ob);
	}
	
	public void updateOberservers(){
		for (QueueObserver qo : observers) {
			qo.updateView();
		}
	}
	
	public Call getNextCall(DeskApp desk){
		if(qu.isEmpty()){
			return null;
		} else {
			Call call = new Call(qu.poll(), desk);
			calls.add(call);
			updateOberservers();
			return call;
		}
	}

	public void confirmCall(Call call){
		calls.remove(call);
		updateOberservers();
	}
	
	public Call getLastCall(){
		if(calls.isEmpty()) return null;
		return calls.get(calls.size()-1);
	}
	
	public Call[] getCurrentCalls(){
		return calls.toArray(new Call[0]);
	}
	
	public int getWaitingClients(){
		return qu.size();
	}
}
