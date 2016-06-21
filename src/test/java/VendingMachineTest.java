
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

    @Test
    public void testQuarter() {
        VendingMachine machine = new VendingMachine();
        machine.insertCoin(1.0, 5.67);

        assertEquals("$0.25", machine.getDisplay());
    }

    @Test
    public void testTwoQuarters() {
        VendingMachine machine = new VendingMachine();
        machine.insertCoin(1.0, 5.67);
        machine.insertCoin(1.0, 5.67);

        assertEquals("$0.50", machine.getDisplay());
    }
}
