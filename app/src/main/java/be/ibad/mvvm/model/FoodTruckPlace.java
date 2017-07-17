package be.ibad.mvvm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nvandamme on 12-07-17.
 * All right reserved for Immoweb MVVM_POC
 */

public class FoodTruckPlace implements Parcelable {

    public static final Parcelable.Creator<FoodTruckPlace> CREATOR = new Parcelable.Creator<FoodTruckPlace>() {
        @Override
        public FoodTruckPlace createFromParcel(Parcel source) {
            return new FoodTruckPlace(source);
        }

        @Override
        public FoodTruckPlace[] newArray(int size) {
            return new FoodTruckPlace[size];
        }
    };
    @SerializedName("emplacement")
    @Expose
    private String emplacement;
    @SerializedName("location_in_french")
    @Expose
    private String locationInFrench;
    @SerializedName("location_in_dutch")
    @Expose
    private String locationInDutch;
    @SerializedName("locatie")
    @Expose
    private String locatie;
    @SerializedName("lundi")
    @Expose
    private String lundi;
    @SerializedName("maandag")
    @Expose
    private String maandag;
    @SerializedName("monday")
    @Expose
    private String monday;
    @SerializedName("mardi")
    @Expose
    private String mardi;
    @SerializedName("dinsdag")
    @Expose
    private String dinsdag;
    @SerializedName("tuesday")
    @Expose
    private String tuesday;
    @SerializedName("wednesday")
    @Expose
    private String wednesday;
    @SerializedName("woensdag")
    @Expose
    private String woensdag;
    @SerializedName("mercredi")
    @Expose
    private String mercredi;
    @SerializedName("jeudi")
    @Expose
    private String jeudi;
    @SerializedName("thursday")
    @Expose
    private String thursday;
    @SerializedName("donderdag")
    @Expose
    private String donderdag;
    @SerializedName("vendredi")
    @Expose
    private String vendredi;
    @SerializedName("friday")
    @Expose
    private String friday;
    @SerializedName("vrijdag")
    @Expose
    private String vrijdag;
    @SerializedName("samedi")
    @Expose
    private String samedi;
    @SerializedName("zaterdag")
    @Expose
    private String zaterdag;
    @SerializedName("saturday")
    @Expose
    private String saturday;
    @SerializedName("coordonnees_wgs84")
    @Expose
    private List<Double> coordonneesWgs84 = null;

    public FoodTruckPlace() {
    }

    protected FoodTruckPlace(Parcel in) {
        this.emplacement = in.readString();
        this.locationInFrench = in.readString();
        this.locationInDutch = in.readString();
        this.locatie = in.readString();
        this.lundi = in.readString();
        this.maandag = in.readString();
        this.monday = in.readString();
        this.mardi = in.readString();
        this.dinsdag = in.readString();
        this.tuesday = in.readString();
        this.wednesday = in.readString();
        this.woensdag = in.readString();
        this.mercredi = in.readString();
        this.jeudi = in.readString();
        this.thursday = in.readString();
        this.donderdag = in.readString();
        this.vendredi = in.readString();
        this.friday = in.readString();
        this.vrijdag = in.readString();
        this.samedi = in.readString();
        this.zaterdag = in.readString();
        this.saturday = in.readString();
        this.coordonneesWgs84 = new ArrayList<Double>();
        in.readList(this.coordonneesWgs84, Double.class.getClassLoader());
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public String getLocationInFrench() {
        return locationInFrench;
    }

    public void setLocationInFrench(String locationInFrench) {
        this.locationInFrench = locationInFrench;
    }

    public String getLocationInDutch() {
        return locationInDutch;
    }

    public void setLocationInDutch(String locationInDutch) {
        this.locationInDutch = locationInDutch;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public String getLundi() {
        return lundi;
    }

    public void setLundi(String lundi) {
        this.lundi = lundi;
    }

    public String getMaandag() {
        return maandag;
    }

    public void setMaandag(String maandag) {
        this.maandag = maandag;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getMardi() {
        return mardi;
    }

    public void setMardi(String mardi) {
        this.mardi = mardi;
    }

    public String getDinsdag() {
        return dinsdag;
    }

    public void setDinsdag(String dinsdag) {
        this.dinsdag = dinsdag;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getWoensdag() {
        return woensdag;
    }

    public void setWoensdag(String woensdag) {
        this.woensdag = woensdag;
    }

    public String getMercredi() {
        return mercredi;
    }

    public void setMercredi(String mercredi) {
        this.mercredi = mercredi;
    }

    public String getJeudi() {
        return jeudi;
    }

    public void setJeudi(String jeudi) {
        this.jeudi = jeudi;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getDonderdag() {
        return donderdag;
    }

    public void setDonderdag(String donderdag) {
        this.donderdag = donderdag;
    }

    public String getVendredi() {
        return vendredi;
    }

    public void setVendredi(String vendredi) {
        this.vendredi = vendredi;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getVrijdag() {
        return vrijdag;
    }

    public void setVrijdag(String vrijdag) {
        this.vrijdag = vrijdag;
    }

    public String getSamedi() {
        return samedi;
    }

    public void setSamedi(String samedi) {
        this.samedi = samedi;
    }

    public String getZaterdag() {
        return zaterdag;
    }

    public void setZaterdag(String zaterdag) {
        this.zaterdag = zaterdag;
    }

    public String getSaturday() {
        return saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    public List<Double> getCoordonneesWgs84() {
        return coordonneesWgs84;
    }

    public void setCoordonneesWgs84(List<Double> coordonneesWgs84) {
        this.coordonneesWgs84 = coordonneesWgs84;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.emplacement);
        dest.writeString(this.locationInFrench);
        dest.writeString(this.locationInDutch);
        dest.writeString(this.locatie);
        dest.writeString(this.lundi);
        dest.writeString(this.maandag);
        dest.writeString(this.monday);
        dest.writeString(this.mardi);
        dest.writeString(this.dinsdag);
        dest.writeString(this.tuesday);
        dest.writeString(this.wednesday);
        dest.writeString(this.woensdag);
        dest.writeString(this.mercredi);
        dest.writeString(this.jeudi);
        dest.writeString(this.thursday);
        dest.writeString(this.donderdag);
        dest.writeString(this.vendredi);
        dest.writeString(this.friday);
        dest.writeString(this.vrijdag);
        dest.writeString(this.samedi);
        dest.writeString(this.zaterdag);
        dest.writeString(this.saturday);
        dest.writeList(this.coordonneesWgs84);
    }
}
