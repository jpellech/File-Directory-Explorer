import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import java.util.List;

import org.junit.jupiter.api.Test;

public class MyTreeNodeTest {
    @Test
    void testAddChild() {
        MyTreeNode<Integer> root = new MyTreeNode<>(1);
        MyTreeNode<Integer> child1 = new MyTreeNode<>(2);
        MyTreeNode<Integer> child2 = new MyTreeNode<>(3);

        root.addChild(child1);
        root.addChild(child2);

        // Check that the children were added correctly
        List<MyTreeNode<Integer>> children = root.getChildren();
        assertEquals(2, children.size());
        assertTrue(children.contains(child1));
        assertTrue(children.contains(child2));
    }

    @Test
    void testGetChildren() {
        MyTreeNode<String> root = new MyTreeNode<>("Root");
        MyTreeNode<String> child1 = new MyTreeNode<>("Child1");
        MyTreeNode<String> child2 = new MyTreeNode<>("Child2");

        root.addChild(child1);
        root.addChild(child2);

        // Check if getChildren() returns the correct children
        List<MyTreeNode<String>> children = root.getChildren();
        assertEquals(2, children.size());
        assertTrue(children.contains(child1));
        assertTrue(children.contains(child2));
    }

    @Test
    void testGetItem() {
        MyTreeNode<String> node = new MyTreeNode<>("TestNode");

        // Check if getItem() returns the correct item
        assertEquals("TestNode", node.getItem());
    }

    @Test
    void testGetParent() {
        MyTreeNode<Integer> root = new MyTreeNode<>(1);
        MyTreeNode<Integer> child = new MyTreeNode<>(2);

        root.addChild(child);

        // Check if getParent() returns the correct parent
        assertEquals(root, child.getParent());
    }

    @Test
    void testIsLeaf() {
        MyTreeNode<Integer> leafNode = new MyTreeNode<>(1);
        assertTrue(leafNode.isLeaf());

        MyTreeNode<Integer> parentNode = new MyTreeNode<>(2);
        MyTreeNode<Integer> childNode = new MyTreeNode<>(3);

        parentNode.addChild(childNode);

        assertFalse(parentNode.isLeaf());
    }

    @Test
    void testIsRoot() {
        MyTreeNode<Integer> root = new MyTreeNode<>(1);
        assertTrue(root.isRoot());

        MyTreeNode<Integer> childNode = new MyTreeNode<>(2);
        root.addChild(childNode);

        assertFalse(childNode.isRoot());
    }

    @Test
    void testSize() {
        MyTreeNode<Integer> root = new MyTreeNode<>(1);
        assertEquals(1, root.size());

        MyTreeNode<Integer> child1 = new MyTreeNode<>(2);
        MyTreeNode<Integer> child2 = new MyTreeNode<>(3);

        root.addChild(child1);
        root.addChild(child2);

        assertEquals(3, root.size()); // Root + Child1 + Child2

        MyTreeNode<Integer> grandchild = new MyTreeNode<>(4);
        child1.addChild(grandchild);

        assertEquals(4, root.size()); // Root + Child1 + Child2 + Grandchild

        MyTreeNode<Integer> anotherGrandchild = new MyTreeNode<>(5);
        child1.addChild(anotherGrandchild);

        assertEquals(5, root.size()); // Root + Child1 + Child2 + Grandchild + AnotherGrandchild
    }

    @Test
    void testDepth() {
        MyTreeNode<Integer> root = new MyTreeNode<>(1);
        assertEquals(0, root.depth()); // Root node has depth 0

        MyTreeNode<Integer> child1 = new MyTreeNode<>(2);
        MyTreeNode<Integer> child2 = new MyTreeNode<>(3);

        root.addChild(child1);
        root.addChild(child2);

        assertEquals(1, child1.depth()); // Child1 has depth 1
        assertEquals(1, child2.depth()); // Child2 has depth 1

        MyTreeNode<Integer> grandchild = new MyTreeNode<>(4);
        child1.addChild(grandchild);

        assertEquals(2, grandchild.depth()); // Grandchild has depth 2
    }

    @Test
    void testHeight() {
        MyTreeNode<Integer> root = new MyTreeNode<>(1);

        MyTreeNode<Integer> child1 = new MyTreeNode<>(1);
        MyTreeNode<Integer> child2 = new MyTreeNode<>(1);

        root.addChild(child1);
        root.addChild(child2);

        assertEquals(1, root.height());

        MyTreeNode<Integer> child3 = new MyTreeNode<>(1);
        MyTreeNode<Integer> child4 = new MyTreeNode<>(0);

        child1.addChild(child3);
        child2.addChild(child4);

        assertEquals(2, root.height());
        assertEquals(1, child1.height());
        assertEquals(1, child2.height());

        MyTreeNode<Integer> child5 = new MyTreeNode<>(0);
        child3.addChild(child5);

        assertEquals(3, root.height());
        assertEquals(2, child1.height());
        assertEquals(1, child2.height());
        assertEquals(0, child5.height());
    }

    @Test
    void testContains() {
        MyTreeNode<Integer> root = new MyTreeNode<>(1);
        MyTreeNode<Integer> child1 = new MyTreeNode<>(2);
        MyTreeNode<Integer> child2 = new MyTreeNode<>(3);
        MyTreeNode<Integer> child3 = new MyTreeNode<>(4);

        root.addChild(child1);
        root.addChild(child2);
        child1.addChild(child3);

        // Test contains method
        assertTrue(root.contains(2));
        assertTrue(root.contains(3));
        assertTrue(root.contains(4));
        assertFalse(root.contains(17));  // Root does not contain 17
        assertTrue(child1.contains(2));
        assertTrue(child1.contains(4));
        assertTrue(child2.contains(3));
    }

    @Test
    void testPrint() {
        MyTreeNode<String> root = new MyTreeNode<>("Root");
        MyTreeNode<String> child1 = new MyTreeNode<>("Child 1");
        MyTreeNode<String> child2 = new MyTreeNode<>("Child 2");

        root.addChild(child1);
        root.addChild(child2);

        MyTreeNode<String> grandchild1 = new MyTreeNode<>("Grandchild 1");
        child1.addChild(grandchild1);

        root.print();
    }
}
