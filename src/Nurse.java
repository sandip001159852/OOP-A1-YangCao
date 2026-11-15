import java.util.ArrayList;

/**
 * Nurse - Part 2 of the assignment.
 *
 * A specialised health professional: a nurse who supports patient care and
 * can take blood samples. It "is-a" HealthProfessional, inheriting the
 * common fields, and adds its own attribute: whether the nurse is trained
 * to take blood samples.
 *
 * GitHub repository: https://github.com/sandip001159852/OOP-A1-YangCao
 * https://github.com/sandip001159852/OOP-A1-YangCao.git
 */
public class Nurse extends HealthProfessional {

    /** Whether this nurse is trained to take blood samples. */
    private boolean canTakeBloodSamples;

    /**
     * Creates a Nurse.
     *
     * @param id                  the unique identifier (digits only)
     * @param name                the full name
     * @param workingDays         the fixed working days
     * @param canTakeBloodSamples true if trained to take blood samples
     */
    public Nurse(String id, String name, ArrayList<String> workingDays,
            boolean canTakeBloodSamples) {
        super(id, name, workingDays);   // initialise the inherited fields
        this.canTakeBloodSamples = canTakeBloodSamples;
    }

    /**
     * Returns whether this nurse can take blood samples.
     *
     * @return true if blood-sample trained, false otherwise
     */
    public boolean canTakeBloodSamples() {
        return canTakeBloodSamples;
    }

    /**
     * Returns all information about this nurse, combining the inherited
     * details with the nurse-specific attribute.
     *
     * @return a string with every field of this nurse
     */
    @Override
    public String toString() {
        return "Nurse [" + getBaseDetails()
                + ", Can Take Blood Samples: " + canTakeBloodSamples + "]";
    }
}
