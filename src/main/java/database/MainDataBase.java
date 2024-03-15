package database;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class MainDataBase {
    public MainDataBase(){

    }

    //----------------------------------------SETTERS-------------------------------------------

    public void setPositivas(String numbersOf) throws IOException {
        //Escribir en el JSON
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/main/java/database/database.json");
        Map<String, Map<String, String>> jsonData = objectMapper.readValue(file, Map.class);
        Map<String, String> valoraciones = jsonData.get("valoraciones");
        valoraciones.put("valoracionesPositivas", numbersOf);
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        objectWriter.writeValue(file, jsonData);
    }

    public void setMedias(String numbersOf) throws IOException {
        //Escribir en el JSON
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/main/java/database/database.json");
        Map<String, Map<String, String>> jsonData = objectMapper.readValue(file, Map.class);
        Map<String, String> valoraciones = jsonData.get("valoraciones");
        valoraciones.put("valoracionesMedias", numbersOf);
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        objectWriter.writeValue(file, jsonData);
    }

    public void setNegativas(String numbersOf) throws IOException {
        //Escribir en el JSON
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/main/java/database/database.json");
        Map<String, Map<String, String>> jsonData = objectMapper.readValue(file, Map.class);
        Map<String, String> valoraciones = jsonData.get("valoraciones");
        valoraciones.put("valoracionesMalas", numbersOf);
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        objectWriter.writeValue(file, jsonData);
    }

    //----------------------------------------GETTERS-------------------------------------------

    public String loadPositivas() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/main/java/database/database.json");
        Map<String, Object> jsonData = objectMapper.readValue(file, Map.class);
        Map<String, Object> valoraciones = (Map<String, Object>) jsonData.get("valoraciones");
        String valoracionesPositivas = (String) valoraciones.get("valoracionesPositivas");

        return valoracionesPositivas;
    }

    public String loadMedias() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/main/java/database/database.json");
        Map<String, Object> jsonData = objectMapper.readValue(file, Map.class);
        Map<String, Object> valoraciones = (Map<String, Object>) jsonData.get("valoraciones");
        String valoracionesMedias = (String) valoraciones.get("valoracionesMedias");

        return valoracionesMedias;
    }

    public String loadNegativas() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/main/java/database/database.json");
        Map<String, Object> jsonData = objectMapper.readValue(file, Map.class);
        Map<String, Object> valoraciones = (Map<String, Object>) jsonData.get("valoraciones");
        String valoracionesMalas = (String) valoraciones.get("valoracionesMalas");

        return valoracionesMalas;
    }

    public String toString(){
        String resultado = null;
        try {
            resultado = "El resultado de las votaciones ha sido el siguiente: \n -Valoraciones Positivas: " + loadPositivas() + ".\n -Valoraciones Medias: \t" + loadMedias() + ".\n -Valoraciones Negativas: " + loadNegativas() + ".";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }
}