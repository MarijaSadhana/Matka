package mk.test.matka_v2.model;

import java.util.ArrayList;

public class ExponentResponse {
    private int numberOfItems;
    private ArrayList<Exponent> exponents;

    public ExponentResponse(){}

    public ExponentResponse(int numberOfItems, ArrayList<Exponent> exponents){
        this.numberOfItems = numberOfItems;
        this.exponents = exponents;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public ArrayList<Exponent> getExponents() {
        return exponents;
    }

    public void setExponents(ArrayList<Exponent> exponents) {
        this.exponents = exponents;
    }
}
