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
 * https://github.com/sandip001159852/OOP-A1-YangCao.git
 * Video link: https://scuonline-my.sharepoint.com/personal/y_cao_29_student_scu_edu_au/_layouts/15/stream.aspx?id=%2Fpersonal%2Fy%5Fcao%5F29%5Fstudent%5Fscu%5Fedu%5Fau%2FDocuments%2FYangCao%20oopA1%2Emp4&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJPbmVEcml2ZUZvckJ1c2luZXNzIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXciLCJyZWZlcnJhbFZpZXciOiJNeUZpbGVzTGlua0NvcHkifX0&ga=1&referrer=StreamWebApp%2EWeb&referrerScenario=AddressBarCopied%2Eview%2E4a394ac6%2Dc0bc%2D4409%2Dbbc1%2Dd20032e41f14
 *
 * GenAI declaration: I haven't used any Generative AI tools to complete this assessment.
 *
 * Design decision: this class is abstract, so it cannot be instantiated as a
 * plain "no-type" professional; subclasses must provide the concrete type.
 */
public abstract class HealthProfessional {

    /** The unique identifier of the professional (digits only). */
    private String id;

    /** The full name of the professional. */
    private String name;

    /** The fixed working days, e.g. Monday, Wednesday, Friday. */
    private ArrayList<String> workingDays;

    /**
     * Creates a health professional with default values: ID "000", name
     * "Unknown" and one default working day (Monday).
     */
    public HealthProfessional() {
        this("000", "Unknown", new ArrayList<String>(java.util.Arrays.asList("Monday")));
    }

    /**
     * Creates a health professional with the given details.
     *
     * @param id          the unique identifier (digits only)
     * @param name        the full name
     * @param workingDays the fixed set of working days (must not be empty)
     * @throws IllegalArgumentException if the ID is not digits only, the name
     *         is blank, or the working-days list is null or empty
     */
    public HealthProfessional(String id, String name, ArrayList<String> workingDays) {
        if (id == null || !id.matches("\\d+")) {
            throw new IllegalArgumentException("ID must contain digits only.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name is required.");
        }
        if (workingDays == null || workingDays.isEmpty()) {
            throw new IllegalArgumentException("Working days must not be empty.");
        }
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
     * Returns the common details prefix shared by all subclasses, so each
     * subclass can build its own description without repeating the ID, name
     * and working-days part.
     *
     * @return the common prefix, e.g. "ID: 1001, Name: Dr Lee, Working Days: [Monday, ...]"
     */
    protected String getBaseDetails() {
        return "ID: " + id + ", Name: " + name + ", Working Days: " + workingDays;
    }

    /**
     * Returns a human-readable description containing all information about
     * this professional.
     *
     * @return a string with ID, name and working days
     */
    @Override
    public String toString() {
        return "Health Professional [" + getBaseDetails() + "]";
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
