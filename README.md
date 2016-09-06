Issue Reporter
============

This library provide issue report feature to your app.

Click notification to report an issue that is include system informations and screenshot.

<img src="./static/issue-reporter.gif" width="400dp"/>

# Quick Start

```java
// MainActivity.java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ReportMail reportMail = new ReportMail.Builder()
            .email("support@example.com")
            .subject("Report an issue")
            .body(new SystemProfile(this).toString())
            .build();
    IssueReporterFragment.apply(this, reportMail);
}
```

```xml
<!-- in AndroidManifest.xml -->
<application>
        <provider
                android:name="android.support.v4.content.FileProvider"
                android:authorities="${applicationId}.issuereporter.fileprovider"
                android:grantUriPermissions="true"
                android:exported="false">
            <meta-data
                    android:name="android.support.FILE_PROVIDER_PATHS"
                    android:resource="@xml/issuereporter_filepaths"/>
        </provider>
</application>
```

# For Developers

## How to publish for jcenter

1. create [bintray](https://bintray.com/) account
2. get API_KEY from your profile edit page
3. `./gradlew clean build bintrayUpload -PbintrayUser=[your account name] -PbintrayKey=[your api key] -PdryRun=true`
4. change to `-PdryRun=false`
5. `./gradlew releng`
