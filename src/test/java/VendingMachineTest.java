
/**
 * Created with IntelliJ IDEA.
 * User: Kevin
 * Date: 6/20/16
 * Time: 8:47 PM
 * To change this template use File | Settings | File Templates.
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VendingMachineTest {

    @Test
    public void testMachineStartup() {

        VendingMachine machine = new VendingMachine();

        assertEquals("INSERT COIN", machine.getDisplay());
    }
}