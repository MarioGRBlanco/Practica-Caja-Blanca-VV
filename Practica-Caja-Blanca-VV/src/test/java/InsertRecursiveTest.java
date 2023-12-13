import static org.junit.jupiter.api.Assertions.*;
import com.bst.BST;
import com.bst.Node;
import com.exceptions.DepthException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/* CONSULTAR DOCUMENTO GRAFOS
7 caminos independientes:
    1. 1-3-5-6-14           -> content > a, HijoDerecho == null, altura == 50.
    2. 1-3-5-7-14           -> content > a, HijoDerecho == null, altura != 50.
    3. 1-3-4-1-3-5-7-14     -> content > a, HijoDerecho != null.
    4. 1-2-9-14             -> content >= a.
    5. 1-2-8-10-1-3-5-7-14  -> content >= a, HijoIzquierdo != null.
    6. 1-2-8-11-13-14       -> content >= a, HijoIzquierdo == null, altura != 50.
    7. 1-2-8-11-12-14       -> content >= a, HijoIzquierdo == null, altura == 50.
 */
public class InsertRecursiveTest {

    BST<Integer> bst;
    BST<Integer> bst1;
    BST<Integer> size50BST;

    BST<Integer> bst2;
    BST<Integer> size50BST2;
    @org.junit.jupiter.api.BeforeEach
    void setUp() throws DepthException {
        bst = new BST<>(33);
        bst1 = new BST<>(33);
        bst1.insert(42, false);
        size50BST  = new BST<>();
        for(int i = 0; i < 50; i++)
        {
            size50BST.insert(i, false);
        }
        bst2 = new BST<>(33);
        bst2.insert(11, false);
        size50BST2 = new BST<>();
        for(int i = 0; i < 50; i++)
        {
            if(i != 49) {
                size50BST2.insert(i, false);
            } else size50BST2.insert(69, false);
        }
    }
    @Test
    void insertRecursiveTest1() throws DepthException {
        Exception e = assertThrows(DepthException.class, () -> size50BST.insert(50, true));
    }
    @Test
    void insertRecursiveTest2() throws DepthException {
        bst.insert(42,true);

        assertEquals(42, bst.getRoot().getRightChild().getContent());
    }
    @Test
    void insertRecursiveTest3() throws DepthException {
        bst1.insert(53,true);

        assertEquals(53, bst1.search(42).getRightChild().getContent());
    }
    @Test
    void insertRecursiveTest4() throws DepthException {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> bst.insert(33, true));
    }
    @Test
    void insertRecursiveTest5() throws DepthException {
        bst2.insert(23,true);

        assertEquals(23, bst2.search(11).getRightChild().getContent());
    }
    @Test
    void insertRecursiveTest6() throws DepthException {
        bst.insert(13,true);

        assertEquals(13, bst.getRoot().getLeftChild().getContent());
    }
    @Test
    void insertRecursiveTest7() throws DepthException {
        Exception e = assertThrows(DepthException.class, () -> size50BST2.insert(67, true));
    }

}
