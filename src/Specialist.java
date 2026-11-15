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
