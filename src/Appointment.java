/**
 * Appointment - Part 4 of the assignment.
 *
 * A single appointment that links a patient (name and mobile phone number),
 * a health professional and an appointment time. The clinic opens from
 * 08:00 to 16:00 and every slot lasts 30 minutes, so a day is divided into
 * 16 fixed time slots (slot 0 = 08:00, slot 1 = 08:30, ... slot 15 = 15:30).
 *
 * The time is stored as a slot index (int) instead of a string, which makes
 * chronological ordering simple and correct (Part 4/5 requirement). The
 * class implements Comparable so that a list of appointments can be sorted
 * by time with Collections.sort.
 *
 * The constructor validates every required detail: an appointment only makes
 * sense when patient name, mobile number, professional and a legal slot are
 * all present.
 *
 * GitHub repository: https://github.com/sandip001159852/OOP-A1-YangCao
 * (replace with your actual repository URL before submission)
 */
public class Appointment implements Comparable<Appointment> {

    /** The clinic opening hour: 08:00. */
    private static final int CLINIC_START_HOUR = 8;

    /** The number of minutes in one slot. */
    private static final int SLOT_MINUTES = 30;

    /** Total number of slots from 08:00 to 16:00 (16 half-hours). */
    public static final int TOTAL_SLOTS = 16;

    /** The name of the patient. */
    private String patientName;

    /** The mobile phone number of the patient. */
    private String patientMobile;

    /** The health professional of this appointment. */
    private HealthProfessional professional;

    /** The time slot index: 0 = 08:00, 1 = 08:30, ..., 15 = 15:30. */
    private int timeSlot;

    /**
     * Creates an appointment. Illegal arguments are rejected immediately so
     * that no incomplete appointment can ever exist in the system.
     *
     * @param patientName    the patient's name (must not be empty)
     * @param patientMobile  the patient's mobile phone (must not be empty)
     * @param professional   the health professional (must not be null)
     * @param timeSlot       the slot index between 0 and TOTAL_SLOTS-1
     * @throws IllegalArgumentException when any detail is missing or illegal
     */
    public Appointment(String patientName, String patientMobile,
            HealthProfessional professional, int timeSlot) {
        if (patientName == null || patientName.isEmpty()) {
            throw new IllegalArgumentException("Patient name is required.");
        }
        if (patientMobile == null || patientMobile.isEmpty()) {
            throw new IllegalArgumentException("Patient mobile number is required.");
        }
        if (professional == null) {
            throw new IllegalArgumentException("A health professional is required.");
        }
        if (timeSlot < 0 || timeSlot >= TOTAL_SLOTS) {
            throw new IllegalArgumentException("Time slot must be between 0 and "
                    + (TOTAL_SLOTS - 1) + " (08:00-16:00, 30-minute slots).");
        }
        this.patientName = patientName;
        this.patientMobile = patientMobile;
        this.professional = professional;
        this.timeSlot = timeSlot;
    }

    /**
     * Converts a slot index into a readable clock time, e.g. slot 3 -> 09:30.
     *
     * @param slot the slot index (0 to TOTAL_SLOTS-1)
     * @return the time as a string in the form HH:MM
     */
    public static String formatTime(int slot) {
        int hour = CLINIC_START_HOUR + slot / 2;   // one hour every two slots
        int minute = (slot % 2) * SLOT_MINUTES;    // odd slots are :30
        String hh = (hour < 10) ? "0" + hour : "" + hour;
        String mm = (minute < 10) ? "0" + minute : "" + minute;
        return hh + ":" + mm;
    }

    /**
     * Returns the patient's name.
     *
     * @return the patient name
     */
    public String getPatientName() {
        return patientName;
    }

    /**
     * Returns the patient's mobile phone number.
     *
     * @return the patient mobile number
     */
    public String getPatientMobile() {
        return patientMobile;
    }

    /**
     * Returns the health professional of this appointment.
     *
     * @return the professional
     */
    public HealthProfessional getProfessional() {
        return professional;
    }

    /**
     * Returns the time slot index of this appointment.
     *
     * @return the slot index (0 = 08:00, ..., 15 = 15:30)
     */
    public int getTimeSlot() {
        return timeSlot;
    }

    /**
     * Returns the appointment time as a readable clock time.
     *
     * @return the time in the form HH:MM
     */
    public String getTimeText() {
        return formatTime(timeSlot);
    }

    /**
     * Returns a readable description of the whole appointment: patient name
     * and mobile, professional ID and name, and the appointment time.
     *
     * @return a string with all appointment details
     */
    @Override
    public String toString() {
        return "Appointment [Patient: " + patientName + " (" + patientMobile
                + "), Professional: " + professional.getId() + " " + professional.getName()
                + ", Time: " + formatTime(timeSlot) + "]";
    }

    /**
     * Compares two appointments by their time slot, so earlier appointments
     * come first when a list is sorted.
     *
     * @param other the other appointment to compare with
     * @return negative/zero/positive when this slot is earlier/equal/later
     */
    @Override
    public int compareTo(Appointment other) {
        return this.timeSlot - other.timeSlot;
    }
}
