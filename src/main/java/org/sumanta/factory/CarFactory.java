/**
 * 
 */
package org.sumanta.factory;

/**
 * @author sam
 *
 */
public class CarFactory {

    public Car gerCar(CarType ct){
        Car car=null;
        switch (ct){
            case US:
                car=new USCar();
                break;
            case DE:
                car=new DECar();
                break;
            default:
                throw new IllegalArgumentException("Invalid Car Type");
        }
        return car;
        
    }
    
}
