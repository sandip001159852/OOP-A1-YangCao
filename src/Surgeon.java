import java.util.ArrayList;

/**
 * Surgeon - Part 2 of the assignment.
 *
 * A specialised health professional: a surgeon who performs operations in a
 * particular surgical field. It "is-a" HealthProfessional, inheriting the
 * common fields, and adds its own attributes: the surgical field and the
 * years of experience.
 *
 * GitHub repository: https://github.com/sandip001159852/OOP-A1-YangCao
 * (replace with your actual repository URL before submission)
 */
public class Surgeon extends HealthProfessional {

    /** The surgical field, e.g. Orthopaedics. */
    private String surgicalField;

    /** Years of surgical experience. */
    private int yearsOfExperience;

    /**
     * Creates a Surgeon.
     *
     * @param id                the unique identifier (digits only)
     * @param name              the full name
     * @param workingDays       the fixed working days
     * @param surgicalField     the surgical specialisation field
     * @param yearsOfExperience the years of experience
     */
    public Surgeon(String id, String name, ArrayList<String> workingDays,
            String surgicalField, int yearsOfExperience) {
        super(id, name, workingDays);   // initialise the inherited fields
        this.surgicalField = surgicalField;
        this.yearsOfExperience = yearsOfExperience;
    }

    /**
     * Returns the surgical field of this surgeon.
     *
     * @return the surgical specialisation
     */
    public String getSurgicalField() {
        return surgicalField;
    }

    /**
     * Returns the years of experience of this surgeon.
     *
     * @return the years of experience
     */
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    /**
     * Returns all information about this surgeon, combining the inherited
     * details with the surgeon-specific attributes.
     *
     * @return a string with every field of this surgeon
     */
    @Override
    public String toString() {
        return "Surgeon [ID: " + getId()
                + ", Name: " + getName()
                + ", Working Days: " + getWorkingDays()
                + ", Surgical Field: " + surgicalField
                + ", Years of Experience: " + yearsOfExperience + "]";
    }
}
