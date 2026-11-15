import java.util.ArrayList;
import java.util.Collections;

/**
 * AppointmentManager - Part 5 of the assignment.
 *
 * Manages the collection of appointments of the clinic. An ArrayList is the
 * appropriate data structure covered in Module 2: it keeps the insertion
 * order, supports easy adding/removing/searching and can be sorted with
 * Collections.sort because Appointment implements Comparable.
 *
 * Responsibilities:
 *  - add an appointment (rejecting double bookings and illegal slots)
 *  - view all appointments
 *  - filter appointments by professional ID or by patient mobile number
 *  - sort all (or a filtered subset of) appointments by time
 *  - cancel an appointment by professional ID + time, or by patient mobile
 *  - always give clear feedback on success or failure
 *
 * GitHub repository: https://github.com/sandip001159852/OOP-A1-YangCao
 * https://github.com/sandip001159852/OOP-A1-YangCao.git
 */
public class AppointmentManager {

    /** The collection that stores every appointment of the clinic. */
    private ArrayList<Appointment> appointments;

    /**
     * Creates an empty appointment manager.
     */
    public AppointmentManager() {
        appointments = new ArrayList<Appointment>();
    }

    /**
     * Adds a new appointment to the clinic. The method rejects:
     *  1. an illegal time slot (outside 08:00-16:00 / not a 30-minute slot),
     *  2. a double booking (the same professional at the same slot),
     * and prints a clear success or failure message.
     *
     * @param patientName   the patient's name
     * @param patientMobile the patient's mobile number
     * @param professional  the health professional
     * @param timeSlot      the slot index (0 to TOTAL_SLOTS-1)
     * @return true if the appointment was added, false otherwise
     */
    public boolean addAppointment(String patientName, String patientMobile,
            HealthProfessional professional, int timeSlot) {
        // Reject missing or blank patient details first, with the same [FAIL]
        // feedback as every other failure path (no exception escapes).
        if (patientName == null || patientName.trim().isEmpty()) {
            System.out.println("[FAIL] Patient name is required - appointment not added.");
            return false;
        }
        if (patientMobile == null || patientMobile.trim().isEmpty()) {
            System.out.println("[FAIL] Patient mobile number is required - appointment not added.");
            return false;
        }
        // Reject an illegal mobile format here (same rule as the Appointment
        // constructor), so the failure is reported as [FAIL] instead of an
        // uncaught IllegalArgumentException from the constructor.
        if (!patientMobile.replace(" ", "").matches("\\d{10,12}")) {
            System.out.println("[FAIL] Patient mobile number must be 10-12 digits "
                    + "(spaces allowed) - appointment not added.");
            return false;
        }
        // Reject a missing professional with the same [FAIL] convention.
        if (professional == null) {
            System.out.println("[FAIL] A health professional is required - appointment not added.");
            return false;
        }
        // Reject an illegal time slot first (defensive check).
        if (timeSlot < 0 || timeSlot >= Appointment.TOTAL_SLOTS) {
            System.out.println("[FAIL] Cannot book at slot " + timeSlot
                    + " - the clinic is open 08:00-16:00 in 30-minute slots (0 to "
                    + (Appointment.TOTAL_SLOTS - 1) + ").");
            return false;
        }
        // Reject a double booking: same professional AND same slot.
        for (Appointment a : appointments) {
            if (a.getProfessional().equals(professional) && a.getTimeSlot() == timeSlot) {
                System.out.println("[FAIL] " + professional.getName()
                        + " is already booked at " + Appointment.formatTime(timeSlot)
                        + " - duplicate appointment rejected.");
                return false;
            }
        }
        // All checks passed: create and store the appointment.
        appointments.add(new Appointment(patientName, patientMobile, professional, timeSlot));
        System.out.println("[SUCCESS] Appointment added for " + patientName
                + " with " + professional.getName() + " at " + Appointment.formatTime(timeSlot) + ".");
        return true;
    }

