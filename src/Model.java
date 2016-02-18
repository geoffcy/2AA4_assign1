import java.util.Vector;
import java.security.InvalidParameterException;

public class Model {
	private class Token {
		private String color;
		
		public Token (String color){
			this.color = color;
		}
		
		public String getColor(){
			return this.color;
		}
	}
	
	private class Node {
		private Token token;
		
		public Node(){
			
		}
		
		public boolean isEmpty(){
			return this.token == null;
		}
		
		public void putToken(Token t){
			this.token = t;
		}
		
		public Token grabToken(){
			Token t = this.token;
			this.token = null;
			return t;
		}
		
		public Token getToken(){
			return this.token;
		}
	}
	
	public static final String[] validColors = {"blue", "red"};
	private final Node[][] nodes = {{new Node(), null, new Node(), null, new Node()},
							  {null, new Node(), new Node(), new Node(), null},
							  {new Node(), new Node(), null, new Node(), new Node()},
							  {null, new Node(), new Node(), new Node(), null},
							  {new Node(), null, new Node(), null, new Node()}};
	
	//not done at node level so no duplication
	private final Node[][] connections = {
			{nodes[0][0], nodes[2][0]},
			{nodes[0][0], nodes[0][2]},
			{nodes[2][0], nodes[4][0]},
			{nodes[4][0], nodes[4][2]},
			{nodes[4][2], nodes[4][4]},
			{nodes[0][4], nodes[2][4]},
			{nodes[2][4], nodes[4][4]},
			{nodes[1][1], nodes[2][1]},
			{nodes[1][1], nodes[1][2]},
			{nodes[2][0], nodes[2][1]},
			{nodes[0][2], nodes[1][2]},
			{nodes[1][2], nodes[1][3]},
			{nodes[2][1], nodes[3][1]},
			{nodes[1][3], nodes[2][3]},
			{nodes[3][1], nodes[3][2]},
			{nodes[2][3], nodes[3][3]},
			{nodes[3][2], nodes[3][3]},
			{nodes[2][3], nodes[2][4]},
			{nodes[3][2], nodes[4][2]}
			};

	
	public Model(){
		
	}
	
	private boolean isConnected(Node a, Node b){
		for (Node[] c : this.connections){
			if ((c[0] == a || c[0] == b) &&
				(c[1] == a || c[1] == b)){
				return true;
			}
		}
		return false;
	}
	
	private boolean isValidCoord(int x, int y){
		return ((0 <= x && x < this.nodes.length)    &&
			    (0 <= y && y < this.nodes[0].length) &&
			    (this.nodes[x][y] != null));
	}
	
	public boolean isValidColor(String color){
		for (String validColor : validColors){
			if (validColor.equals(color)){
				return true;
			}
		}
		return false;
	}
	
	public boolean isEmptyPosition(int x, int y){
		if (this.isValidCoord(x, y)){
			return this.nodes[x][y].isEmpty();
		}
		throw new InvalidParameterException();
	}
	
	public void putToken(int x, int y, String color){
		if (this.isValidCoord(x, y) && isValidColor(color) && isEmptyPosition(x, y)){
			Token t = new Token(color);
			this.nodes[x][y].putToken(t);
		}
		throw new InvalidParameterException();
	}
	
	private Token popToken(int x, int y){
		if (this.isValidCoord(x, y) && !this.isEmptyPosition(x, y)){
			return this.nodes[x][y].grabToken();
		}
		throw new InvalidParameterException();
	}
	
	public String getToken(int x, int y){
		if (this.isValidCoord(x, y)){
			return this.nodes[x][y].getToken().getColor();
		}
		return "";
	}
}