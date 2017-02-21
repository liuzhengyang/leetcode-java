package p208;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * TODO Refactor this code, too many if and loop
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2017-02-21
 */
public class Trie {

	public void print() {
		root.print();
	}
	private TrieNode root = new TrieNode();

	/** Initialize your data structure here. */
	public Trie() {

	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode current = root;
		char[] chars = word.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			List<TrieNode> children = current.getChildren();
			if (children == null) {
				ArrayList<TrieNode> trieNodes = new ArrayList<>();
				current.setChildren(trieNodes);
				children = trieNodes;
			}
			boolean hasThisElement = false;
			for (TrieNode node : children) {
				if (chars[i] == node.getVal()) {
					current = node;
					hasThisElement = true;
					if (i == chars.length -1) {
						node.setHasWord(true);
					}
					break;
				}
			}
			if (!hasThisElement) {
				TrieNode trieNode = new TrieNode(chars[i]);
				if (i == chars.length -1) {
					trieNode.setHasWord(true);
				}
				children.add(trieNode);
				current = trieNode;
			}
		}
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode current = this.root;
		char[] chars = word.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			List<TrieNode> children = current.getChildren();
			if (children == null || children.size() == 0) {
				return false;
			}
			boolean contains = false;
			for (TrieNode each : children) {
				if (each.getVal() == chars[i]) {
					current = each;
					contains = true;
					if (i == chars.length -1) {
						if (each.hasWord) {
							return true;
						}
					}
					break;
				}
			}
			if (!contains) {
				return false;
			}
		}
		if (current.getChildren() != null) {
			return false;
		}
		return true;
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
		TrieNode current = this.root;
		char[] chars = prefix.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			List<TrieNode> children = current.getChildren();
			if (children == null || children.size() == 0) {
				return false;
			}
			boolean contains = false;
			for (TrieNode each : children) {
				if (each.getVal() == chars[i]) {
					current = each;
					contains = true;
					break;
				}
			}
			if (!contains) {
				return false;
			}
		}
		return true;
	}

	public static class TrieNode {
		private char val;
		private List<TrieNode> children;
		private boolean hasWord;

		public TrieNode() {
		}

		public TrieNode(char val) {
			this.val = val;
		}

		public char getVal() {
			return val;
		}

		public void setVal(char val) {
			this.val = val;
		}

		public List<TrieNode> getChildren() {
			return children;
		}

		public void setChildren(List<TrieNode> children) {
			this.children = children;
		}

		public boolean isHasWord() {
			return hasWord;
		}

		public void setHasWord(boolean hasWord) {
			this.hasWord = hasWord;
		}

		public void print() {
			System.out.println("val " + val);
			if (children != null) {
				for (TrieNode trieNode : children) {
					trieNode.print();
				}
			}
		}
	}

}
