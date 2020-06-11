
public class EdgeList {
	
	private Edge[] edges;
	private int currentLocation;
	
	public EdgeList(int initialLength) {
		edges = new Edge[initialLength];
		currentLocation = 0;
	}
	
	public int length() {
		return currentLocation;
	}
	
	public Edge get(int index) {
		if(index >= edges.length) {
			return null;
		}
		return edges[index];
	}
	
	public void add(Edge e) {
		try {
			edges[currentLocation] = e;
			currentLocation += 1;
			return;
		}
		catch(Exception error) {
			increaseSizeOfArray();
			edges[currentLocation] = e;
			currentLocation += 1;
			return;
		}
	}

	private void increaseSizeOfArray() {
		int newSize = edges.length*2;
		Edge[] temp = copyArray(edges);
		edges = new Edge[newSize];
		for(int i=0; i<temp.length; i++) {
			edges[i] = temp[i];
		}
	}

	private Edge[] copyArray(Edge[] es) {
		Edge[] e = new Edge[es.length];
		for(int i=0; i<es.length; i++) {
			e[i] = es[i];
		}
		return e;
	}
	
	public String toString() {
		String s = "(";
		for(int i=0; i<edges.length;i++) {
			if(edges[i] != null) {
				s += "["+edges[i].getEndNode().getLabel();
				s += ","+ edges[i].getDistance()+"] ";
			}
		}
		return (s+")");
	}

	public Edge[] getList() { return edges; }
}
