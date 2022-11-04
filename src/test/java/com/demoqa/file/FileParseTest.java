package com.demoqa.file;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.demoqa.file.domain.Teacher;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvParser;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class FileParseTest {

    ClassLoader classLoader = FileParseTest.class.getClassLoader();

    @Test
    void pdfTest() throws Exception {
        open("https://junit.org/junit5/docs/current/user-guide/");
        File file = $("a[href*='junit-user-guide-5.9.1.pdf']").download();
        PDF pdf = new PDF(file);
        assertThat(pdf.author).contains("Stefan Bechtold, Sam Brannen, Johannes Link, Matthias Merdes, Marc Philipp, Juliette de Rancourt, Christian Stein");
    }

    @Test
    void xlsTest() throws Exception {
        open("http://romashka2008.ru/o-kompanii");
        File file = $(".top-menu a[href*='/f/prajs_ot_0311.xls']").download();
        XLS xls = new XLS(file);
        assertThat(
                xls.excel
                        .getSheetAt(0)
                        .getRow(22)
                        .getCell(2)
                        .getStringCellValue()
        ).contains("Бумага для цветной печати");
    }

    @Test
    void csvTest() throws Exception {
        InputStream is = classLoader.getResourceAsStream("example.csv");
        CSVReader reader = new CSVReader(new InputStreamReader(is, StandardCharsets.UTF_8));

        List<String[]> csv = reader.readAll();
        assertThat(csv).contains(
                new String[] {"teacher","lesson","data"},
                new String[] {"Tuchs","junit","03.06"}
        );
    }

    @Test
    void zipFile() throws Exception {
        InputStream is = classLoader.getResourceAsStream("example.zip");
        ZipInputStream zip = new ZipInputStream(is);
        ZipEntry entry;

        while((entry = zip.getNextEntry()) != null) {
            assertThat(entry.getName()).isEqualTo("1.txt");
        }
    }

    @Test
    void jsonTest() throws Exception {
        InputStream is = classLoader.getResourceAsStream("teacher.json");
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(new InputStreamReader(is), JsonObject.class);
        assertThat(jsonObject.get("name").getAsString()).isEqualTo("Dmitry");
    }

    @Test
    void jsonTestNG() throws Exception {
        InputStream is = classLoader.getResourceAsStream("teacher.json");
        Gson gson = new Gson();
        Teacher jsonObject = gson.fromJson(new InputStreamReader(is), Teacher.class);
        assertThat(jsonObject.getName()).isEqualTo("Dmitry");
    }
}
