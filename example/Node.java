package com.github.hcsp.reflection;

/**
 * @author Zhaofeng Zhou
 * @date 2021/9/8/008 13:55
 */
public class Node {

    private int value;
    private Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    // 递归方式
    private static Node reverseList1(Node head) {
        Node nextNode = head.next;
        if (head == null || nextNode == null) {
            return head;
        } else {
            // 通过递归获取翻转之后链表的 head 节点
            Node endNode = reverseList1(nextNode);
            nextNode.next = head;
            head.next = null;
            return endNode;
        }
    }

    // 迭代方式
    private static Node reverseList2(Node head) {

        Node pre = null;
        Node curr = head;
        Node next;

        // A --> B --> C 举例
        while (curr != null) {
            // 第一次进入：将 A 节点的下一个节点 B 保存到 next
            // 第二次进入：将 B 节点的下一个节点 C 保存到 next
            next = curr.next;
            // 第一次进入：将 A 节点的下一个节点指向 pre，第一次进入 pre 为 null，因此 A 节点的下一个节点为 null
            // 第二次进入：将 B 节点的下一个节点指向 pre，第二次进入 pre 为 A，因此 B 节点的下一个节点为 A
            curr.next = pre;
            // 第一次进入：将 A 节点的信息保存到 pre，因为 A 为下一个要遍历的节点 B 的上一个节点
            // 第二次进入：将 B 节点的信息保存到 pre，因为 B 为下一个要遍历的节点 C 的上一个节点
            pre = curr;
            // 第一次进入：A 节点执行完成，将指针指向 B，下一次循环进行 B 节点相关操作(此时 A 节点指向 null)
            // 第二次进入：B 节点执行完成，将指针指向 C，下一次循环进行 C 节点相关操作(此时 B 节点指向 A)
            curr = next;
        }
        return pre;
    }

    // 判断当前列表是否成环(使用快慢指针方式)
    private static boolean isCycledList(Node head) {
        Node fastPointer, slowPointer;
        fastPointer = slowPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if (fastPointer == slowPointer) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Node third = new Node(5, null);
        Node secend = new Node(3, third);
        Node head = new Node(1, secend);


        for (Node node = head; node != null; node = node.next) {
            System.out.print(node.value);
        }
        head = reverseList1(head);
        for (Node node = head; node != null; node = node.next) {
            System.out.print(node.value);
        }
        head = reverseList2(head);
        for (Node node = head; node != null; node = node.next) {
            System.out.print(node.value);
        }

        third.next = head;
        System.out.println(isCycledList(head));
    }

}
