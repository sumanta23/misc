/**
 * 
 */
package org.sumanta.builder;

/**
 * @author sam
 *
 */
public class Car {

    String wheel;
    String engine;
    String steering;

    /**
     * 
     */
    public Car(CarBuilder carBuilder) {
        setEngine(carBuilder.engine);
        setSteering(carBuilder.steering);
        setWheel(carBuilder.wheel);
    }
    
    /**
     * @return the wheel
     */
    public String getWheel() {
        return wheel;
    }



    /**
     * @param wheel the wheel to set
     */
    public void setWheel(String wheel) {
        this.wheel = wheel;
    }



    /**
     * @return the engine
     */
    public String getEngine() {
        return engine;
    }



    /**
     * @param engine the engine to set
     */
    public void setEngine(String engine) {
        this.engine = engine;
    }



    /**
     * @return the steering
     */
    public String getSteering() {
        return steering;
    }



    /**
     * @param steering the steering to set
     */
    public void setSteering(String steering) {
        this.steering = steering;
    }



    @Override
    public String toString() {
        return "Car [wheel=" + wheel + ", engine=" + engine + ", steering=" + steering + "]";
    }
   
}
