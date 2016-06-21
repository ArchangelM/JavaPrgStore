package tankstore;

import static org.junit.Assert.*;
import static tanksStore.utils.WorkWithSales.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import tanksStore.serviceClasses.Sale;

import java.util.ArrayList;
import java.util.List;

public class TankStoreTest {
    List<Sale> sales;
    Sale cur;

    @Before
    public void init() {
        sales = new ArrayList<>();
        cur = new Sale();
    }

    @Test
    public void test5PercentSale() {
        cur.setPercent(5f);
        cur.setSum(50d);
        addSale(sales, cur);
        assertEquals("Should be Equvivalent", cur, sales.get(0));
    }

    @Test
    public void test10PercentSale() {
        cur.setPercent(10f);
        cur.setSum(1000d);
        addSale(sales, cur);
        assertEquals("Should be Equvivalent", cur, sales.get(0));
    }

    @Test
    public void testSaleZero() {
        cur.setPercent(5f);
        cur.setSum(50d);
        addSale(sales, cur);
        cur = new Sale();
        cur.setPercent(10f);
        cur.setSum(1000d);
        addSale(sales, cur);

        assertEquals(0.0d, getSaleQuantity(sales, 20), 0.001d);
    }

    @Test
    public void testSale5Percent() {
        cur.setPercent(5f);
        cur.setSum(50d);
        addSale(sales, cur);
        cur = new Sale();
        cur.setPercent(10f);
        cur.setSum(1000d);
        addSale(sales, cur);

        assertEquals(5d, getSaleQuantity(sales, 100), 0.001d);
    }

    @Test
    public void testSale10Percent() {
        cur.setPercent(5f);
        cur.setSum(50d);
        addSale(sales, cur);
        cur = new Sale();
        cur.setPercent(10f);
        cur.setSum(1000d);
        addSale(sales, cur);

        assertEquals(101d, getSaleQuantity(sales, 1010), 0.001d);
    }
}
