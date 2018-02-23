package com.daydelight.kabukuwa;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.util.Log;

public class CSVFileShop {
    InputStream inputStream;

    public CSVFileShop(InputStream inputStream) {
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
                shop.itemId.add(row[4]);
                shop.itemDes.add(row[3]);
                shop.itemName.add(row[2]);
                shop.rarity.add(row[13]);
                shop.coins.add(row[10]);
                shop.jewels.add(row[11]);
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
