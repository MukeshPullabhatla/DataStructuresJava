// Java program to sort link list using insertion sort
public class LinkedListIS {
	node head;
	node sorted;
	
	class node
	{
		int val;
		node next;
		
		public node(int val)
		{
			this.val = val;
			
		}
	}
	void push(int val)
	{
		/* allocate node */
		node newnode = new node(val);
		/* link the old list off the new node */
		newnode.next = head;
		/* move the head to point to the new node */
		head = newnode;
	}
	/* function to sort a singly linked list using insertion sort */
	void insertionSort(node headref)
	{
		//initialize sorted linked list
		sorted = null;
		node current = headref;
		/* traverse the given linked list and insert every node to sorted */
		while(current != null)
		{
			//store the next iteration
			node next = current.next;
			//insert current in sorted linked list
			sortedInsert(current);
			//update current
			current = next;
		}
		//update head_ref to point to sorted linked list
		head = sorted;
	}
	/*
	 * function to insert a new node in a list. NOte that this function expects a
	 * pointer to head-ref as this can modify the head of the input linked list
	 * (similar to push())
	 */
	void sortedInsert(node newnode)
	{
		/* special case fo the head end */
		if(sorted == null || sorted.val >= newnode.val)
		{
			newnode.next = sorted;
			sorted = newnode;
		}
		else
		{
			node current = sorted;
			/* locate the node before the point of insertion */
			while (current.next != null && current.next.val < newnode.val)
			{
				current = current.next;
			}
			newnode.next = current.next;
			current.next = newnode;
		}
	}
	/* Function to print linked list */
	void printlist(node head)
	{
		while(head != null)
		{
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	
	//Driver program to test above functions
	public static void main(String[] args)
	{
		LinkedListIS list = new LinkedListIS();
		list.push(5);
		list.push(20);
		list.push(4);
		list.push(3);
		list.push(30);
		System.out.println("Linked List before sorting..");
		list.printlist(list.head);
		list.insertionSort(list.head);
		System.out.println("\nLinkedList after sorting");
		list.printlist(list.head);
	}

}
