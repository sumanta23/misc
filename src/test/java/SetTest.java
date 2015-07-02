import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
public class SetTest {

    
    Logger logger=LoggerFactory.getLogger(SetTest.class);
    
    @Test
    public void test() {
        HashSet<String> f = new HashSet<String>();
        f.add("hello");
        f.add(null);
        assertEquals(2, f.size());
        logger.info("HashSet can have null value");
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
        logger.info("HashSet can not contain duplicate value");
    }
    
    @Test
    public void test3() {
        HashMap<String, String> g=new HashMap<String, String>();
        g.put("1", "sumanta");
        g.put("2", null);
        assertEquals(2, g.size());
        g.put(null, "");
        assertEquals(3, g.size());
        Set<String>  key=g.keySet();
        for (String string:key) {
            logger.debug(string);
        }
    }

}
