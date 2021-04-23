package Dijkstra;

import java.util.HashSet;
import java.util.Set;

public class Graph {
	private Set<Node> nodes = new HashSet<>();
    
    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }

	public Set<Node> getNodes() {
		return nodes;
	}

	public void setNodes(Set<Node> nodes) {
		this.nodes = nodes;
	}

    public void print()
    {
    	for(Node n : nodes)
    	{
    		System.out.println(n.getName() + ": "+n.getDistance().toString());
    	}
    	
    }
}
