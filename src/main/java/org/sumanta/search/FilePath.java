/**
 * 
 */
package org.sumanta.search;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sam
 *
 */
public class FilePath {

    static Set<String> filePath;

    private FilePath(){}
    
    public static synchronized Set<String> getInstance() {
        if (filePath == null) {
            filePath = new HashSet<String>();
        }
        return filePath;
    }
}
