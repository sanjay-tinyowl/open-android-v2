package com.citrus.sdk.classes;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by salil on 24/4/15.
 */
public class Amount implements Parcelable {
    private String value;
    private String currency;

    /**
     *
     * @param value
     */
    public Amount(String value) {
        this.value = value;
        this.currency = "INR";
    }

    public String getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.value);
        dest.writeString(this.currency);
    }

    private Amount(Parcel in) {
        this.value = in.readString();
        this.currency = in.readString();
    }

    public static final Parcelable.Creator<Amount> CREATOR = new Parcelable.Creator<Amount>() {
        public Amount createFromParcel(Parcel source) {
            return new Amount(source);
        }

        public Amount[] newArray(int size) {
            return new Amount[size];
        }
    };
}
