Issue reporter
============

This library provide issue report feature to your app.

Click notification to report an issue that is include system informations and screenshot.

<img src="./static/issue-reporter.gif" width="400dp"/>

# Quick start

### MainActivity.java
```java
@Override
protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);

  String mailAddress = "support@example.com";
  String subject = "Report an issue";
  IssueReporterFragment.apply(this, mailAddress, subject);
}
```
