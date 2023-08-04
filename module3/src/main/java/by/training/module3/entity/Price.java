package by.training.module3.entity;

public class Price {
    private String currency = "usd";
    private double value = 7;

    public Price() {
      }


    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Price{" +
                "currency='" + currency + '\'' +
                ", value=" + value +
                '}';
    }
}
