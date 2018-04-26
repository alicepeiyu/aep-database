package db61b;


public class InterestCalculator {

    private static final String INPUT_NOT_PRESENT_ERROR = "One of the inputs is null - principal: %f, percent interest: %f, time: %f";

    public double calculateSimpleInterest(Double principal, Double percentageInterest, Double timeInYears) throws RequiredInputNotPresentException {
        if (requiredInputsPresent(principal, percentageInterest, timeInYears)) {
            return interestFor(principal, percentageInterest, timeInYears);
        }
        throw new RequiredInputNotPresentException(String.format(INPUT_NOT_PRESENT_ERROR, principal, percentageInterest, timeInYears));
    }

    private double interestFor(Double principal, Double percentageInterest, Double timeInYears) {
        return (principal * percentageInterest * timeInYears) / 100;
    }

    private boolean requiredInputsPresent(Double principal, Double percentageInterest, Double timeInYears) {
        return principal != null && percentageInterest != null && timeInYears != null;
    }

    public static void main(String[] args) throws RequiredInputNotPresentException {
        final double interest = new InterestCalculator().calculateSimpleInterest(100.0,10.0, 1.0);
        System.out.println("Interest for $100 at 10% for 1 year: "  + interest);
    }

    public Double calculateCompoundInterest(Double principal, Double percentageInterest, Double timeInYears) {
        return principal * Math.pow(1 + (percentageInterest / 100), timeInYears) - principal;
    }
}
