package org.example.hw3;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class AccuweatherAbstractTest {

    static Properties prop = new Properties();
    private static InputStream configFile;
    private static String apiKey;



    @BeforeAll
    static void initTest() throws IOException {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        configFile = new FileInputStream("src/test/java/resources/accuweather.properties");
        prop.load(configFile);

        apiKey =  prop.getProperty("apikey");


    }

    public static String getApiKey() {
        return apiKey;
    }


}