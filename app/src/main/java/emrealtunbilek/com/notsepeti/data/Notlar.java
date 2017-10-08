package emrealtunbilek.com.notsepeti.data;

/**
 * Created by Emre Altunbilek on 6.10.2017.
 */

public class Notlar {

    private int notID;

    public int getNotID() {
        return notID;
    }

    public void setNotID(int notID) {
        this.notID = notID;
    }

    private String notIcerik;
    private String notTarih;
    private int yapildi;

    public String getNotIcerik() {
        return notIcerik;
    }

    public void setNotIcerik(String notIcerik) {
        this.notIcerik = notIcerik;
    }

    public String getNotTarih() {
        return notTarih;
    }

    public void setNotTarih(String notTarih) {
        this.notTarih = notTarih;
    }

    public int getYapildi() {
        return yapildi;
    }

    public void setYapildi(int yapildi) {
        this.yapildi = yapildi;
    }
}
