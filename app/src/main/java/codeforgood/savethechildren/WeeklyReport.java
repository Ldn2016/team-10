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
    private String otherG;
    private String totalIn;
    private String promotedToOTP;
    private String recovered;
    private String death;
    private String defaulterUnconfirmed;
    private String defaulterConfirmed;
    private String nonRecoveryMedicalReferral;
    private String nonRecoveryNonResponse;
    private String totalDischarges;
    private String otherO;
    private String totalOut;
    private String totalChildrenAtEnd;   

    public WeeklyReport() {}

    public void setNutritional1(String ageGroup, String totalChildrenAtBeginning)
    {
        this.ageGroup = ageGroup;
        this.totalChildrenAtBeginning = totalChildrenAtBeginning;
    }

    public void setNutritional2(String bmiBelow, String muacBelow, String oedemaBelow,
                                String relapse, String reAdmissions)
    {
        this.bmiBelow = bmiBelow;
        this.muacBelow = muacBelow;
        this.oedemaBelow = oedemaBelow;
        this.relapse = relapse;
        this.reAdmissions = reAdmissions;
        int totalAdmissionsInt = Integer.parseInt(bmiBelow) + Integer.parseInt(muacBelow) +
                                 Integer.parseInt(oedemaBelow) + Integer.parseInt(relapse) +
                                 Integer.parseInt(reAdmissions);
        this.totalAdmissions = Integer.toString(totalAdmissionsInt);
    }

    public void setNutritional3(String movedFromOTP, String otherG)
    {
        this.movedFromOTP = movedFromOTP;
        this.otherG = otherG;
        int totalInInt = Integer.parseInt(totalAdmissions) + Integer.parseInt(otherG);
        this.totalIn = Integer.toString(totalInInt);
    }

    public void setNutritional4(String promotedToOTP, String recovered, String death, String defaulterUnconfirmed,
                                String defaulterConfirmed, String nonRecoveryMedicalReferral,
                                String nonRecoveryNonResponse)
    {
        this.promotedToOTP = promotedToOTP;
        this.recovered = recovered;
        this.death = death;
        this.defaulterUnconfirmed = defaulterUnconfirmed;
        this.defaulterConfirmed = defaulterConfirmed;
        this.nonRecoveryMedicalReferral = nonRecoveryMedicalReferral;
        this.nonRecoveryNonResponse = nonRecoveryNonResponse;
        int totalDischargesInt = Integer.parseInt(recovered) + Integer.parseInt(death) +
                                 Integer.parseInt(defaulterUnconfirmed) + Integer.parseInt(defaulterConfirmed) +
                                 Integer.parseInt(nonRecoveryMedicalReferral) + Integer.parseInt(nonRecoveryNonResponse);
        this.totalDischarges = Integer.toString(totalDischargesInt);
    }

    public void setNutritional5(String otherO)
    {
        this.otherO = otherO;
        this.totalOut = this.totalDischarges + otherO;
        int totalChildrenAtEndInt = Integer.parseInt(totalChildrenAtBeginning) + Integer.parseInt(totalIn) -
                                    Integer.parseInt(totalOut);

        this.totalChildrenAtEnd = Integer.toString(totalChildrenAtEndInt);
    }

}