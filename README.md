Issue Reporter
============

This library provide issue report feature to your app.

Click notification to report an issue that is include system informations and screenshot.

<img src="./static/issue-reporter.gif" width="400dp"/>

# Quick Start

### Initialize and Destroy

Call IssueReporter.initialize and IssueReporter.destroy in your application class.

```java
@Override
public void onCreate() {
    super.onCreate();
    ReportMail reportMail = new ReportMail.Builder()
            .email("support@example.com")
            .subject("Report an issue")
            .body(new SystemProfile(this).toString())
            .build();
    IssueReporter.start(this, reportMail);
}

@Override
public void onTerminate() {
    IssueReporter.stop(this);
    super.onTerminate();
}
```

