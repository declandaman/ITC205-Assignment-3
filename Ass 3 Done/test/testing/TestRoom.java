package testing;

import hotel.credit.CreditCard;
import hotel.entities.Booking;
import hotel.entities.Guest;
import hotel.entities.Room;
import hotel.entities.RoomType;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;

/**
 *
 * @author Dec
 */
public class TestRoom {
      
    @Mock Guest guest;    
    Room room;    
    Date bookedArrival;     
    @Mock CreditCard creditCard;
      
    
    List<Booking> bookings;
    
    int roomId = 1;
    RoomType roomType = RoomType.SINGLE;
    int stayLength = 1;
    int numberOfOccupants = 1; 
    long confirmationNumber;
    
    Booking booking;    
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    public TestRoom() {
        booking = new Booking(guest, room, bookedArrival, stayLength, numberOfOccupants, creditCard);
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() throws Exception {

    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    
    @Test
    public void testBooking() {
        Booking actual = room.book(mockGuest, bookedArrival, stayLength, numberOfOccupants, creditCard);
        assertNotNull(actual);
    }
    
    @Test
    public void testCheckinWhenOccupied() {
        room.checkin();
        assertTrue(room.isOccupied());
        
        Executable e = () -> room.checkin();
        Throwable t = assertThrows(RuntimeException.class, e)
                
        assertEquals("Cannot check into occupied room", t.getMessage());
    }
    
    @Test
    public void testCheckoutWhenNotOccupied() {
 
    }

    @Test
    public void testCheckinWhenNotOccupied() {
 
    }
    
    @Test
    public void testCheckoutWhenOccupied() {
        long confirmationNumber = booking.getConfirmationNumber();
        bookings.add(booking);
        room.checkin();
        assertEquals(1, bookings.size());
        assertTrue(room.isOccupied());
        
        room.checkout(booking);
        
        bookings.remove(booking);
        assertTrue(room.isReady());
        assertEquals(0, bookings.size());
    }    
}
