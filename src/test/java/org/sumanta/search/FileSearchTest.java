/**
 * 
 */
package org.sumanta.search;

import static org.junit.Assert.*;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * @author sam
 *
 */
public class FileSearchTest {

    static File Filedir = new File(".");
    static String Filename = "pom.xml";

    @Test
    public void test() throws InterruptedException {
        long t1 = System.currentTimeMillis();
        SearchFile files = new SearchFile(Filedir, Filename);
        files.start();
        files.join();

        Set<String> h = FilePath.getInstance();
        System.out.println("Results:");
        for (String f : h) {
            System.out.println(f);
        }

        long t2 = System.currentTimeMillis();
        System.out.println("millisecs : " + (t2 - t1));
        System.out.println(FilePath.getInstance().size());
    }

}
