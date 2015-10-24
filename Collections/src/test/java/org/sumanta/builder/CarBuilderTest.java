/**
 * 
 */
package org.sumanta.builder;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author sam
 *
 */
public class CarBuilderTest {

    @Test
    public void test() {
       Car car=new CarBuilder("v8", "steel", "MRF").build();
       assertEquals(car.toString(), "Car [wheel=MRF, engine=v8, steering=steel]");
    }

}
