package org.silence.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {


    class DLinkedNode {
        private int key;

        private int value;

        private DLinkedNode pre;
        private DLinkedNode next;

    }

    private final int capacity;
    private int size = 0;

    private final Map<Integer, DLinkedNode> cache = new HashMap<>();

    //虚拟  头尾节点
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        // 获取 没有返回-1
        DLinkedNode dLinkedNode = cache.get(key);
        if (dLinkedNode == null) {
            return -1;
        }
        // 存在更新元素到头部
        moveToHead(dLinkedNode);
        return dLinkedNode.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 新增节点到头部
            node = new DLinkedNode();
            node.key = key;
            node.value = value;
            cache.put(key, node);
            //添加到头部节点
            addHead(node);
            //加数量
            ++size;
            // 判断数量是否超过  超过移除尾部节点
            if (size > capacity) {
                //移除未节点
                DLinkedNode removeTail = removeTail();
                //从hash 表中删除
                cache.remove(removeTail.key);
                --size;
            }
        } else {
            // 值更新 可能变化
            node.value = value;
            // 移动节点到头部
            moveToHead(node);
        }

    }

    private void addHead(DLinkedNode node) {
        //当前节点设置头节点
        node.next = head.next;
        node.pre = head;
        head.next = node;
        node.next.pre = node;

    }

    private void removeNode(DLinkedNode node) {
        //摘 节点出来
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private DLinkedNode removeTail() {
        DLinkedNode pre = tail.pre;
        //摘 节点出来
        removeNode(pre);
        return pre;
    }

    private void moveToHead(DLinkedNode node) {
        //摘 节点出来
        removeNode(node);
        //当前节点设置头节点
        addHead(node);
    }


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}