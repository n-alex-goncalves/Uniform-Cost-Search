
public class QNode{
	private int priority;
	private QNode next;
	private QNode previous;
	private Node node;
	
	public QNode(int priority, Node n) {
		this.priority = priority;
		this.node = n;
		next = null;
		previous = null;
	}
	
	public Node getNode() {
		return node;
	}
	
	public void addQNode(QNode n) {
		QNode currentNode = this;
		int thisPriority = getPriority();

		int addPriority = n.priority;

		while (true) {
			if (addPriority >= thisPriority) {
				if (currentNode.next == null) {
					n.previous = currentNode;
					currentNode.next = n;
					return;
				}

				if (currentNode.next.priority >= addPriority) {
					QNode nextNode = currentNode.next;
					nextNode.previous = n;
					n.next = nextNode;
					n.previous = currentNode;
					currentNode.next = n;
					return;
				}
			}

			if (addPriority < thisPriority) {
				if (currentNode.previous == null) {
					n.next = currentNode;
					currentNode.previous = n;
					//change root
					return;
				}

				if (currentNode.previous.priority < addPriority) {
					QNode previousNode = currentNode.previous;
					previousNode.next = n;
					n.previous = previousNode;
					n.next = currentNode;
					currentNode.previous = n;
					//change root
					return;
				}
			}

			currentNode = currentNode.next;
			thisPriority = currentNode.priority;
		}
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPrevious(QNode p) {
		previous = p;
	}
	
	public QNode getPrevious() {
		return previous;
	}
	
	public void setNext(QNode n) {
		next = n;
	}
	
	public QNode getNext() {
		return next;
	}
	
	public String toString() {
		String s = node.getLabel() + " (" + priority + ") : ";
		if (next!=null) {
			s += next.toString();
		}
		return s;
	}
}

