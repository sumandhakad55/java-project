class PatientRecord {

    private static int patientCount = 0;

    public static final double STANDARD_ROOM_TARIFF = 2500.0;

    private final int admissionToken;

    private String name;
    private int age;
    private int stayDays;

    public PatientRecord(String name, int age, int stayDays) {

        patientCount++;

        admissionToken = 5000 + patientCount;

        this.name = name;
        this.age = age;
        this.stayDays = stayDays;
    }

    public double calculateBill() {
        return STANDARD_ROOM_TARIFF * stayDays;
    }

    public final void displayProfile() {

        System.out.println(
            "Token: #" + admissionToken +
            " | Patient: " + name +
            " (" + age + " yrs)" +
            " | Stay: " + stayDays +
            " days" +
            " | Total Liability: ₹" + calculateBill()
        );
    }

    public static int getPatientCount() {
        return patientCount;
    }

    
}


class ICUPatientRecord extends PatientRecord {

    private static final double LIFE_SUPPORT_SURCHARGE = 5000.0;
    private static final double MONITORING_SURCHARGE = 3000.0;

    public ICUPatientRecord(
            String name,
            int age,
            int stayDays) {

        super(name, age, stayDays);
    }

    @Override
    public double calculateBill() {

        return (STANDARD_ROOM_TARIFF
                + LIFE_SUPPORT_SURCHARGE
                + MONITORING_SURCHARGE) * getStayDays();
    }

    private int getStayDays() {
        try {
            java.lang.reflect.Field field =
                PatientRecord.class.getDeclaredField("stayDays");

            field.setAccessible(true);

            return field.getInt(this);

        } catch (Exception e) {
            return 0;
        }
    }
}


public class HospitalDemo {

    public static void main(String[] args) {

        PatientRecord[] patients = {

            new PatientRecord(
                "Dhakad",
                45,
                4
            ),

            new ICUPatientRecord(
                "Nikk",
                62,
                5
            ),

            new PatientRecord(
                "Kajal",
                29,
                2
            )
        };

        System.out.println(
            "--- Hospital Billing & Intake Ledger ---"
        );

        for (PatientRecord patient : patients) {
            patient.displayProfile();
        }

        System.out.println(
            "Total Registered Intake (Tracked via static): " +
            PatientRecord.getPatientCount()
        );
    }
}