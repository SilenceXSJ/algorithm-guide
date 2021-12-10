package org.silence.leetcode;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinStack {

    static class Node {
        private int val;
        private Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node min;

    public MinStack() {

    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val);
            head.val = val;
            min = new Node(val);
        } else {
            Node node = new Node(val);
            node.next = head;
            head = node;
            //比较最小 如果小于等于就入栈
            if (node.val <= min.val) {
                Node newMin = new Node(val);
                newMin.next = min;
                min = newMin;
            }
        }
    }


    public void pop() {
        //出栈比较 如果是相等就移除栈顶
        if (head.val == min.val) {
            min = min.next;
        }
        head = head.next;


    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return min.val;
    }




    public static void main(String[] args) {
//        ["MinStack","push","push","push","getMin","pop","top","getMin"]
//        [[],[-2],[0],[-3],[],[],[],[]]
//
//        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        minStack.getMin();
//        minStack.pop();
//        minStack.top();
//        minStack.getMin();

        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node.next = node2;
        node2.next = node3;

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */