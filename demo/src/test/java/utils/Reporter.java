package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

/**
 * This class handles reporting with ExtentReports and captures screenshots.
 * 
 * Author: Jay Srivastava
 */
public class Reporter {
    private static final String REPORTS_PATH = System.getProperty("user.dir") + "/reports/";
    private static final String DATE_FORMAT = "yyyy.MM.dd.HH.mm.ss";
    private ExtentReports report;
    private ExtentSparkReporter spark;
    private TakesScreenshot ts;
    // private LoggerHandler loggerHandler = new LoggerHandler();

    /**
     * Generates an ExtentReport with system information.
     * 
     * @param reportName The name of the report.
     * 
     * Author: Jay Srivastava
     */
    public void generateReport(String reportName) {
        String path = generateReportFilePath(reportName);
        spark = new ExtentSparkReporter(path);
        report = new ExtentReports();
        report.attachReporter(spark);

        report.setSystemInfo("OS Name", System.getProperty("os.name"));
        report.setSystemInfo("OS Version", System.getProperty("os.version"));
        report.setSystemInfo("Java Version", System.getProperty("java.runtime.version"));
        report.setSystemInfo("User Directory", System.getProperty("user.dir"));
        // loggerHandler.info("Report is created and started " + reportName);
    }

    private String generateReportFilePath(String reportName) {
        String timestamp = new SimpleDateFormat(DATE_FORMAT).format(new Date());
        return REPORTS_PATH + reportName + "_" + timestamp + ".html";
    }

    /**
     * Creates a new test in the ExtentReports instance.
     * 
     * @param testName The name of the test to create.
     * @return An ExtentTest instance representing the new test.
     * 
     * Author: Jay Srivastava
     */
    public ExtentTest createTest(String testName) {
        if (report == null) {
            throw new IllegalStateException("Report has not been generated. Call generateReport() first.");
        }
        // loggerHandler.info("In report a new test is created with name " + testName);
        return report.createTest(testName);
    }

    /**
     * Captures a screenshot and saves it to the reports directory.
     * 
     * @param filename The base name of the screenshot file.
     * @return The path of the saved screenshot.
     * 
     * Author: Jay Srivastava
     */
    public String captureScreenShot(String filename) throws IOException {
        File file = captureScreenshotAsFile(filename);
        String path = REPORTS_PATH + filename + getCurrentTimestamp() + ".png";
        File target = new File(path);
        Files.copy(file, target);
        return path;
    }

    /**
     * Captures a screenshot and returns it as a File.
     * 
     * @param filename The base name of the screenshot file.
     * @return The screenshot file.
     * 
     * Author: Jay Srivastava
     */
    public File captureScreenshotAsFile(String filename) {
        ts = (TakesScreenshot) Base.driver;
        return ts.getScreenshotAs(OutputType.FILE);
    }

    private String getCurrentTimestamp() {
        return new SimpleDateFormat(DATE_FORMAT).format(new Date());
    }

    /**
     * Adds a screenshot to the ExtentTest report.
     * 
     * @param name The name of the screenshot.
     * @param test The ExtentTest instance.
     * 
     * Author: Jay Srivastava
     */
    public void addScreenshotToReport(String name, ExtentTest test) {
        try {
            File screenshotFile = captureScreenshotAsFile(name);
            if (screenshotFile != null) {
                String screenshotPath = captureScreenShot(name);
                test.log(Status.INFO, "Screenshot taken: " + name,
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
                // loggerHandler.info("In report a screenshot with name " + name);
            } else {
                // loggerHandler.error("Screenshot file is null for " + name);
            }
        } catch (IOException e) {
            // loggerHandler.error("Failed to add screenshot to report: " + name + " : " + e.getMessage());
        }
    }

    /**
     * Adds a log message to the ExtentTest report.
     * 
     * @param message The log message.
     * @param status  The log status.
     * @param test    The ExtentTest instance.
     * 
     * Author: Jay Srivastava
     */
    public void addLog(String message, Status status, ExtentTest test) {
        if (report == null) {
            throw new IllegalStateException("Report has not been generated. Call generateReport() first.");
        }
        test.log(status, message);
        // loggerHandler.info(message);
        if (status == Status.FAIL) {
            addScreenshotToReport(message + " Screenshot", test);
        }
    }

    /**
     * Flushes the ExtentReports.
     * 
     * Author: Jay Srivastava
     */
    public void flushing() {
        if (report != null) {
            report.flush();
            // loggerHandler.info("Report is saved ");
        } else {
            // loggerHandler.error("Failed to flush the ExtentReports instance: report is null.");
        }
    }
}