
public class Node{
	private String label;
	private EdgeList edges;
	private int shortestDistance;
	private boolean visited;
	
	public Node(String label) {
		this.label = label;
		edges = new EdgeList(2);
		this.shortestDistance = Integer.MAX_VALUE;
		visited = false;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void addEdge(Edge e) {
		edges.add(e);
	}
	
	public int getShortestDistance() {
		return shortestDistance;
	}
	
	public EdgeList getEdges() {
		return edges;
	}
	
	public void setAsStartNode() {
		shortestDistance = 0;
	}
	
	public void updateShortestDistance(Edge e) {
		int currentShortest = e.getDistance() + e.getStartNode().getShortestDistance();
		if(currentShortest < shortestDistance) {
			shortestDistance = currentShortest;
		}
	}
	
	public void setVisited() {
		visited = true;
	}
	
	public boolean hasBeenVisited() {
		return visited;
	}

	public boolean equals(Node n) {
		return label.equals(n.getLabel());
	}
	
	public String toString() {
		return label + ":: " + edges;
	}

	public void setNotVisited() { visited = false;	}

	public void resetShortestDistance() { shortestDistance = Integer.MAX_VALUE; }
}
