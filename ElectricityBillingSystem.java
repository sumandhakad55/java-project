
class ElectricityBillingSystem {


    double getBaseConnectionCharge(char connectionType) {

        switch(connectionType) {

            case 'D':
            case 'd':
                return 50.0;

            case 'C':
            case 'c':
                return 150.0;

            case 'T':
            case 't':
                return 500.0;

            default:
                return -1.0;
        }
    }

    double calculateEnergyCharge(int units) {

        double charge = 0;

        if (units <= 100) {

            charge = units * 3.0;

        } else if (units <= 300) {

            charge = (100 * 3.0)
                   + ((units - 100) * 4.5);

        } else {

            charge = (100 * 3.0)
                   + (200 * 4.5)
                   + ((units - 300) * 7.0);
        }

        return charge;
    }


    
    double applyLateFeeAndPenalty(double totalBill, int daysLate) {

        if (daysLate <= 5) {
            return totalBill;
        }

        double penaltyBill = totalBill;

        for (int i = 6; i <= daysLate; i++) {
            penaltyBill = penaltyBill * 1.015;
        }

        
        penaltyBill = Math.round(penaltyBill * 100.0) / 100.0;

        return penaltyBill;
    }


    
    void auditBatchAccounts(int[][] customerData) {

        
        for (int i = 0; i < customerData.length; i++) {

            
            for (int j = 0; j < 1; j++) {

                int unitsConsumed = customerData[i][0];
                int daysLate = customerData[i][1];

                
                if (unitsConsumed < 0) {
                    System.out.println(
                        "Skipping Account " + i + ": Invalid Data"
                    );

                    continue auditLoop;
                }

                
                if (unitsConsumed == 9999) {
                    System.out.println(
                        "Critical Flag Encountered. Halting Batch."
                    );

                    break auditLoop;
                }

                // Calculate energy charge
                double energyCharge =
                    calculateEnergyCharge(unitsConsumed);

                // Base charge
                double baseCharge =
                    getBaseConnectionCharge('D');

                // Total before late fee
                double totalBill =
                    baseCharge + energyCharge;

                // Apply late fee
                double finalAmount =
                    applyLateFeeAndPenalty(totalBill, daysLate);

                System.out.println(
                    "Account " + i + " Total: ₹" + finalAmount
                );
            }
        }
    }


    // Main method
    public static void main(String[] args) {

        ElectricityBillingSystem system =
            new ElectricityBillingSystem();

        int[][] batchData = {
            {150, 0},
            {-25, 2},
            {350, 10},
            {9999, 0},
            {50, 0}
        };

        system.auditBatchAccounts(batchData);
    }
}