package lab11tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}

//Add element e into BST
	public void add(E e) {
//TODO	
		if (root == null)
			this.root = new BNode<E>(e);
		else
			this.root.add(e);

	}

	public void add(E... col) {
		for (E e : col) {
			add(e);
		}
	}

//Add a collection of elements col into BST
	public void add(Collection<E> col) {
//TODO
		for (E e : col) {
			add(e);
		}
	}

//compute the depth of a node in BST
	public int depth(E node) {
//TODO
		return root.depth(node);
	}

//compute the height of BST
	public int height() {
//TODO
		return root.height();
	}

//Compute total nodes in BST
	public int size() {
//TODO
		return root.size();
	}

//Check whether element e is in BST
	public boolean contains(E e) {
//TODO
		if (root == null)
			return false;

		return this.root.contains(e);
	}

//Find the minimum element in BST
	public E findMin() {
//TODO
		if (root == null)
			return null;
		else
			return root.findMin();
	}

//Find the maximum element in BST
	public E findMax() {
//TODO
		if (root == null)
			return null;
		else
			return root.findMax();
	}

//Remove element e from BST
	public boolean remove(E e) {
//TODO
		if (root == null)
			return false;
		else
			return root.remove(e);
	}

//get the descendants of a node
	public List<E> descendants(E data) {
//TODO
		if (root == null)
			return new ArrayList<>();
		else
			return root.descendants(data);
	}

//get the ancestors of a node
	public List<E> ancestors(E data) {
//TODO
		if (root == null)
			return null;
		else
			return root.ancestors(data);
	}

	// display BST using inorder approach
	public void inorder() {
		// TODO
		if(root !=null)
			 root.inorder();
		System.out.println();
	}

	// display BST using preorder approach
	public void preorder() {
		// TODO
		if(root!=null)
			 root.preorder();
		System.out.println();
	}

	// display BST using postorder approach
	public void postorder() {
		// TODO
		if(root!=null)
			root.postorder();
		System.out.println();
	}
	

	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();
		bst.add(50, 30, 70, 20, 40, 60, 80);
		// Print properties of the BST
		System.out.println("Depth of 40: " + bst.depth(40));
		System.out.println("Height of BST: " + bst.height());
		System.out.println("Size of BST: " + bst.size());

		// Check if elements are in the BST
		System.out.println("Contains 40? " + bst.contains(40));
		System.out.println("Contains 90? " + bst.contains(90));

		// Find min and max elements in the BST
		System.out.println("Min element: " + bst.findMin());
		System.out.println("Max element: " + bst.findMax());

		// Remove an element from the BST
		System.out.println("Remove 40: " + bst.remove(40));
		System.out.println("Contains 40? " + bst.contains(40));

		// Add more elements
		Collection<Integer> additionalElements = Arrays.asList(10, 35, 75, 5, 45, 85);
		bst.add(additionalElements);

		// Print properties again
		System.out.println("Height of BST: " + bst.height());
		System.out.println("Size of BST: " + bst.size());

		// Find descendants of a node
		List<Integer> descendants = bst.descendants(30);
		System.out.println("Descendants of 30: " + descendants);

		// Find ancestors of a node
		List<Integer> ancestors = bst.ancestors(85);
		System.out.println("Ancestors of 85: " + ancestors);
		 BST<Integer> bst1 = new BST<>();
		    bst1.add(25,10,12,15,18,22,24,4,31,35,44,50,66,70,90);

		    System.out.println("Inorder traversal:");
		    bst1.inorder();

		    System.out.println("Preorder traversal:");
		    bst1.preorder();

		    System.out.println("Postorder traversal:");
		    bst1.postorder();
	
		  
}}
