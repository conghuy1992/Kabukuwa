package com.daydelight.kabukuwa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by goood on 10/19/15.
 */
public class CSVFileMypage {
    InputStream inputStream;

    public CSVFileMypage(InputStream inputStream) {
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
                mypage.itemId.add(row[4]);
                mypage.itemDes.add(row[3]);
                mypage.itemName.add(row[2]);
                mypage.rarity.add(row[13]);
                mypage.coins.add(row[10]);
                mypage.jewels.add(row[11]);
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

