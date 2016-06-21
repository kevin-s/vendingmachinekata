import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * Created with IntelliJ IDEA.
 * User: Kevin
 * Date: 6/20/16
 * Time: 8:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class VendingMachine {

    private static String INITIAL_MESSAGE = "INSERT COIN";
    private BigDecimal currentValue = new BigDecimal(0);

    public VendingMachine() {

    }

    public String getDisplay() {
        if (new BigDecimal(0).equals(currentValue)) {
            return INITIAL_MESSAGE;
        }

        return NumberFormat.getCurrencyInstance().format(this.currentValue);
    }

    public void insertCoin(double diameter, double weight) {
        currentValue = currentValue.add(BigDecimal.valueOf(0.25));
    }
}
