
public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		m.runTests();
	}
	
	public void runTests() {
		// Question 1 Tests -> 
		System.out.println(runQ1Tests());
		// Question 2 Tests
		System.out.println(runQ2Tests());
		// Question 3 Tests
		System.out.println(runQ3Tests());
		// Question 4 Tests
		System.out.println(runQ4Tests());
		// Question 5 Tests
		System.out.println(runQ5Tests());
	}
	
	// Question 1 Tests
	private String runQ1Tests() {
		return q1ExampleTest();
	}

	private String q1ExampleTest() {
		try {
			EdgeList edges = new EdgeList(2);
			edges.add(new Edge(5,new Node("A"), new Node("B")));
			String es = edges.toString();
			if(es.equals("([B,5] )")) {
				return "Edge List Test Passed";
			}
			else {
				return "Edge List Test Failed";
			}
		}
		catch(Exception e) {
			return "Edge List Test Failed";
		}
	}
	
	// Question 2 Tests
	private String runQ2Tests() {
		return q2ExampleTest();
	}
	
	private String q2ExampleTest() {
		try {
			QNode n = new QNode(1, new Node("A"));
			n.addQNode(new QNode(8, new Node("B")));
			n.addQNode(new QNode(5, new Node("C")));
			String s = n.toString();
			if(s.equals("A (1) : C (5) : B (8) : ")) {
				return "QNode Test Passed";
			}
			else {
				return "QNode Test Failed";
			}
		}
		catch(Exception e) {
			return "QNode Test Failed";
		}
	}
	
	// Question 3 Tests
	private String runQ3Tests() {
		return q3ExampleTest();
	}
	
	private String q3ExampleTest() {
		try {
			PriorityQueue queue = new PriorityQueue();
			queue.add(1, new Node("A"));
			queue.add(8, new Node("B"));
			queue.add(5, new Node("C"));
			String s = queue.toString();
			if(s.equals("A (1) : C (5) : B (8) : ")) {
				return "PriorityQueue Test Passed";
			}
			else {
				return "PriorityQueue Test Failed";
			}
		}
		catch(Exception e) {
			return "PriorityQueue Test Failed";
		}
	}
	
	// Question 4 Tests
	private String runQ4Tests() {
		return q4ExampleTest();
	}

	private String q4ExampleTest() {
		try {
			ShortestPath sp = init("graph.txt");
			int shortest = sp.shortestPath("B", "M");
			if(shortest == 8) {
				return "Shortest Path Test Passed";
			}
			else {
				return "Shortest Path Test Failed";
			}
		}
		catch(Exception e) {
			return "Shortest Path Test Failed";
		}
	}
	
	// Question 5 Tests
	private String runQ5Tests() {
		return q5ExampleTest();
	}

	private String q5ExampleTest() {
		try {
			ShortestPath sp = init("graph.txt");
			int shortest = sp.shortestPath("B", "M");
			String nodes = sp.nodesInShortestPath("B","M");
			if(nodes.equals("[BDHKM]")) {
				return "Node in Shortest Path Test Passed";
			}
			else {
				return "Node in Shortest Path Test Failed";
			}
		}
		catch(Exception e) {
			return "Node in Shortest Path Test Failed";
		}
	}

	private ShortestPath init(String fileName) {
		ShortestPath sp = new ShortestPath();
		sp.readInNodes(fileName);
		return sp;
	}
	
	
}
