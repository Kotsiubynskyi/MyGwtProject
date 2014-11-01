package ua.company.gwt.server;

import java.io.Serializable;

/**
 * @author EvgeniyKot on 16.07.2014.
 */
public class Documents implements Serializable {
    private String okpo;
    private String acc;
    private String msisdn;
    private String activationDate;
    private String msisdnStatus;
    private String comm;

    public Documents() {
    }

    public Documents(String okpo, String account, String msisdn, String activationDate, String msisdnStatus, String comm) {
        this.okpo = okpo;
        this.acc = account;
        this.msisdn = msisdn;
        this.activationDate = activationDate;
        this.msisdnStatus = msisdnStatus;
        this.comm = comm;
    }

    public String getOkpo() {
        return okpo;
    }

    public void setOkpo(String okpo) {
        this.okpo = okpo;
    }

    public String getAccount() {
        return acc;
    }

    public void setAccount(String account) {
        this.acc = account;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(String activationDate) {
        this.activationDate = activationDate;
    }

    public String getMsisdnStatus() {
        return msisdnStatus;
    }

    public void setMsisdnStatus(String msisdnStatus) {
        this.msisdnStatus = msisdnStatus;
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }

    @Override
    public String toString() {
        return "DocumentsPackageClient{" +
                "okpo='" + okpo + '\'' +
                ", acc='" + acc + '\'' +
                ", msisdn='" + msisdn + '\'' +
                ", activationDate='" + activationDate + '\'' +
                ", msisdnStatus='" + msisdnStatus + '\'' +
                ", comm='" + comm + '\'' +
                '}';
    }
}
