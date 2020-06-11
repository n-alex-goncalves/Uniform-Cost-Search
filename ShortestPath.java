import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestPath {

	private HashMap<String,Node> nodes;
	
	public ShortestPath() {
		nodes = new HashMap<>();
	}
	
	public String nodesInShortestPath(String start, String end) {
			//set all nodes in hashmap as unvisited for all
		for (Map.Entry<String, Node> entry : nodes.entrySet()) {
			entry.getValue().setNotVisited();
			entry.getValue().resetShortestDistance();
		}

		Node startNode = nodes.get(start); //correct
		Node endNode = nodes.get(end); //correct
		PriorityQueue queue = new PriorityQueue(); //correct
		HashMap<String,String> prev = new HashMap<>();

		startNode.setAsStartNode(); //correct
		queue.add(0, startNode); //correct


		while (queue.hasNext()) { //correct

			Node currentNode = queue.getNextHighestPriorityNode(); //correct

			if (currentNode == endNode) { //correct
				String name = endNode.getLabel();
				List<String> path = new ArrayList<String>();
				path.add("]");
				while (true) {
					path.add(name);
					name = prev.get(name);
					if (name == startNode.getLabel()) {
						path.add(name);
						path.add("[");
						StringBuilder finalPath = new StringBuilder();
						path.forEach((finalPath::append));
						finalPath = finalPath.reverse();
						return finalPath.toString();
					}
				}
			}

			else { //correct
				for (Edge edge : currentNode.getEdges().getList()) {
					if (edge == null) {
						continue;
					}

					Node n = edge.getEndNode();
					if (n.hasBeenVisited() == false) {
						int distance = edge.getDistance();
						int currentDistance = edge.getStartNode().getShortestDistance();
						int currentShortestDistance = distance + currentDistance;
						if (currentShortestDistance < n.getShortestDistance()) {
							n.updateShortestDistance(edge);
							prev.put(n.getLabel(), edge.getStartNode().getLabel());
						}
						queue.add(n.getShortestDistance(), n);

					}
				}
			}
			currentNode.setVisited();
		}
		return null;
	}
	
	public int shortestPath(String start, String end) {
		for (Map.Entry<String, Node> entry : nodes.entrySet()) {
			entry.getValue().setNotVisited();
			entry.getValue().resetShortestDistance();
		}

		Node startNode = nodes.get(start);
		Node endNode = nodes.get(end);
		PriorityQueue queue = new PriorityQueue();
		HashMap<String,String> prev = new HashMap<>();

		startNode.setAsStartNode();
		queue.add(0, startNode);

		while (queue.hasNext()) {

			Node currentNode = queue.getNextHighestPriorityNode();

			if (currentNode == endNode) {
				return endNode.getShortestDistance();
			}
			else {
				for (Edge edge : currentNode.getEdges().getList()) {
					if (edge == null) {
						continue;
					}

					Node n = edge.getEndNode();

					if (n.hasBeenVisited() == false) {
						int distance = edge.getDistance();
						int currentDistance = edge.getStartNode().getShortestDistance();
						int currentShortestDistance = distance + currentDistance;
						if (currentShortestDistance < n.getShortestDistance()) {
							n.updateShortestDistance(edge);
							prev.put(n.getLabel(), edge.getStartNode().getLabel());
						}
						queue.add(n.getShortestDistance(), n);
					}
				}
			}
			currentNode.setVisited();
		}
		return 0;
	}
	
	public void readInNodes(String file) {
		try {
			File f = new File(file);
			BufferedReader br = new BufferedReader(new FileReader(f));
			String s = "";
			while((s=br.readLine()) !=null) {
				String[] info = s.split(" ");
				if(!nodes.containsKey(info[0])) {
					nodes.put(info[0], new Node(info[0]));
				}
				if(!nodes.containsKey(info[1])) {
					nodes.put(info[1], new Node(info[1]));
				}
				Node n1 = nodes.get(info[0]);
				Node n2 = nodes.get(info[1]);
				int i = Integer.valueOf(info[2]);
				Edge e = new Edge(i,n1,n2);
				nodes.get(info[0]).addEdge(e);
				Edge e2 = new Edge(i,n2,n1);
				nodes.get(info[1]).addEdge(e2);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void printGraph() {
		System.out.println("Graph");
		for(String k : nodes.keySet()) {
			System.out.println(nodes.get(k));
		}
	}
}
