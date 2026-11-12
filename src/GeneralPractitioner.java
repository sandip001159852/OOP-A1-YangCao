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
 * (replace with your actual repository URL before submission)
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
     */
    public GeneralPractitioner(String id, String name, ArrayList<String> workingDays,
            int maxPatientsPerDay) {
        super(id, name, workingDays);   // initialise the inherited fields
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
        return "General Practitioner [ID: " + getId()
                + ", Name: " + getName()
                + ", Working Days: " + getWorkingDays()
                + ", Max Patients Per Day: " + maxPatientsPerDay + "]";
    }
}
