package lotto;

public class ApplicationRunner {
    private ApplicationRunner() {
    }

    public static void run() {
        AppConfig appConfig = new AppConfig();
        appConfig.getClient().start();
    }
}
