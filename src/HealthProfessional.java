import java.util.ArrayList;
import java.util.Objects;

/**
 * HealthProfessional - Part 1 of the assignment.
 *
 * A general (base) class that captures the common information shared by every
 * health professional in the clinic: an ID, a name and a fixed set of working
 * days. The class follows the Encapsulation pillar of OOP: all fields are
 * private and are exposed through read-only getters (no setters), so external
 * code can READ but never MODIFY a professional's details.
 *
 * Design notes:
 *  - The ID is unique and is used in equals()/hashCode() so that the system
 *    can decide whether two references actually point to the same person
 *    (required by Part 5 to reject double bookings).
 *  - getWorkingDays() returns a defensive copy so the caller cannot change
 *    the internal collection.
 *
 * GitHub repository: https://github.com/sandip001159852/OOP-A1-YangCao
 * (replace with your actual repository URL before submission)
 */
public class HealthProfessional {

    /** The unique identifier of the professional (digits only). */
    private String id;

    /** The full name of the professional. */
    private String name;

    /** The fixed working days, e.g. Monday, Wednesday, Friday. */
    private ArrayList<String> workingDays;

    /**
     * Creates a health professional with the given details.
     *
     * @param id          the unique identifier (digits only)
     * @param name        the full name
     * @param workingDays the fixed set of working days
     */
    public HealthProfessional(String id, String name, ArrayList<String> workingDays) {
        this.id = id;
        this.name = name;
        // Copy the list instead of keeping the caller's reference, so the
        // internal state cannot be changed from outside (encapsulation).
        this.workingDays = new ArrayList<String>(workingDays);
    }

    /**
     * Returns the identifier of the professional.
     *
     * @return the unique identifier
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the name of the professional.
     *
     * @return the full name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a defensive copy of the working days. The caller may read the
     * returned list, but any change made to it will not affect this object.
     *
     * @return a copy of the working-days list
     */
    public ArrayList<String> getWorkingDays() {
        return new ArrayList<String>(workingDays);
    }

    /**
     * Returns a human-readable description containing all information about
     * this professional.
     *
     * @return a string with ID, name and working days
     */
    @Override
    public String toString() {
        return "Health Professional [ID: " + id + ", Name: " + name
                + ", Working Days: " + workingDays + "]";
    }

    /**
     * Two professionals are considered equal when they have the same ID.
     * This is the business rule used by the appointment manager to prevent a
     * professional from being double-booked at the same time.
     *
     * @param o the object to compare with
     * @return true if the other object is a health professional with the same ID
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;                      // same object reference
        }
        if (o == null || !(o instanceof HealthProfessional)) {
            return false;                     // not a professional at all
        }
        HealthProfessional that = (HealthProfessional) o;
        return id.equals(that.id);            // ID is the unique key
    }

    /**
     * Returns a hash code consistent with equals() (same ID -> same hash).
     *
     * @return hash code based on the ID
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
