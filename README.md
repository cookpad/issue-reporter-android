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
