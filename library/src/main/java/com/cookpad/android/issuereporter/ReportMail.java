package com.cookpad.android.issuereporter;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class ReportMail implements Parcelable {
    private String email;
    private String subject;
    private String body;

    public String getEmail() {
        return email;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    private ReportMail(Builder builder) {
        this.email = builder.email;
        this.subject = builder.subject;
        this.body = builder.body;
    }

    public static class Builder {
        private String email = "";
        private String subject = "";
        private String body = "";

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public ReportMail build() {
            if (TextUtils.isEmpty(email)) {
                throw new IllegalArgumentException("Email should not be empty");
            }
            return new ReportMail(this);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.email);
        dest.writeString(this.subject);
        dest.writeString(this.body);
    }

    private ReportMail(Parcel in) {
        this.email = in.readString();
        this.subject = in.readString();
        this.body = in.readString();
    }

    public static final Parcelable.Creator<ReportMail> CREATOR = new Parcelable.Creator<ReportMail>() {
        public ReportMail createFromParcel(Parcel source) {
            return new ReportMail(source);
        }

        public ReportMail[] newArray(int size) {
            return new ReportMail[size];
        }
    };
}
