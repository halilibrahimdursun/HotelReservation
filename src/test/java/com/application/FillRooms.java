package com.application;

import com.application.model.Room;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.*;

public class FillRooms {

    public static void main(String[] args) throws IOException, CsvException {
        CSVParser parser = new CSVParserBuilder()
                .withSeparator(',')
                .build();
        try (CSVReader reader = new CSVReaderBuilder(new FileReader("src/test/resources/RoomsTest.csv"))
                .withCSVParser(parser)
                .build();) {
            reader.readAll().forEach(x -> write(processArray(x)));
        }
    }
        public static String processArray(String[] line){
            Room room = new Room();
//		INSERT INTO Room VALUES(NEXTVAL('ROOM_SEQ'), 2, 'First floor',1, 'Single', 'Non Smoking', 'mini fridge, TV, Airco,WIFI, toilet, shower, phone, water boiler', 220,101, 'i');
            String sql = "\nINSERT INTO room (ID, CAPACITY_OF_ADULTS, CAPACITY_OF_CHILDREN, CAPACITY_OF_GUESTS, FACILITIES, IMAGE_LINK,CLEANED,DISABLED,SMOCKING, PRICE, ROOM_NUMBER, TYPE_OF_BED, TYPE_OF_ROOM) VALUES (NEXTVAL('ROOM_SEQ')," +
                    line[3] + "," +
                    line[4] + "," +
                    line[12] + ", '" +
                    line[9] + "', '" +
                    line[13] + "', " +
                    line[11] + "," +
                    line[7] + "," +
                    line[6] + "," +
                    line[10] + "," +
                    line[0] + ", '" +
                    line[5] + "', '" +
                    line[2] + "')";
            return sql;

        }
        public static void write(String line){
            File file = new File("src/main/resources/data.sql");
            FileWriter fr = null;
            try {
                fr = new FileWriter(file, true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            BufferedWriter br = new BufferedWriter(fr);
            try {
                br.write(line);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
}
