import java.util.ArrayList;

/**
 * GeneralPractitioner - Part 2 of the assignment.
 *
 * A specialised health professional: a General Practitioner (GP). It
 * "is-a" HealthProfessional, so it inherits the ID, name and working days,
 * and additionally keeps its own attribute: the maximum number of patients
 * the GP can see per day.
 *
 * GitHub repository: https://github.com/sandip001159852/OOP-A1-YangCao
 * https://github.com/sandip001159852/OOP-A1-YangCao.git
 * Video link: https://scuonline-my.sharepoint.com/personal/y_cao_29_student_scu_edu_au/_layouts/15/stream.aspx?id=%2Fpersonal%2Fy%5Fcao%5F29%5Fstudent%5Fscu%5Fedu%5Fau%2FDocuments%2FYangCao%20oopA1%2Emp4&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJPbmVEcml2ZUZvckJ1c2luZXNzIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXciLCJyZWZlcnJhbFZpZXciOiJNeUZpbGVzTGlua0NvcHkifX0&ga=1&referrer=StreamWebApp%2EWeb&referrerScenario=AddressBarCopied%2Eview%2E4a394ac6%2Dc0bc%2D4409%2Dbbc1%2Dd20032e41f14
 *
 * GenAI declaration: I haven't used any Generative AI tools to complete this assessment.
 */
public class GeneralPractitioner extends HealthProfessional {

    /** Maximum number of patients the GP can see in one day. */
    private int maxPatientsPerDay;

    /**
     * Creates a General Practitioner.
     *
     * @param id                the unique identifier (digits only)
     * @param name              the full name
     * @param workingDays       the fixed working days
     * @param maxPatientsPerDay the maximum patients per day
     * @throws IllegalArgumentException if maxPatientsPerDay is not positive
     */
    public GeneralPractitioner(String id, String name, ArrayList<String> workingDays,
            int maxPatientsPerDay) {
        super(id, name, workingDays);   // initialise the inherited fields
        if (maxPatientsPerDay <= 0) {
            throw new IllegalArgumentException("Max patients per day must be positive.");
        }
        this.maxPatientsPerDay = maxPatientsPerDay;
    }

    /**
     * Returns the maximum number of patients the GP can see per day.
     *
     * @return the daily patient limit
     */
    public int getMaxPatientsPerDay() {
        return maxPatientsPerDay;
    }

    /**
     * Returns all information about this GP, including the inherited details
     * and the GP-specific attribute. Dynamic binding makes the JVM call this
     * version when the object is handled through a HealthProfessional
     * reference.
     *
     * @return a string with every field of this GP
     */
    @Override
    public String toString() {
        return "General Practitioner [" + getBaseDetails()
                + ", Max Patients Per Day: " + maxPatientsPerDay + "]";
    }
}
