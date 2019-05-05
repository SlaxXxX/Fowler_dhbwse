
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slx.dhbw.Customer;
import slx.dhbw.Movie;
import slx.dhbw.Rental;

class TestCustomer {
    private Customer customer;
    private Movie movie1, movie2;
    private Rental rental1, rental2;

    @BeforeEach
    void setUp() {
        customer = new Customer("joe");
        movie1 = new Movie("movie1", 1);
        movie2 = new Movie("movie2", 2);
        rental1 = new Rental(movie1, 10);
        rental2 = new Rental(movie2, 5);

        customer.addRental(rental1);
        customer.addRental(rental2);
    }

    @Test
    void testCustomerMethods() {
        Assertions.assertEquals(customer.getName(), "joe");
    }

    @Test
    void testMovieMethods() {
        Assertions.assertEquals(movie1.getPrice(), 1);
        movie1.setPrice(0);
        Assertions.assertEquals(movie1.getPrice(), 0);
        movie1.setPrice(1);
        Assertions.assertEquals(movie1.getTitle(), "movie1");
    }

    @Test
    void testRentalMethods() {
        Assertions.assertEquals(rental1.getDaysRented(), 10);
        Assertions.assertEquals(rental1.getMovie().getTitle(), "movie1");
    }

    @Test
    void testCompleteStatement() {
        String expected = "slx.dhbw.Rental Record for joe\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tmovie1\t\t10\t30.0\n" +
                "\tmovie2\t\t5\t4.5\n" +
                "Amount owed is 34.5\n" +
                "You earned 3 frequent renter points";
        String result = customer.statement();
        Assertions.assertEquals(expected, result);

    }
}