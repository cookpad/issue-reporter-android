package com.cookpad.android.issuereporter;

import android.test.AndroidTestCase;

public class ReportMailTest extends AndroidTestCase {
    public void testBuild() {
        {
            ReportMail mail = new ReportMail.Builder()
                    .email("email")
                    .build();
            assertEquals("email", mail.getEmail());
            assertEquals("", mail.getSubject());
            assertEquals("", mail.getBody());
        }

        {
            ReportMail mail = new ReportMail.Builder()
                    .email("email")
                    .subject("subject")
                    .build();
            assertEquals("email", mail.getEmail());
            assertEquals("subject", mail.getSubject());
            assertEquals("email", mail.getBody());
        }

        {
            ReportMail mail = new ReportMail.Builder()
                    .email("email")
                    .subject("body")
                    .build();
            assertEquals("email", mail.getEmail());
            assertEquals("", mail.getSubject());
            assertEquals("body", mail.getBody());
        }

        {
            ReportMail mail = new ReportMail.Builder()
                    .email("email")
                    .subject("subject")
                    .body("body")
                    .build();
            assertEquals("email", mail.getEmail());
            assertEquals("subject", mail.getSubject());
            assertEquals("body", mail.getBody());
        }
    }
    public void testBuildWithEmptyEmail() {
        try {
            new ReportMail.Builder()
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            // success
        }

        try {
            new ReportMail.Builder()
                    .subject("subject")
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            // success
        }

        try {
            new ReportMail.Builder()
                    .body("body")
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            // success
        }

        try {
            new ReportMail.Builder()
                    .subject("subject")
                    .body("body")
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
