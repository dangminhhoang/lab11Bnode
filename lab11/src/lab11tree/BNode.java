package lab11tree;

import java.util.ArrayList;
import java.util.List;

public class BNode<E extends Comparable<E>> {
	private E data;
	private BNode<E> left;
	private BNode<E> right;

	public BNode(E data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public BNode(E data, BNode<E> left, BNode<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public BNode<E> getLeft() {
		return left;
	}

	public void setLeft(BNode<E> left) {
		this.left = left;
	}

	public BNode<E> getRight() {
		return right;
	}

	public void setRight(BNode<E> right) {
		this.right = right;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public void add(E e) {
		// TODO Auto-generated method stub
		int compareTo = e.compareTo(this.data);
		if (compareTo < 0) {
			if (left == null) {
				left = new BNode<E>(e);
			} else {
				left.add(e);
			}
		}
		if (compareTo > 0) {
			if (right == null) {
				right = new BNode<E>(e);
			} else {
				right.add(e);
			}
		}
	}

	public int depth(E target) {
		return depth1(this, target, 0);
	}

	private int depth1(BNode<E> bNode, E target, int i) {
		// TODO Auto-generated method stub
		if (bNode == null) {
			return -1;
		}
		int comperaTo = target.compareTo(bNode.data);
		if (comperaTo < 0) {
			return depth1(bNode.left, target, i + 1);
		} else if (comperaTo > 0) {
			return depth1(bNode.right, target, i + 1);
		} else
			return i;
	}

	public int height() {
		return height1(this);
	}

	private int height1(BNode<E> bNode) {
		// TODO Auto-generated method stub
		if (bNode == null) {
			return -1;
		}

		return Math.max(height1(bNode.left), height1(bNode.right) + 1);
	}

	public int size() {
		return size1(this);
	}

	private int size1(BNode<E> bNode) {
		// TODO Auto-generated method stub
		if (bNode == null) {
			return 0;
		}

		return size1(bNode.left) + size1(bNode.right) + 1;
	}

	public boolean contains(E e) {
		int comperaTo = e.compareTo(data);
		if (comperaTo == 0)
			return true;
		else if (comperaTo < 0)
			return ((left == null) ? false : left.contains(e));
		else
			return ((right == null) ? false : right.contains(e));
	}

	public E findMin() {
		// TODO Auto-generated method stub
		if (left == null)
			return data;
		else
			return left.findMin();
	}

	public E findMax() {
		// TODO Auto-generated method stub
		if (right == null)
			return data;
		else
			return right.findMax();
	}

	public boolean remove(E target) {
		// TODO Auto-generated method stub
		BNode<E> b = new BNode<E>(null);
		b.setLeft(this);
		boolean result = remove1(b, target);
		data = b.getLeft().data;
		left = b.getLeft().left;
		right = b.getLeft().right;
		return result;
	}

	private boolean remove1(BNode<E> pr, E target) {
		BNode<E> current = pr.getLeft();
		while (current != null) {
			int comperaTo = target.compareTo(current.data);
			if (comperaTo == 0) {
				if (current.left == null && current.right == null) {
					if (pr.getLeft() == current) {
						pr.setLeft(null);
					} else {
						pr.setRight(null);
					}
				} else if (current.left != null && current.right == null) {
					if (pr.getLeft() == current) {
						pr.setLeft(current.left);
					} else {
						pr.setRight(current.left);
					}
				} else if (current.left == null && current.right != null) {
					if (pr.getLeft() == current) {
						pr.setLeft(current.right);
					} else {
						pr.setRight(current.right);
					}
				} else {
					BNode<E> sc = findMinNode(current.right);
					current.data = sc.data;
					remove1(current, sc.data);
				}
				return true;
			} else if (comperaTo < 0) {
				pr = current;
				current = current.left;
			} else {
				pr = current;
				current = current.right;
			}
		}
		return false;

	}

	private BNode<E> findMinNode(BNode<E> node) {
		while (node.left != null)
			node = node.left;
		return node;
	}

	public List<E> descendants(E target) {
		List<E> list = new ArrayList<>();
		findDescendants(this, target, list);
		return list;

	}

	private void findDescendants(BNode<E> bNode, E target, List<E> list) {
		// TODO Auto-generated method stub
		if (bNode != null) {
			int comperaTo = target.compareTo(bNode.data);
			if (comperaTo == 0) {
				collect(bNode.left, list);
				collect(bNode.right, list);
			} else if (comperaTo < 0) {
				findDescendants(bNode.left, target, list);
			} else {
				findDescendants(bNode.right, target, list);
			}
		}
	}

	private void collect(BNode<E> bNode, List<E> list) {
		// TODO Auto-generated method stub
		
		if (bNode != null) {
	        collect(bNode.left, list);
	        if (bNode.data != null) {
	            list.add(bNode.data);
	        }
	        collect(bNode.right, list);
	    }

	}

	public List<E> ancestors(E e) {
		// TODO Auto-generated method stub
		int compareTo = e.compareTo(data);
		List<E> re = new ArrayList<>();
		if(compareTo==0)
		return re;
		if(left!= null) {
			if(left.contains(e)) {
				re.addAll(left.ancestors(e));
				re.add(data);
			}
		}
		if(right!=null) {
			if(right.contains(e)) {
				re.addAll(right.ancestors(e));
				re.add(data);
			}
		}
		return re;
	}

	public void inorder() {
		// TODO Auto-generated method stub
		if(left!=null)
			left.inorder();
		System.out.print(data + " ");
		if(right!=null)
			right.inorder();
	}

	public void preorder() {
		// TODO Auto-generated method stub
		System.out.print(data + " ");
		if(left!=null)
			left.preorder();
		if(right!=null)
			right.preorder();
	}

	public void postorder() {
		// TODO Auto-generated method stub
		if(left!=null)
			left.postorder();
		if(right!=null)
			right.postorder();
		System.out.print(data + " ");
	}

}
