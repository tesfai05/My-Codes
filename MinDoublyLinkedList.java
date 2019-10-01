package mar2018Data;

public class MinDoublyLinkedList {

	Node header;

	public MinDoublyLinkedList() {
		header = new Node();
	}

	public void add(String item) {
		// implement

		if(header.next==null) {
			Node n=new Node(item,null,header);
			header.next=n;
			n.previous=header;
			return;
			
		}
		Node n=new Node(item,null,null);
		if(header.next.value.compareTo(item)<=0) {
			if(header.next.next==null) {
				n.previous=header.next;
				header.next.next=n;
				return;
			}
			n.next=header.next.next;
			header.next.next.previous=n;
			header.next.next=n;
			n.previous=header.next;
		}
		else {
			n.next=header.next;
			header.next.previous=n;
			n.previous=header;
			header.next=n;
		}
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		toString(sb, header);
		return sb.toString();

	}

	private void toString(StringBuilder sb, Node n) {
		if (n == null)
			return;
		if (n.value != null)
			sb.append(" " + n.value);
		toString(sb, n.next);
	}

	class Node {
		String value;
		Node next;
		Node previous;

		public String toString() {
			return value == null ? "null" : value;
		}

		public Node(String value, Node next, Node previous) {
			this.value = value;
			this.next = next;
			this.previous = previous;
		}

		public Node() {

		}
	}

	public static void main(String[] args) {
		MinDoublyLinkedList list = new MinDoublyLinkedList();
		list.add("bob");
		System.out.println(list);
		list.add("harry");
		System.out.println(list);
		list.add("steve");
		System.out.println(list);
		list.add("anne");
		System.out.println(list);

	}
}
