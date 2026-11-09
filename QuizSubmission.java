class LateSubmissionException extends Exception {
    public LateSubmissionException(String message) {
        super(message);
    }
}

class InvalidScoreException extends Exception {
    public InvalidScoreException(String message) {
        super(message);
    }
}

class QuizSubmission {

    static void submitExam(String studentName, int duration,
                           int[] scores, int maxMarks)
            throws LateSubmissionException, InvalidScoreException {

        System.out.println("[VALIDATING] Student: " + studentName
                + " | Duration: " + duration + " mins");

        if (duration > 60) {
            throw new LateSubmissionException(
                    "Exam submitted at " + duration
                    + " mins. Allowed limit is 60 mins.");
        }

        System.out.println("[VALIDATING] Verifying "
                + scores.length + " question scores "
                + "(Max per question: " + maxMarks + ")...");

        int total = 0;

        for (int score : scores) {
            if (score < 0 || score > maxMarks) {
                throw new InvalidScoreException(
                        "Score " + score
                        + " is invalid. Must be between 0 and "
                        + maxMarks + ".");
            }
            total += score;
        }

        System.out.println("[SUCCESS] Exam submitted successfully for "
                + studentName + "! Total Score: " + total
                + "/" + (scores.length * maxMarks));
    }

    static void testSubmission(String studentName, int duration,
                               int[] scores) {
        try {
            submitExam(studentName, duration, scores, 20);
        } catch (LateSubmissionException |
                 InvalidScoreException e) {
            System.out.println("[ERROR] Submission Rejected: "
                    + e.getClass().getSimpleName()
                    + ": " + e.getMessage());
        } finally {
            System.out.println(
                    "[FINALLY] Session connection closed for student: "
                    + studentName + ".");
        }
    }

    public static void main(String[] args) {

        System.out.println("--- Test Case 1: Valid Quiz Submission ---");
        testSubmission("MCA-101", 48, new int[]{18, 16, 18});

        System.out.println("\n--- Test Case 2: Late Submission ---");
        testSubmission("MCA-102", 72, new int[]{18, 16, 18});

        System.out.println("\n--- Test Case 3: Invalid Score (Score Exceeds Question Maximum) ---");
        testSubmission("MCA-103", 35, new int[]{15, 25, 12});

        System.out.println("\n--- Test Case 4: Invalid Score (Negative Score) ---");
        testSubmission("MCA-104", 40, new int[]{15, -5, 12});
    }
}