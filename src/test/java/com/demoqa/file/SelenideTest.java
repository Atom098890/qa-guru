package com.demoqa.file;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

@Disabled
public class SelenideTest {

    // тесты могут падать и это плахая практика, это на крайний случай, когда нету href для скачивания файлов
//    static {
//        Configuration.fileDownload = FileDownloadMode.PROXY;
//    }




    //в джаве нет метода рид файл ту стринг, в джаве за это отвечает конкретный механизмы
    //инпут стрим и аутстрим, ридер и врайтер

    @Test
    void downloadTest() throws Exception {
        open("https://github.com/junit-team/junit5/blob/main/README.md");
        File file = $("#raw-url").download();
        //стримы нужно закрывать, технология типо сокета, они могут закончиться, поэтому стримы надо закрывать
        // самый норм это через try
        try(InputStream is = new FileInputStream(file)){
            byte[] fileContent = is.readAllBytes();
            assertThat(new String(fileContent, StandardCharsets.UTF_8)).contains("Contributions to JUnit 5");
        }
        System.out.println();
    }

    @Test
    void uploadFileTest() {
        open("https://the-internet.herokuapp.com/upload");
        $("input[type='file']").uploadFromClasspath("text.txt");
        $("#file-submit").click();
        $("h3").shouldHave(text("File Uploaded!"));
    }
}
