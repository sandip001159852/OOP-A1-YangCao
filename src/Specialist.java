import java.util.ArrayList;

/**
 * Specialist - Part 2 of the assignment.
 *
 * A specialised health professional: a specialist doctor who focuses on one
 * medical area (e.g. cardiology, paediatrics, radiology). It "is-a"
 * HealthProfessional, inheriting the common fields, and adds its own
 * attribute: the specialisation field.
 *
 * GitHub repository: https://github.com/sandip001159852/OOP-A1-YangCao
 * https://github.com/sandip001159852/OOP-A1-YangCao.git
 * Video link: https://scuonline-my.sharepoint.com/personal/y_cao_29_student_scu_edu_au/_layouts/15/stream.aspx?id=%2Fpersonal%2Fy%5Fcao%5F29%5Fstudent%5Fscu%5Fedu%5Fau%2FDocuments%2FYangCao%20oopA1%2Emp4&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJPbmVEcml2ZUZvckJ1c2luZXNzIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXciLCJyZWZlcnJhbFZpZXciOiJNeUZpbGVzTGlua0NvcHkifX0&ga=1&referrer=StreamWebApp%2EWeb&referrerScenario=AddressBarCopied%2Eview%2E4a394ac6%2Dc0bc%2D4409%2Dbbc1%2Dd20032e41f14
 *
 * GenAI declaration: I haven't used any Generative AI tools to complete this assessment.
 */
public class Specialist extends HealthProfessional {

    /** The medical field the specialist focuses on, e.g. Cardiology. */
    private String specialisation;

    /**
     * Creates a Specialist.
     *
     * @param id              the unique identifier (digits only)
     * @param name            the full name
     * @param workingDays     the fixed working days
     * @param specialisation  the medical specialisation field
     * @throws IllegalArgumentException if specialisation is blank
     */
    public Specialist(String id, String name, ArrayList<String> workingDays,
            String specialisation) {
        super(id, name, workingDays);   // initialise the inherited fields
        if (specialisation == null || specialisation.trim().isEmpty()) {
            throw new IllegalArgumentException("Specialisation is required.");
        }
        this.specialisation = specialisation;
    }

    /**
     * Returns the specialisation of this specialist.
     *
     * @return the medical field
     */
    public String getSpecialisation() {
        return specialisation;
    }

    /**
     * Returns all information about this specialist, combining the inherited
     * details with the specialist-specific attribute.
     *
     * @return a string with every field of this specialist
     */
    @Override
    public String toString() {
        return "Specialist [" + getBaseDetails()
                + ", Specialisation: " + specialisation + "]";
    }
}
