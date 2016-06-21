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

        if (checkDiameter(diameter) == checkWeight(weight)) {
            addValue(checkWeight(weight));
        }
    }

    private int checkDiameter(double diameter) {
        if (diameter == 1.0) {
            return CoinConstants.QUARTER;
        } else if (diameter == 0.705) {
            return CoinConstants.DIME;
        }
        return CoinConstants.INVALID;
    }

    private int checkWeight(double weight) {
        if (weight == 5.67) {
            return CoinConstants.QUARTER;
        } else if (weight == 2.27) {
            return CoinConstants.DIME;
        }
        return CoinConstants.INVALID;
    }

    private void addValue(int coinConstant) {

        if (CoinConstants.QUARTER == coinConstant) {
            this.currentValue = this.currentValue.add(BigDecimal.valueOf(0.25));
        } else if (CoinConstants.DIME == coinConstant) {
            this.currentValue = this.currentValue.add(BigDecimal.valueOf(0.10));
        }

    }
}
