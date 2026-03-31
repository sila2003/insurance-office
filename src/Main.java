public class Main {
    public static void main(String[] args) {
        InsuranceOffice office = new InsuranceOffice("Secure Future");

        Policy p1 = new Policy("CAR-101", "Anna Nowak", 900.0, 3, 72000.0, true, true);
        Policy p2 = new Policy("CAR-102", "Piotr Lis", 840.0, 4, 54000.0, false, false);
        Policy p3 = new Policy("CAR-103", "Karolina Maj", 780.0, 2, 46000.0, true, false);
        Policy p4 = new Policy("CAR-101", "Different Client", 700.0, 1, 30000.0, false, false);

        office.addPolicy(p1);
        office.addPolicy(p2);
        office.addPolicy(p3);
        office.addPolicy(p4); // duplicate by policyNumber, should not be added

        office.printReport();

        System.out.println("Total premium: " + office.calculateTotalPremium());
        System.out.println("Total renewal forecast: " + office.calculateTotalRenewalForecast());
        System.out.println("High-risk policies: " + office.countHighRiskPolicies());
        System.out.println("Created policy count: " + Policy.getCreatedPolicyCount());

        System.out.println();
        System.out.println(p1.getRiskSummary());

        System.out.println();
        System.out.println("p1 equals duplicate policy? " + p1.equals(p4));

        System.out.println();
        System.out.println("Printing p2 using toString():");
        System.out.println(p2);

        System.out.println();
        Policy found = office.findByNumber("CAR-102");
        System.out.println("Found: " + found);

        System.out.println();
        office.printCheaperThan(1300.0);
    }
}