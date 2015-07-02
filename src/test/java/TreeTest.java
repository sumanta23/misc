import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TreeTest {

    Logger logger = LoggerFactory.getLogger(TreeTest.class);

    @Test(expected = NullPointerException.class)
    public void test() {
        logger.info("TreeSet does not allow null entry");
        TreeSet<String> set = new TreeSet<String>();
        set.add(null);
        assertEquals(1, set.size());
    }

    @Test
    public void testDuplicate() {
        TreeSet<String> set = new TreeSet<String>();
        set.add("hi");
        set.add("hi");
        assertEquals(1, set.size());
        logger.info("TreeSet does not allow duplicate entry");
    }

    @Test
    public void testSorted() {
        TreeSet<String> set = new TreeSet<String>();
        set.add("aaa");
        set.add("ccc");
        set.add("bbb");
        assertEquals(3, set.size());
        for (Iterator iterator = set.iterator(); iterator.hasNext();) {
            String string = (String) iterator.next();
            logger.debug(string);
        }
        logger.info("TreeSet does sorting of entries");
    }

    @Test
    public void testTreeMapSorted() {
        TreeMap<String, String> set = new TreeMap<String, String>();
        set.put("1", "aaa");
        set.put("6", "we");
        set.put("4", "rty");
        assertEquals(3, set.size());
        Set<String> strings = set.keySet();
        for (String string : strings) {
            logger.debug(set.get(string));
        }
        logger.info("TreeMap does soring based on value");
    }

}
