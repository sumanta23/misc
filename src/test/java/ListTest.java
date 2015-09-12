import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author sam
 *
 */
public class ListTest {

    Logger logger = LoggerFactory.getLogger(ListTest.class);

    @Test
    public void testArrayList() {
        ArrayList<String> f = new ArrayList<String>();
        f.add("hello");
        f.add(null);
        f.add(null);
        assertEquals(3, f.size());
        logger.info("ArrayList Can have more than one null entry");
        logger.info("ArrayList Can have duplicate entry");
    }

    @Test
    public void testLinkedList() {
        LinkedList<String> f = new LinkedList<>();
        f.add("sumanta");
        f.add(null);
        f.add(null);
        assertEquals(3, f.size());
        for (String string : f) {
            logger.debug(string);
        }
        logger.info("LinkedList Can have more than one null entry");
        logger.info("LinkedList Can have duplicate entry");
    }

    @Test
    public void testVector() {
        Vector<String> vector = new Vector<>();
        vector.add("sumantha");
        vector.add(null);
        vector.add(null);
        vector.add("sumanta");
        assertEquals(4, vector.size());
        for (String string : vector) {
            logger.debug(string);
        }
        logger.info("vector can have multiple null entries");
        logger.info("vector does not sort elements");
    }
}
