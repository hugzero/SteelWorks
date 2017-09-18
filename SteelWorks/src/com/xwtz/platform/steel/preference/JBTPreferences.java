package com.xwtz.platform.steel.preference;

public enum JBTPreferences {
    // TWS connection
    Host("Host", "localhost"),
    Port("Port", "7496"),
    ClientID("Client ID", "0"),
    AccountType("Account type", "Universal"),
    AdvisorAccount("Advisor account", ""),
    AdvisorProfile("Advisor profile", ""),

    // Reporting
    ReportRenderer("Report renderer", "com.idealtrading.platform.report.HTMLReportRenderer"),
    ReportRecycling("Report recycling", "Append"),

    // Remote monitoring
    EmailMonitoring("Monitoring", "disabled"),
    HeartBeatInterval("Heartbeat Interval", "60"),
    SMTPSHost("SMTPS Host", "smtp.gmail.com"),
    EmailLogin("Email Login", "me@gmail.com"),
    EmailPassword("Email Password", ""),
    From("From", "me@gmail.com"),
    To("To", "me@anyprovider.com"),
    EmailSubject("Email Subject", "[JBT Remote Notification]"),

    // Web Access
    WebAccess("Web access", "disabled"),
    WebAccessPort("Web access port", "1234"),
    WebAccessUser("Web access user", "admin"),
    WebAccessPassword("Web access password", "admin"),
    WebAccessHTTPS("Web access HTTPS","disabled"),
    SSLkeystore("SSL keystore location",""),
    SSLkeystorePassword("SSL keystore password",""),
    SSLkeyPassword("SSL key password",""),
    UseJettyConfigFile("External jetty configuration","disabled"),
    ExternalJettyConfigFile("Jetty configuration file",""),

    // Back tester
    BackTesterFileName("backTester.dataFileName", ""),
    BackTesterTestingPeriodStart("backTester.testingPeriodStart", ""),
    BackTesterTestingPeriodEnd("backTester.testingPeriodEnd", ""),
    BackTesterTestingUseBarOnly("backTester.testingUseBarOnly", ""),

    // Optimizer
    OptimizerFileName("optimizer.dataFileName", ""),
    OptimizerTestingPeriodStart("optimizer.testingPeriodStart", ""),
    OptimizerTestingPeriodEnd("optimizer.testingPeriodEnd", ""),
    OptimizerMinTrades("optimizer.minTrades", "50"),
    OptimizerSelectBy("optimizer.selectBy", ""),
    OptimizerMethod("optimizer.method", ""),
    OptimizerWindowWidth("optimizer.window.width", "-1"),
    OptimizerWindowHeight("optimizer.window.height", "-1"),
    OptimizerWindowX("optimizer.window.x", "-1"),
    OptimizerWindowY("optimizer.window.y", "-1"),

    // Main window
    MainWindowWidth("mainwindow.width", "-1"),
    MainWindowHeight("mainwindow.height", "-1"),
    MainWindowX("mainwindow.x", "-1"),
    MainWindowY("mainwindow.y", "-1"),

    // Performance chart
    PerformanceChartWidth("performance.chart.width", "-1"),
    PerformanceChartHeight("performance.chart.height", "-1"),
    PerformanceChartX("performance.chart.x", "-1"),
    PerformanceChartY("performance.chart.y", "-1"),
    PerformanceChartState("performance.chart.state", "-1"),

    // Optimization Map
    OptimizationMapWidth("optimization.map.width", "-1"),
    OptimizationMapHeight("optimization.map.height", "-1"),
    OptimizationMapX("optimization.map.x", "-1"),
    OptimizationMapY("optimization.map.y", "-1"),

    // Collective2
    Collective2Password("C2Password", ""),
    Collective2Strategies("C2Strategies", "");

    private final String name, defaultValue;

    JBTPreferences(String name, String defaultValue) {
        this.name = name;
        this.defaultValue = defaultValue;
    }

    public String getDefault() {
        return defaultValue;
    }

    public String getName() {
        return name;
    }
}
