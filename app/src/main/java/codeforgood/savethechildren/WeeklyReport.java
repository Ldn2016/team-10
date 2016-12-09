package codeforgood.savethechildren;

/**
 * Created by david on 09/12/2016.
 */

public class WeeklyReport
{
    //ageGroup is either 1 (<6 months) or 2 (6-59 months)
    private int ageGroup;
    private int totalChildrenAtBeginning = 0;
    private int bmiBelow = 0;
    private int muacBelow = 0;
    private int oedemaBelow = 0;
    private int relapse = 0;
    private int reAdmission = 0;
    private int totalAdmissions = 0;
    private int movedFromOTP = 0;
    private int recovered = 0;
    private int death = 0;
    private int defaulterUnconfirmed = 0;
    private int defaulterConfirmed = 0;
    private int nonRecoveryMedicalReferral = 0;
    private int nonRecoveryNonResponse = 0;
    private int totalDischarges = 0;
    private int other = 0;
    private int totalOut = 0;
    private int totalChildrenAtEnd = 0;

    public WeeklyReport(int ageGroup)
    {
        this.ageGroup = ageGroup;
    }

    public void decreaseTotalChildrenAtBeginning
}
