import edu.bsu.cs222.finalProject.Cart;
import edu.bsu.cs222.finalProject.Inventory;
import edu.bsu.cs222.finalProject.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import static edu.bsu.cs222.finalProject.Inventory.collectItemsAsArrayList;

public class CartTest {
    final Inventory inventory = new Inventory(collectItemsAsArrayList
            ("walmart"));

    public CartTest() throws IOException {}

    @Test
    public void testCanAddItemToCart() {
        Cart cart = new Cart(new ArrayList<>());
        cart.add(new Item("Apple", 1.89));
        Assertions.assertEquals( 1, cart.getItems().size());
    }

    @Test
    public void testCanAddItemWithLastIndexToCart(){
        Cart cart = new Cart(new ArrayList<>());
        Item itemToCart = inventory.getItems().get(10);
        cart.add(itemToCart);
        Assertions.assertEquals(1, cart.getItems().size());
    }

    @Test
    public void testAdd2orMoreItemsToCart(){
        Cart cart = new Cart(new ArrayList<>());
        cart.add(new Item("Apple", 1.89));
        cart.add(new Item("Ramen", 0.50));
        cart.add(new Item("Water", 1.00));
        Assertions.assertEquals(3, cart.getItems().size());
    }

    @Test
    public void testFindPriceSum() {
        Cart cart = new Cart(new ArrayList<>());
        cart.add(new Item("Apple", 1.90));
        cart.add(new Item("Ramen", 0.50));
        Assertions.assertEquals(2.40, cart.getTotalCost());
    }

    @Test
    public void testCanResetCart() {
        Cart cart = new Cart(new ArrayList<>());
        for (int i = 0; i < 3; i++) {
            cart.add(inventory.getItems().get(0));
        }
        cart = new Cart( new ArrayList <>() );
        Assertions.assertEquals(0, cart.getItems().size());
    }

    @Test
    public void testCanRemoveItemFromCart() {
        Cart cart = new Cart(new ArrayList<>());
        Item itemToCart = new Item("Apple", 1.89);
        cart.add(itemToCart);
        cart.remove(itemToCart);
        Assertions.assertFalse(cart.getItems().contains(itemToCart));
    }

}