package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
//    Tirar print da execucao do teste e salvar na pasta screenshots dentro do projeto
    public static void tirarScreenshot(WebDriver driver, String nomeArquivo) {
        String screenshotsDir = "screenshots";
        if (!Files.exists(Paths.get(screenshotsDir))) {
            new File(screenshotsDir).mkdir();
        }

        String dataHora = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String nomeCompleto = String.format("%s/%s_%s.png", screenshotsDir, nomeArquivo, dataHora);

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(screenshotFile.toPath(), Paths.get(nomeCompleto));
            System.out.println("Screenshot salvo em: " + nomeCompleto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}