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
public class CSVparts {
    InputStream inputStream;

    public CSVparts(InputStream inputStream) {
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
//                Battle.CSV_species_parts.add(row[0]);
//                Battle.CSV_part_parts.add(row[2]);
//                Battle.CSV_rank_parts.add(row[5]);
//                Battle.CSV_hp_parts.add(row[8]);
//                Battle.CSV_attack_parts.add(row[9]);
//                Battle.CSV_criticalAttack_parts.add(row[10]);
//                Battle.CSV_defense_parts.add(row[11]);
//                Battle.CSV_critical_parts.add(row[12]);
//                Battle.CSV_avoid_parts.add(row[13]);
//                Battle.CSV_lucky_parts.add(row[14]);
//                Battle.CSV_speed_parts.add(row[15]);
                mypage.CSV_species_parts.add(row[0]);
                mypage.CSV_part_parts.add(row[2]);
                mypage.CSV_rank_parts.add(row[5]);
                mypage.CSV_hp_parts.add(row[8]);
                mypage.CSV_attack_parts.add(row[9]);
                mypage.CSV_criticalAttack_parts.add(row[10]);
                mypage.CSV_defense_parts.add(row[11]);
                mypage.CSV_critical_parts.add(row[12]);
                mypage.CSV_avoid_parts.add(row[13]);
                mypage.CSV_lucky_parts.add(row[14]);
                mypage.CSV_speed_parts.add(row[15]);

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

