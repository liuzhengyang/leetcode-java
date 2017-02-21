package p208;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2017-02-21
 */
public class PrefixTree {
	public static void main(String[] args) {

		String word = "hello";
		String prefix = "he";
		Trie obj = new Trie();
		obj.insert(word);
		obj.print();
		boolean param_2 = obj.search(word);
		boolean param_3 = obj.startsWith(prefix);

		System.out.println(param_2);
		System.out.println(param_3);
		System.out.println(obj.search(prefix));
		obj.insert("he");
		System.out.println(obj.search(prefix));

	}
}
