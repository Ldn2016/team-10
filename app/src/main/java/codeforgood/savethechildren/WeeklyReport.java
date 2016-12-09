package codeforgood.savethechildren;

/**
 * Created by david on 09/12/2016.
 */

public class WeeklyReport
{
    //ageGroup is either 1 (<6 months) or 2 (6-59 months)
    private String ageGroup;
    private String totalChildrenAtBeginning;
    private String bmiBelow;
    private String muacBelow;
    private String oedemaBelow;
    private String relapse;
    private String reAdmissions;
    private String totalAdmissions;
    private String movedFromOTP;
    private String recovered;
    private String death;
    private String defaulterUnconfirmed;
    private String defaulterConfirmed;
    private String nonRecoveryMedicalReferral;
    private String nonRecoveryNonResponse;
    private String totalDischarges;
    private String other;
    private String totalOut;
    private String totalChildrenAtEnd;

    public WeeklyReport() {}

    public void setNutritional1(String ageGroup, String totalChildrenAtBeginning) {
        this.ageGroup = ageGroup;
        this.totalChildrenAtBeginning = totalChildrenAtBeginning;
    }
}