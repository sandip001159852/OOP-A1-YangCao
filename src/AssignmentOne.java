import java.util.ArrayList;

/**
 * AssignmentOne - Part 3 and Part 6 of the assignment.
 *
 * The entry point of the medical appointment system. The program is a
 * scripted console demonstration (no GUI, as required):
 *
 *  - Part 3: several objects (3 GPs + other professional types) are created,
 *    stored and processed through a single common type
 *    (ArrayList&lt;HealthProfessional&gt;) to demonstrate polymorphism.
 *  - Part 4/5: appointments are created, added, filtered, sorted, viewed and
 *    cancelled through the AppointmentManager.
 *  - Part 6: a complete end-to-end demonstration with both normal cases and
 *    error cases (duplicate booking, cancelling a non-existent appointment,
 *    illegal time slot), with clear, readable output.
 *
 * Only concepts from Modules 1-3 are used: classes, encapsulation,
 * inheritance, polymorphism, ArrayList, Scanner, toString/equals/hashCode
 * overrides, loops and conditions.
 *
 * GitHub repository: https://github.com/sandip001159852/OOP-A1-YangCao
 * https://github.com/sandip001159852/OOP-A1-YangCao.git
 *
 * Video link: https://scuonline-my.sharepoint.com/personal/y_cao_29_student_scu_edu_au/_layouts/15/stream.aspx?id=%2Fpersonal%2Fy%5Fcao%5F29%5Fstudent%5Fscu%5Fedu%5Fau%2FDocuments%2FYangCao%20oopA1%2Emp4&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJPbmVEcml2ZUZvckJ1c2luZXNzIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXciLCJyZWZlcnJhbFZpZXciOiJNeUZpbGVzTGlua0NvcHkifX0&ga=1&referrer=StreamWebApp%2EWeb&referrerScenario=AddressBarCopied%2Eview%2E4a394ac6%2Dc0bc%2D4409%2Dbbc1%2Dd20032e41f14
 *
 * GenAI declaration: I haven't used any Generative AI tools to complete this assessment.
 */
public class AssignmentOne {

