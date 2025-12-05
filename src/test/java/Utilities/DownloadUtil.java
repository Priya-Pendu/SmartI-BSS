package Utilities;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DownloadUtil {

    public static WebDriver getChromeDriverWithDownloadFolder() {
        // Set download path to <project_dir>/download
        Path downloadPath = Paths.get(System.getProperty("user.dir"), "download");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadPath.toAbsolutePath().toString());
        prefs.put("download.prompt_for_download", false);
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("safebrowsing.enabled", true);  // Optional: allow downloads without security warning

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        return new ChromeDriver(options);
    }
}
