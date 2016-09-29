package p1

import static p1.Main.addTwoNumbers

/**
 * Description: 
 * @author liuzhengyang
 * @since 2016-09-29
 * @version 1.0
 */
class MainTest extends GroovyTestCase {
    void testAddTwoNumbers() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(3);
        println l1
        println l2
        def numbers = addTwoNumbers(l1, l2)
        println numbers
    }

    void testTwo() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        def numbers = addTwoNumbers(l1, l2)
        println(numbers)
    }
}
