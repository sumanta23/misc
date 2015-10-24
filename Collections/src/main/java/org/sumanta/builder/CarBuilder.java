/**
 * 
 */
package org.sumanta.builder;

/**
 * @author sam
 *
 */
public class CarBuilder {

    String wheel;
    String engine;
    String steering;

    /**
     * 
     */
    public CarBuilder(String engine,String steering,String wheel) {
        this.wheel=wheel;
        this.steering=steering;
        this.engine=engine;
    }
    
    public Car build(){
        return new Car(this);
    }
    
}
