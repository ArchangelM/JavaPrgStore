package tanksStore;

import java.util.Date;

public class DayTotalSale {
    private Date date;
    private int numSales;
    private int goodsQuantity;
    private double sum;

    @Override
    public String toString() {
        return "Total at day " + date + " " + numSales+ " " + sum+ " " + goodsQuantity;

   }


    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public int getNumSales() {
        return numSales;
    }

    public void setNumSales(int numSales) {
        this.numSales = numSales;
    }

    public int getGoodsQuantity() {
        return goodsQuantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setGoodsQuantity(int goodsQuantity) {
        this.goodsQuantity = goodsQuantity;
    }
}
