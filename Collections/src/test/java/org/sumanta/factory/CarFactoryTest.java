/**
 * 
 */
package org.sumanta.factory;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author sam
 *
 */
public class CarFactoryTest {

    @Test
    public void test() {
        CarFactory carFactory=new CarFactory();
        Car car=carFactory.gerCar(CarType.DE);
        assertEquals(car.toString(),"Car [wheel=Germany, engine=W, steering=wooden]");
    }

}
