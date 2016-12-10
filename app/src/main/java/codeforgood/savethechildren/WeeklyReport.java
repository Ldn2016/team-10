package codeforgood.savethechildren;

import android.content.res.Resources;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by david on 09/12/2016.
 */

class WeeklyReport implements Serializable {
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

    WeeklyReport() {}

    void setNutritional1(String ageGroup, String totalChildrenAtBeginning) {
        this.ageGroup = ageGroup + ',';
        this.totalChildrenAtBeginning = totalChildrenAtBeginning +',';
    }



    void sendData() {
        String urlString = Resources.getSystem().getString(R.string.websever);
        try {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();

            String toSend = ageGroup + totalChildrenAtBeginning + bmiBelow + muacBelow + oedemaBelow
                    + relapse + reAdmissions + totalAdmissions + movedFromOTP + recovered + death
                    + defaulterUnconfirmed + defaulterConfirmed + nonRecoveryMedicalReferral +
                    nonRecoveryNonResponse + totalDischarges + other + totalOut + totalChildrenAtEnd;

            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(toSend);
            writer.close();

        } catch (IOException e) {
            // Yeah this is really bad but hackathon
        }
    }
}