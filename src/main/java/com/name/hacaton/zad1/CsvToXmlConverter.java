package com.name.hacaton.zad1;

import com.opencsv.CSVReader;
import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

class CsvToXmlConverter {

    File convert(String csvFile){
        File xmlFile = new File(csvFile + ".xml");
        try( CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] line;
            String[] header = reader.readNext();
            List<List<String[]>> out = new ArrayList();

            while((line = reader.readNext())!=null){
                List<String[]> item = new ArrayList<>();
                for (int i = 0; i < header.length; i++) {
                    String[] keyVal = new String[2];
                    String title = header[i];
                    String value = line[i];
                    keyVal[0] = title;
                    keyVal[1] = value;
                    item.add(keyVal);
                }
                out.add(item);
            }

            XStream xstream = new XStream();
            xstream.toXML(out, new FileWriter(xmlFile,true));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return xmlFile;
    }
}
