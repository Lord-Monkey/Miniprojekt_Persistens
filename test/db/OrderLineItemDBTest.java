package db;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import model.OrderLineItem;
import model.Product;

public class OrderLineItemDBTest {

    @Test
    void testInsertReturnsTrue() throws DataAccessException {
        // Arrange
        OrderLineItemDB db = new OrderLineItemDB();
        ProductDB pdb = new ProductDB();
        Product p = pdb.findProduct(5);
        OrderLineItem oli = new OrderLineItem(p, 3);
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