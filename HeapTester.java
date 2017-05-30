
public class HeapTester {
	public static void main (String[] args) {
		MinHeap q = new MinHeap();
		q.add(new WorkOrder(3, "Shampoo carpets"));
		q.add(new WorkOrder(7, "Empty Trash"));
		q.add(new WorkOrder(8, "Water Plants"));
		q.add(new WorkOrder(10, "Remove pencil sharpener shavings"));
		q.add(new WorkOrder(6, "Replace Light bulbs"));
		q.add(new WorkOrder(1, "Fix broken sink"));
		q.add(new WorkOrder(3, "Order cleaning supplies"));

		while(q.size() > 0)
			System.out.println(q.remove());

	}
}
