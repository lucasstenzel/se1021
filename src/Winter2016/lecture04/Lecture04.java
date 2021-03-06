package Winter2016.lecture04;
/**
 * SE1021 – 031 & 032
 * Winter 2016
 * Lecture 04 - Inheritance, Aggregation, & Composition
 * Name: Brad Dennis, Ph.D.
 * Created: 12/6/2015
 */
import java.util.ArrayList;
import java.util.List;

/**
 * Class container for Lecture 04 demonstrations.
 */
public class Lecture04 {

    public static void main(String[] args) {
        //Person aPerson = new Person("Jane Doe");
        //System.out.println(aPerson.toString());

        Faculty drDennis = new Faculty("Brad Dennis", "Assistant Professor");
        System.out.println(drDennis.toString());

        //Faculty drYoder = new Faculty("Yoder");

        Person drBradley = new Faculty("Brad Dennis", "");


        //Ex. 1 Implement student. Submit it here:
        //http://goo.gl/forms/F0X3RZWopl

        List<Faculty> eecs = new ArrayList<>();
        eecs.add(drDennis);

        List<Person> msoePeople = new ArrayList<>();
        msoePeople.add(drDennis);

        //Ex. 2 These are great examples of aggregates.  But what about
        //composites?  How would we implement course?


    }
}
