package info.kupczynski.effectivejava.ch2.item1;

/*
 * Consider static factory method instead of constructors
 */

import java.math.BigInteger;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class StaticFactory {

    public static void main(String[] args) throws SQLException {
        // Class can provide a public `static factory method'
        // It is a method which returns class instance, e.g.
        Boolean.valueOf(true);

        // This is not the `Factory Method' Pattern

        /*
         * Advantages (of static factory methods vs constructors)
         */

        // 1. They have names
        new BigInteger(100, 5, new Random());
        // vs
        BigInteger.probablePrime(0, new Random());


        // 2. Not required to create new objects
        Boolean.valueOf(true); // --> Boolean.TRUE


        // 3. Can return subtype
        Collections.emptyList();

        // interface `Collection', helper class `Collections'
        // java 8 --> public static methods in interfaces
        // java 9 --> private static methods in interfaces


        // 4. Class can vary depending on the parameter
        EnumSet<Weekdays> flags = EnumSet.of(Weekdays.MON, Weekdays.WED);

        // --> RegularEnumSet (backed by long)  // up till 64 items
        // --> JumboEnumSet                     // otherwise


        // 5. Class of the returning object may not exist when the `static factory method' is written
        // JDBC is a common example
        DriverManager.getConnection("connection string", "username", "password");


        /*
         * Disadvantages
         */

        // 1. Class without public or protected constructors can't be subclassed
        // but this maybe a blessing in disguise as we prefer composition over inheritance

        // 2. Static factories are harder to find in the documentation


        /*
         * Common names:
         *
         * - from
         * - of
         * - valueOf
         * - instance, getInstance
         * - create, newInstance
         * - getTYPE
         * - newTYPE
         * - TYPE
         */
    }

    private static enum Weekdays {
        MON, TUE, WED;
    }
}

