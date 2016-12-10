package codeforgood.savethechildren;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by david on 09/12/2016.
 */

public class WeeklyReport implements Serializable
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

    WeeklyReport() {}

    void setNutritional1(String ageGroup, String totalChildrenAtBeginning)
    {
        this.ageGroup = ageGroup;
        this.totalChildrenAtBeginning = totalChildrenAtBeginning;
    }

    void setNutritional2(String bmiBelow, String muacBelow, String oedemaBelow,
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

    void setNutritional3(String movedFromOTP, String otherG)
    {

        int totalInInt = Integer.parseInt(totalAdmissions) + Integer.parseInt(otherG);
        this.totalIn = Integer.toString(totalInInt);
        this.movedFromOTP = movedFromOTP;
        this.otherG = otherG;
    }

    void setNutritional4(String promotedToOTP, String recovered, String death, String defaulterUnconfirmed,
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
        int totalDischargesInt = Integer.parseInt(String.valueOf(recovered)) + Integer.parseInt(String.valueOf(death)) +
                                 Integer.parseInt(String.valueOf(defaulterUnconfirmed)) + Integer.parseInt(String.valueOf(defaulterConfirmed)) +
                                 Integer.parseInt(String.valueOf(nonRecoveryMedicalReferral)) + Integer.parseInt(String.valueOf(nonRecoveryNonResponse));
        this.totalDischarges = Integer.toString(totalDischargesInt);
    }

    void setNutritional5(String otherO)
    {
        this.otherO = otherO;
        this.totalOut = this.totalDischarges + otherO;
        int totalChildrenAtEndInt = Integer.parseInt(totalChildrenAtBeginning) + Integer.parseInt(totalIn) -
                                    Integer.parseInt(totalOut);

        this.totalChildrenAtEnd = Integer.toString(totalChildrenAtEndInt);
    }


    void sendReport() {
            new Thread(new Runnable() {
                public void run () {
                    try {
                        String toSend = ageGroup + ',' + totalChildrenAtBeginning + ',' + bmiBelow + ',' + muacBelow + oedemaBelow
                        + ',' + relapse + reAdmissions + ',' + totalAdmissions + ',' + movedFromOTP + ',' + otherG + ',' + totalIn
                        + ',' + promotedToOTP + ',' + recovered + ',' + death + ',' + defaulterUnconfirmed + ',' + defaulterConfirmed
                        + ',' + nonRecoveryMedicalReferral + ',' + nonRecoveryNonResponse + ',' + totalDischarges + ',' + otherO
                        + ',' + totalOut + ',' + totalChildrenAtEnd;

                        // Hotfix can't be bothered to fix as 4am so hard coded string

                        URL url = new URL("http://ec2-52-212-183-253.eu-west-1.compute.amazonaws.com:8080/");
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        connection.setDoOutput(true);
                        connection.setDoInput(true);
                        connection.setRequestMethod("POST");
                        connection.setRequestProperty("Content-Type", "text/plain");
                        connection.setRequestProperty("charset", "utf-8");
                        connection.setRequestProperty("Content-Length", Integer.toString(toSend.length()));

                        System.out.println("test");
                        OutputStreamWriter write = new OutputStreamWriter(connection.getOutputStream());
                        write.write(toSend);
                        System.out.println("written");
                        write.flush();
                        System.out.println("help");
                        write.close();
                        System.out.println("out");
                        System.out.println(toSend);
                        // Fantastic bit of code
                    } catch (IOException e) {
                    // Yeah it's a hackathon so might as well
                }
            }
        }).start();
    }

}