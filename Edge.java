
public class Edge {
	private int distance;
	private Node start;
	private Node end;
	
	public Edge(int distance, Node start, Node end) {
		this.distance = distance;
		this.start = start;
		this.end = end;
	}
	
	public Node getStartNode() {
		return start;
	}
	
	public Node getEndNode() {
		return end;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public String toString() {
		return start.getLabel() + " - " + distance + " - " + end.getLabel(); 
	}
}
