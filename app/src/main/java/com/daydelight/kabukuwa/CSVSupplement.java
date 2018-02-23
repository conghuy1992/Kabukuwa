package com.daydelight.kabukuwa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by goood on 11/13/15.
 */
public class CSVSupplement {
    InputStream inputStream;

    public CSVSupplement(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public List<String[]> read() {
        List<String[]> resultList = new ArrayList<String[]>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                inputStream));
        try {
            String csvLine;
            while ((csvLine = reader.readLine()) != null) {
                String[] row = csvLine.split(",");
                mypage.CSV_species_supplement.add(row[0]);
                mypage.CSV_lv_supplement.add(row[2]);
                mypage.CSV_hp_supplement.add(row[3]);
                mypage.CSV_attack_supplement.add(row[4]);
                mypage.CSV_criticalAttack_supplement.add(row[5]);
                mypage.CSV_defense_supplement.add(row[6]);
                mypage.CSV_critical_supplement.add(row[7]);
                mypage.CSV_avoid_supplement.add(row[8]);
                mypage.CSV_lucky_supplement.add(row[9]);
                mypage.CSV_speed_supplement.add(row[10]);

            }
        } catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file: " + ex);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException("Error while closing input stream: "
                        + e);
            }
        }
        return resultList;
    }
}
