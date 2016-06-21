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
    private BigDecimal coinReturnValue = new BigDecimal(0);


    private String specialMessageState = null;

    public VendingMachine() {

    }

    public String getDisplay() {
        if (this.specialMessageState != null) {
            String tempMessage = this.specialMessageState;
            this.specialMessageState = null;
            return tempMessage;
        }

        if (BigDecimal.valueOf(0).compareTo(currentValue) == 0) {
            return INITIAL_MESSAGE;
        }

        return formatBigDecimalAsString(this.currentValue);
    }

    private String formatBigDecimalAsString(BigDecimal input) {
        return NumberFormat.getCurrencyInstance().format(input);
    }

    public void insertCoin(double diameter, double weight) {

        if (checkDiameter(diameter) == checkWeight(weight)) {
            addValue(checkWeight(weight));
        }
    }

    private int checkDiameter(double diameter) {
        // coin weights & sizes from https://www.usmint.gov/about_the_mint/?action=coin_specifications
        if (diameter == 1.0) {
            return CoinConstants.QUARTER;
        } else if (diameter == 0.705) {
            return CoinConstants.DIME;
        } else if (diameter == 0.835) {
            return CoinConstants.NICKEL;
        }
        return CoinConstants.INVALID;
    }

    private int checkWeight(double weight) {
        if (weight == 5.67) {
            return CoinConstants.QUARTER;
        } else if (weight == 2.27) {
            return CoinConstants.DIME;
        } else if (weight == 5.0) {
            return CoinConstants.NICKEL;
        }
        return CoinConstants.INVALID;
    }

    private void addValue(int coinConstant) {

        if (CoinConstants.QUARTER == coinConstant) {
            this.currentValue = this.currentValue.add(BigDecimal.valueOf(0.25));
        } else if (CoinConstants.DIME == coinConstant) {
            this.currentValue = this.currentValue.add(BigDecimal.valueOf(0.10));
        } else if (CoinConstants.NICKEL == coinConstant) {
            this.currentValue = this.currentValue.add(BigDecimal.valueOf(0.05));
        }

    }

    public void selectProduct(String product) {
        BigDecimal priceOfProduct = BigDecimal.valueOf(this.getPriceOfProduct(product));
        if (this.currentValue.compareTo(priceOfProduct) == -1) {
            this.specialMessageState = "PRICE " +
                    formatBigDecimalAsString(priceOfProduct);
        } else {
            this.currentValue = this.currentValue.subtract(priceOfProduct);
            this.specialMessageState = "THANK YOU";
        }
    }

    private double getPriceOfProduct(String product) {
        if (ProductConstants.COLA.equals(product)) {
            return 1.00;
        }
        return 0;
    }

    public void makeChange() {
        this.coinReturnValue = this.currentValue;
        this.currentValue = BigDecimal.valueOf(0);

    }

    public String getCoinReturn() {
        String coinReturnValueString = this.formatBigDecimalAsString(this.coinReturnValue);
        this.coinReturnValue = BigDecimal.valueOf(0);
        return coinReturnValueString;
    }
}
