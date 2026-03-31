public class Policy {
    private String policyNumber;
    private String clientName;
    private double basePremium;
    private int riskLevel;
    private double vehicleValue;
    private boolean hasAlarm;
    private boolean claimFreeClient;

    private static int createdPolicyCount = 0;
    private static final double ADMINISTRATIVE_FEE = 100.0;

    public Policy(String policyNumber, String clientName, double basePremium,
                  int riskLevel, double vehicleValue, boolean hasAlarm, boolean claimFreeClient) {
        this.policyNumber = policyNumber;
        this.clientName = clientName;
        this.basePremium = basePremium;
        this.riskLevel = riskLevel;
        this.vehicleValue = vehicleValue;
        this.hasAlarm = hasAlarm;
        this.claimFreeClient = claimFreeClient;
        createdPolicyCount++;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public double getBasePremium() {
        return basePremium;
    }

    public int getRiskLevel() {
        return riskLevel;
    }

    public double getVehicleValue() {
        return vehicleValue;
    }

    public boolean hasAlarm() {
        return hasAlarm;
    }

    public boolean isClaimFreeClient() {
        return claimFreeClient;
    }

    public double calculateFinalPremium() {
        double result = basePremium + ADMINISTRATIVE_FEE;

        result += riskLevel * 120;

        if (vehicleValue > 60000) {
            result += 200;
        }

        if (hasAlarm) {
            result -= 100;
        }

        if (claimFreeClient) {
            result *= 0.90;
        }

        if (result < basePremium) {
            result = basePremium;
        }

        return Math.round(result * 100.0) / 100.0;
    }

    public double calculateRenewalPremium() {
        double currentFinal = calculateFinalPremium();
        double renewal = currentFinal;

        if (riskLevel == 4) {
            renewal *= 1.10;
        } else if (riskLevel >= 5) {
            renewal *= 1.20;
        }

        if (vehicleValue > 60000) {
            renewal += 150;
        }

        if (claimFreeClient) {
            renewal *= 0.92;
        }

        if (hasAlarm) {
            renewal *= 0.95;
        }

        double minLimit = currentFinal * 0.90;
        double maxLimit = currentFinal * 1.25;

        if (renewal < minLimit) {
            renewal = minLimit;
        }

        if (renewal > maxLimit) {
            renewal = maxLimit;
        }

        return Math.round(renewal * 100.0) / 100.0;
    }

    public String getRiskSummary() {
        return "Policy " + policyNumber +
                " | Client: " + clientName +
                " | Risk level: " + riskLevel +
                " | Final premium: " + calculateFinalPremium();
    }

    public static int getCreatedPolicyCount() {
        return createdPolicyCount;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", clientName='" + clientName + '\'' +
                ", basePremium=" + basePremium +
                ", riskLevel=" + riskLevel +
                ", vehicleValue=" + vehicleValue +
                ", hasAlarm=" + hasAlarm +
                ", claimFreeClient=" + claimFreeClient +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Policy other = (Policy) obj;
        return policyNumber.equals(other.policyNumber);
    }

    @Override
    public int hashCode() {
        return policyNumber.hashCode();
    }
}