package com.daydelight.kabukuwa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by goood on 11/11/15.
 */
public class CSVFileBattle {
    InputStream inputStream;

    public CSVFileBattle(InputStream inputStream) {
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
//                Battle.arrID.add(row[4]);
                Battle.itemDes.add(row[3]);

                Battle.itemId.add(row[4]);
                Battle.itemName.add(row[2]);
                Battle.rarity.add(row[13]);
                Battle.coins.add(row[10]);
                Battle.jewels.add(row[11]);
                // resultList.add(row);
                // for (int i = 0; i < row.length; i++) {
//                Log.e("TAG", row[12]);
                // MainActivity.arrName.add(row[1]);
                // }
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
