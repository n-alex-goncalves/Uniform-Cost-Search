
public class PriorityQueue {
	private QNode root;
	
	public PriorityQueue() {
		root = null;
	}
	
	public void add(int priority, Node n) {
		QNode Qn = new QNode(priority, n);

		if (!this.hasNext()) {
			root = Qn;
			return;
		}
		if (root.getPriority() > priority) {
			QNode temp = root;
			root = Qn;
			Qn = temp;
		}

		root.addQNode(Qn);
	}
	
	public Node getNextHighestPriorityNode() {
		QNode currentQueueLocation = root;
		Node temp;
		if (currentQueueLocation == null) {
			return null;
		}
		else {
			temp = root.getNode();
			root = currentQueueLocation.getNext();
			return temp;

		}
	}


	public boolean hasNext() {
		return (root!=null);
	}
	
	public String toString() {
		if(root == null) {
			return "(empty)";
		}
		return root.toString();
	}
}