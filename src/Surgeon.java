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
 * https://github.com/sandip001159852/OOP-A1-YangCao.git
 * Video link: https://scuonline-my.sharepoint.com/personal/y_cao_29_student_scu_edu_au/_layouts/15/stream.aspx?id=%2Fpersonal%2Fy%5Fcao%5F29%5Fstudent%5Fscu%5Fedu%5Fau%2FDocuments%2FYangCao%20oopA1%2Emp4&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJPbmVEcml2ZUZvckJ1c2luZXNzIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXciLCJyZWZlcnJhbFZpZXciOiJNeUZpbGVzTGlua0NvcHkifX0&ga=1&referrer=StreamWebApp%2EWeb&referrerScenario=AddressBarCopied%2Eview%2E4a394ac6%2Dc0bc%2D4409%2Dbbc1%2Dd20032e41f14
 *
 * GenAI declaration: I haven't used any Generative AI tools to complete this assessment.
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
     * @throws IllegalArgumentException if surgicalField is blank or
     *         yearsOfExperience is negative
     */
    public Surgeon(String id, String name, ArrayList<String> workingDays,
            String surgicalField, int yearsOfExperience) {
        super(id, name, workingDays);   // initialise the inherited fields
        if (surgicalField == null || surgicalField.trim().isEmpty()) {
            throw new IllegalArgumentException("Surgical field is required.");
        }
        if (yearsOfExperience < 0) {
            throw new IllegalArgumentException("Years of experience must not be negative.");
        }
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
        return "Surgeon [" + getBaseDetails()
                + ", Surgical Field: " + surgicalField
                + ", Years of Experience: " + yearsOfExperience + "]";
    }
}
