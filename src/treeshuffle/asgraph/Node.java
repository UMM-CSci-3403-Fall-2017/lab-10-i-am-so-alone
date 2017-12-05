package treeshuffle.asgraph;

public class Node extends Tree {

	private Tree left;
	private Tree right;
	private char operator;

	public Node(char operator, Tree left, Tree right) {
		this.operator = operator;
		this.left = left;
		this.right = right;
	}
	
	public char getOperator() {
		return operator;
	}

	public Tree getLeft() {
		return left;
	}
	
	public Tree getRight() {
		return right;
	}

	public boolean isLeaf() {
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Node)) {
			return false;
		}
		Node other = (Node) o;
		return operator == other.operator && left.equals(other.left) && right.equals(other.right);
	}

	private int hashCode;
	@Override
	public int hashCode() {
		int result = hashCode;

		if (result == 0){
			result = 17;
			result = 31 * result + left.hashCode();
			result = 31 * result + right.hashCode();
			hashCode = result;
		}

		return result;
	}

	@Override
	public <T> T doAcceptVisitor(TreeVisitor<T> visitor) {
		return visitor.visitNode(this);
	}

}
