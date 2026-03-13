package db;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

import model.OrderLineItem;
import model.Clothing;

public class OrderLineItemDBTest {

    @Test
    void testInsertReturnsTrue() throws DataAccessException {
        // Arrange
        OrderLineItemDB db = new OrderLineItemDB();
        Clothing ct = new Clothing(); 
        ct.setColour("Blue");
        ct.setSize("M");
        ct.setProductNumber(5);
        ct.setName("Blue shirt");
        ct.setMinStock(10);
        ct.setReserveQty(5);
        ct.setPtEnum(model.ProductTypeEnum.CLOTHING);
        OrderLineItem oli = new OrderLineItem(ct, 3);
        int orderNo = 1;

        // Act
        boolean result = db.insert(oli, orderNo);

        // Assert
        assertTrue(result);
    }

    @Test
    void testFindOrderLinesByOrderNoReturnsList() throws DataAccessException {
        // Arrange
        OrderLineItemDB db = new OrderLineItemDB();
        int orderNo = 1;

        // Act
        List<OrderLineItem> result = db.findOrderLinesByOrderNo(orderNo);

        // Assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    void testFindOrderLinesByOrderNoReturnsEmptyListForUnknownOrder() throws DataAccessException {
        // Arrange
        OrderLineItemDB db = new OrderLineItemDB();

        // Use an order number that does NOT exist
        int orderNo = -9999;

        // Act
        List<OrderLineItem> result = db.findOrderLinesByOrderNo(orderNo);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}