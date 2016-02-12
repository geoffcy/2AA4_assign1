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
		private Vector<Token> contents;
		
		public Node(){
			
		}
		
		public boolean isEmpty(){
			return this.contents.isEmpty();
		}
		
		public void addToken(Token t){
			this.contents.add(t);
		}
		
		public Token popToken(){
			Token t = this.contents.lastElement();
			this.contents.remove(t);
			return t;
		}
		
		public Token getToken(){
			return this.contents.lastElement();
		}
	}
	
	public static final String[] validColors = {"blue", "red"};
	private Node[][] nodes = {{new Node(), null, new Node(), null, new Node()},
							  {null, new Node(), new Node(), new Node(), null},
							  {new Node(), new Node(), null, new Node(), new Node()},
							  {null, new Node(), new Node(), new Node(), null},
							  {new Node(), null, new Node(), null, new Node()}};
	public Model(){
		
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
			this.nodes[x][y].addToken(t);
		}
		throw new InvalidParameterException();
	}
	
	public Token popToken(int x, int y){
		if (this.isValidCoord(x, y) && !this.isEmptyPosition(x, y)){
			return this.nodes[x][y].popToken();
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