import java.util.ArrayList;

/**
 * Dietitian - Part 2 of the assignment.
 *
 * A specialised health professional: a dietitian who provides nutrition
 * advice. It "is-a" HealthProfessional, inheriting the common fields, and
 * adds its own attribute: the area of nutrition expertise.
 *
 * GitHub repository: https://github.com/sandip001159852/OOP-A1-YangCao
 * https://github.com/sandip001159852/OOP-A1-YangCao.git
 */
public class Dietitian extends HealthProfessional {

    /** The nutrition focus area, e.g. Diabetes management. */
    private String nutritionFocus;

    /**
     * Creates a Dietitian.
     *
     * @param id             the unique identifier (digits only)
     * @param name           the full name
     * @param workingDays    the fixed working days
     * @param nutritionFocus the nutrition expertise area
     * @throws IllegalArgumentException if nutritionFocus is blank
     */
    public Dietitian(String id, String name, ArrayList<String> workingDays,
            String nutritionFocus) {
        super(id, name, workingDays);   // initialise the inherited fields
        if (nutritionFocus == null || nutritionFocus.trim().isEmpty()) {
            throw new IllegalArgumentException("Nutrition focus is required.");
        }
        this.nutritionFocus = nutritionFocus;
    }

    /**
     * Returns the nutrition focus of this dietitian.
     *
     * @return the nutrition expertise area
     */
    public String getNutritionFocus() {
        return nutritionFocus;
    }

    /**
     * Returns all information about this dietitian, combining the inherited
     * details with the dietitian-specific attribute.
     *
     * @return a string with every field of this dietitian
     */
    @Override
    public String toString() {
        return "Dietitian [" + getBaseDetails()
                + ", Nutrition Focus: " + nutritionFocus + "]";
    }
}
