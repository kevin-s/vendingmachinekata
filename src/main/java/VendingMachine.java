/**
 * Created with IntelliJ IDEA.
 * User: Kevin
 * Date: 6/20/16
 * Time: 8:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class VendingMachine {

    private String currentDisplay = "INSERT COIN";

    public VendingMachine() {

    }

    public String getDisplay() {
        return currentDisplay;
    }

    public void insertCoin(double diameter, double weight) {
        currentDisplay = "$0.25";
    }
}
