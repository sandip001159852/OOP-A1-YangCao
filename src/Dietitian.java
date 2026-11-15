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
 * Video link: https://scuonline-my.sharepoint.com/personal/y_cao_29_student_scu_edu_au/_layouts/15/stream.aspx?id=%2Fpersonal%2Fy%5Fcao%5F29%5Fstudent%5Fscu%5Fedu%5Fau%2FDocuments%2FYangCao%20oopA1%2Emp4&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJPbmVEcml2ZUZvckJ1c2luZXNzIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXciLCJyZWZlcnJhbFZpZXciOiJNeUZpbGVzTGlua0NvcHkifX0&ga=1&referrer=StreamWebApp%2EWeb&referrerScenario=AddressBarCopied%2Eview%2E4a394ac6%2Dc0bc%2D4409%2Dbbc1%2Dd20032e41f14
 *
 * GenAI declaration: I haven't used any Generative AI tools to complete this assessment.
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
