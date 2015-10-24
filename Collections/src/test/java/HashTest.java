import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 */

/**
 * @author sam
 * 
 */
public class HashTest {

    Logger logger = LoggerFactory.getLogger(HashTest.class);

    @Test
    public void test() {
        HashSet<String> f = new HashSet<String>();
        f.add("hello");
        f.add(null);
        assertEquals(2, f.size());
        assertFalse(f.add(null));
        logger.info("HashSet Can have one null entry");
    }

    @Test
    public void test2() {
        HashSet<String> f = new HashSet<String>();
        f.add("hello");
        f.add("av");
        assertEquals(2, f.size());
        for (Iterator<String> iterator = f.iterator(); iterator.hasNext();) {
            String string = (String) iterator.next();
            logger.debug(string);
        }
        logger.info("HashSet Does not contain duplicate entry");
    }

    @Test
    public void test3() {
        HashMap<String, String> g = new HashMap<String, String>();
        g.put("1", "sumanta");
        g.put("2", null);
        assertEquals(2, g.size());
        g.put(null, "");
        assertEquals(3, g.size());
        Set<String> key = g.keySet();

        for (String string : key) {
            logger.debug(string);
        }

        logger.info("HashMap Can Contain multiple null value");
        logger.info("HashMap Can Contain single null key");
    }

    @Test(expected = NullPointerException.class)
    public void test4() {
        logger.info("HashTable Does not store object with null key");
        Hashtable<String, String> hashtable = new Hashtable<String, String>();
        hashtable.put(null, "");
        assertEquals(0, hashtable.size());
    }

    @Test(expected = NullPointerException.class)
    public void test5() {
        logger.info("HashTable Does not store object with null value");
        Hashtable<String, String> hashtable = new Hashtable<String, String>();
        hashtable.put("1", null);
        assertEquals(1, hashtable.size());
    }

    @Test
    public void test6() {
        Hashtable<String, String> hashtable = new Hashtable<String, String>();
        hashtable.put("1", "hi");
        hashtable.put("1", "hi");
        assertEquals(1, hashtable.size());
        hashtable.put("2", "hi");
        assertEquals(2, hashtable.size());
        logger.info("HashTable Does not allow duplicate key");
    }

    @Test
    public void test7() {
        Hashtable<String, String> hashtable = new Hashtable<String, String>();
        hashtable.put("3", "aa");
        hashtable.put("1", "ff");
        hashtable.put("2", "bb");
        assertEquals(3, hashtable.size());
        Set<String> keys = hashtable.keySet();
        for (Iterator<String> iterator = keys.iterator(); iterator.hasNext();) {
            String string = (String) iterator.next();
            logger.debug(hashtable.get(string));
        }
        logger.info("HashTable Does sorting based on key");
    }

    @Test
    public void testLinkedHashSet() {
        LinkedHashSet<String> hashtable = new LinkedHashSet<String>();
        hashtable.add("aa");
        hashtable.add("ff");
        hashtable.add("bb");
        hashtable.add(null);
        assertEquals(4, hashtable.size());
        for (String string : hashtable) {
            logger.debug(string);
        }
        logger.info("LikedHashSet Does allow one null element");
        logger.info("LikedHashSet Does not allow duplicate element");
        logger.info("LikedHashSet Does not sorting elements");
    }

}