    /**
     * Returns a copy of the whole collection, so a caller can sort a snapshot
     * without changing the internal order kept by the manager.
     *
     * @return a new list containing all appointments
     */
    public ArrayList<Appointment> getAll() {
        return new ArrayList<Appointment>(appointments);
    }

    /**
     * Prints every appointment in the collection (current order).
     */
    public void viewAll() {
        if (appointments.isEmpty()) {
            System.out.println("(No appointments in the system.)");
            return;
        }
        for (Appointment a : appointments) {
            System.out.println("  " + a);
        }
    }

    /**
     * Returns a new list containing only the appointments of the professional
     * with the given ID. The original collection is never modified.
     *
     * @param id the professional ID to filter by
     * @return the filtered list (possibly empty)
     */
    public ArrayList<Appointment> filterById(String id) {
        if (id == null || id.trim().isEmpty()) {
            System.out.println("[WARN] Invalid professional ID - nothing to filter.");
            return new ArrayList<Appointment>();
        }
        ArrayList<Appointment> result = new ArrayList<Appointment>();
        for (Appointment a : appointments) {
            if (a.getProfessional().getId().equals(id)) {
                result.add(a);
            }
        }
        return result;
    }

    /**
     * Returns a new list containing only the appointments whose patient has
     * the given mobile number. The original collection is never modified.
     *
     * @param mobile the patient mobile number to filter by
     * @return the filtered list (possibly empty)
     */
    public ArrayList<Appointment> filterByMobile(String mobile) {
        if (mobile == null || mobile.trim().isEmpty()) {
            System.out.println("[WARN] Invalid patient mobile - nothing to filter.");
            return new ArrayList<Appointment>();
        }
        ArrayList<Appointment> result = new ArrayList<Appointment>();
        for (Appointment a : appointments) {
            if (a.getPatientMobile().equals(mobile)) {
                result.add(a);
            }
        }
        return result;
    }

    /**
     * Sorts a list of appointments by time, earliest first. The list can be
     * the whole collection or a filtered subset returned by filterById /
     * filterByMobile.
     *
     * @param list the list to sort (sorted in place)
     */
    public void sortByTime(ArrayList<Appointment> list) {
        Collections.sort(list);   // uses the Comparable implementation
    }

    /**
     * Cancels the appointment of a given professional at a given time slot.
     * Prints a warning and returns false when no such appointment exists.
     *
     * @param id       the professional ID
     * @param timeSlot the time slot of the appointment to cancel
     * @return true if one appointment was removed, false otherwise
     */
    public boolean cancelByIdAndTime(String id, int timeSlot) {
        for (int i = 0; i < appointments.size(); i++) {
            Appointment a = appointments.get(i);
            if (a.getProfessional().getId().equals(id) && a.getTimeSlot() == timeSlot) {
                appointments.remove(i);
                System.out.println("[SUCCESS] Appointment of " + a.getPatientName()
                        + " with " + a.getProfessional().getName() + " at "
                        + Appointment.formatTime(timeSlot) + " has been cancelled.");
                return true;
            }
        }
        System.out.println("[FAIL] No appointment found for professional ID " + id
                + " at " + Appointment.formatTime(timeSlot) + " - nothing was cancelled.");
        return false;
    }

    /**
     * Cancels every appointment of the patient with the given mobile number.
     * Prints a warning and returns false when no such appointment exists.
     *
     * @param mobile the patient mobile number
     * @return true if at least one appointment was removed, false otherwise
     */
    public boolean cancelByMobile(String mobile) {
        int removed = 0;
        for (int i = appointments.size() - 1; i >= 0; i--) {
            if (appointments.get(i).getPatientMobile().equals(mobile)) {
                appointments.remove(i);
                removed++;
            }
        }
        if (removed == 0) {
            System.out.println("[FAIL] No appointment found for mobile number " + mobile
                    + " - nothing was cancelled.");
            return false;
        }
        System.out.println("[SUCCESS] " + removed + " appointment(s) of patient "
                + mobile + " cancelled.");
        return true;
    }
}
