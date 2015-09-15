/**
 * 
 */
package org.sumanta.factory;

/**
 * @author sam
 *
 */
public abstract class Car {

    String wheel;
    String engine;
    String steering;

    @Override
    public String toString() {
        return "Car [wheel=" + wheel + ", engine=" + engine + ", steering=" + steering + "]";
    }
   
    
    
}