    /**
     * The entry point of the program.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {

        // ============================================================
        // PART 3 - create several objects and process them polymorphically
        // ============================================================
        System.out.println("======================================================");
        System.out.println("PART 3: Health professional objects (polymorphism)");
        System.out.println("======================================================");

        // Build working-day lists for the professionals.
        ArrayList<String> monWedFri = new ArrayList<String>();
        monWedFri.add("Monday");
        monWedFri.add("Wednesday");
        monWedFri.add("Friday");

        ArrayList<String> tueThu = new ArrayList<String>();
        tueThu.add("Tuesday");
        tueThu.add("Thursday");

        ArrayList<String> allWeek = new ArrayList<String>();
        allWeek.add("Monday");
        allWeek.add("Tuesday");
        allWeek.add("Wednesday");
        allWeek.add("Thursday");
        allWeek.add("Friday");

        // Create 3 GPs and 2 other professional types (a specialist and a surgeon).
        GeneralPractitioner gp1 = new GeneralPractitioner("1001", "Dr Alice Lee", monWedFri, 20);
        GeneralPractitioner gp2 = new GeneralPractitioner("1002", "Dr Bob Wang", tueThu, 15);
        GeneralPractitioner gp3 = new GeneralPractitioner("1003", "Dr Carol Tan", monWedFri, 25);
        Specialist spec1 = new Specialist("2001", "Dr David Chen", tueThu, "Cardiology");
        Surgeon surgeon1 = new Surgeon("3001", "Dr Emma Zhao", allWeek, "Orthopaedics", 12);
        Nurse nurse1 = new Nurse("4001", "Nurse Fiona Lim", monWedFri, true);
        Dietitian dietitian1 = new Dietitian("5001", "Grace Koh", tueThu, "Diabetes management");

        // Store all of them in a single common-type collection (polymorphism).
        ArrayList<HealthProfessional> staff = new ArrayList<HealthProfessional>();
        staff.add(gp1);
        staff.add(gp2);
        staff.add(gp3);
        staff.add(spec1);
        staff.add(surgeon1);
        staff.add(nurse1);
        staff.add(dietitian1);

        System.out.println("Clinic staff (" + staff.size() + " professionals):");
        for (HealthProfessional p : staff) {
            System.out.println("  " + p);   // dynamic binding calls the right toString()
        }

        // ============================================================
        // PART 4 & 5 & 6 - appointment system demonstration
        // ============================================================
        System.out.println();
        System.out.println("======================================================");
        System.out.println("PART 6: End-to-end demonstration of the appointment system");
        System.out.println("======================================================");

        AppointmentManager manager = new AppointmentManager();

        // ---------- NORMAL CASE: add several valid appointments ----------
        System.out.println();
        System.out.println("--- Adding valid appointments (normal cases) ---");
        manager.addAppointment("Alice Smith", "0411 000 111", gp1, 0);   // 08:00
        manager.addAppointment("Bob Brown",  "0422 000 222", spec1, 1);  // 08:30
        manager.addAppointment("Carol King", "0433 000 333", gp1, 2);    // 09:00
        manager.addAppointment("Dave Clark", "0444 000 444", surgeon1, 5); // 10:30
        manager.addAppointment("Eve White",  "0455 000 555", gp2, 3);    // 09:30

        // ---------- VIEW ALL (insertion order) ----------
        System.out.println();
        System.out.println("--- View all appointments (insertion order) ---");
        manager.viewAll();

        // ---------- SORT ALL BY TIME ----------
        System.out.println();
        System.out.println("--- All appointments sorted by time ---");
        ArrayList<Appointment> sortedAll = manager.getAll();  // snapshot copy
        manager.sortByTime(sortedAll);
        for (Appointment a : sortedAll) {
            System.out.println("  " + a);
        }

        // ---------- FILTER BY PROFESSIONAL ID ----------
        System.out.println();
        System.out.println("--- Appointments of GP 1001 (Dr Alice Lee) ---");
        ArrayList<Appointment> gp1Bookings = manager.filterById("1001");
        if (gp1Bookings.isEmpty()) {
            System.out.println("  (none)");
        } else {
            for (Appointment a : gp1Bookings) {
                System.out.println("  " + a);
            }
        }

        // ---------- FILTER BY PATIENT MOBILE ----------
        System.out.println();
        System.out.println("--- Appointments of patient 0433 000 333 (Carol King) ---");
        ArrayList<Appointment> carolBookings = manager.filterByMobile("0433 000 333");
        if (carolBookings.isEmpty()) {
            System.out.println("  (none)");
        } else {
            for (Appointment a : carolBookings) {
                System.out.println("  " + a);
            }
        }

        // ---------- FILTER THEN SORT ----------
        System.out.println();
        System.out.println("--- GP 1001 appointments sorted by time ---");
        manager.sortByTime(gp1Bookings);
        for (Appointment a : gp1Bookings) {
            System.out.println("  " + a);
        }

        // ---------- ERROR CASE 1: duplicate booking ----------
        System.out.println();
        System.out.println("--- Error case: duplicate booking (GP 1001 at 08:00 again) ---");
        manager.addAppointment("Fake Patient", "0466 000 666", gp1, 0);

        // ---------- ERROR CASE 2: illegal time slot ----------
        System.out.println();
        System.out.println("--- Error case: illegal time slot (slot 16 = 16:30, after closing) ---");
        manager.addAppointment("Late Patient", "0477 000 777", spec1, 16);

        // ---------- ERROR CASE: empty patient name and blank mobile ----------
        System.out.println();
        System.out.println("--- Error case: empty patient name and blank mobile (should print [FAIL]) ---");
        manager.addAppointment("", "0411 000 111", gp1, 4);          // empty name
        manager.addAppointment("Alice Smith", "   ", spec1, 4);      // blank mobile

        // ---------- NORMAL CASE: cancel by ID + time ----------
        System.out.println();
        System.out.println("--- Cancel Bob Brown's appointment with SP 2001 at 08:30 ---");
        manager.cancelByIdAndTime("2001", 1);

        // ---------- ERROR CASE 3: cancel a non-existent appointment ----------
        System.out.println();
        System.out.println("--- Error case: cancel a non-existent appointment (SP 2001 at 08:30 again) ---");
        manager.cancelByIdAndTime("2001", 1);

        // ---------- NORMAL CASE: cancel by patient mobile ----------
        System.out.println();
        System.out.println("--- Cancel all appointments of patient 0455 000 555 (Eve White) ---");
        manager.cancelByMobile("0455 000 555");

        // ---------- ERROR CASE 4: cancel by unknown mobile ----------
        System.out.println();
        System.out.println("--- Error case: cancel by unknown mobile number 0499 999 999 ---");
        manager.cancelByMobile("0499 999 999");

        // ---------- FINAL STATE ----------
        System.out.println();
        System.out.println("--- Final state of all appointments ---");
        manager.viewAll();

        System.out.println();
        System.out.println("======================================================");
        System.out.println("End of demonstration.");
        System.out.println("======================================================");
    }
}
