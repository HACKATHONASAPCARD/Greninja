package com.hackathon.CSVReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.JSONArray;
import org.json.JSONObject;

import com.hackathon.mq.MqConfig;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class CSVFileReader {

    public static void main(String[] args) {
        String delimeter = ";";
        String lineData;
        File csvFile = new File("input-data.csv");

        try {
            Connection connection = MqConfig.getConnection();
            Channel channel = connection.createChannel();
            String queueName = "transaction.create";
            channel.queueDeclare(queueName, false, false, false, null);
            channel.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            BufferedReader read = new BufferedReader(new FileReader(csvFile));
            JSONArray arrayOfJSONObjects = new JSONArray();

            while ((lineData = read.readLine()) != null) {
                String[] moeda = lineData.split(delimeter);

                System.out.println("[ID_Transiction = " + moeda[0]
                        + " , Date_Transiction = " + moeda[1]
                        + " , Document = " + moeda[2]
                        + " , Name = " + moeda[3]
                        + " , Age = " + moeda[4]
                        + " , Value = " + moeda[5]
                        + " , Installment_Number = " + moeda[6] + "]");

                JSONObject jsonObj = new JSONObject();
                jsonObj.put("ID_Transaction", moeda[0]);
                jsonObj.put("Date_Transaction", moeda[1]);
                jsonObj.put("Document", moeda[2]);
                jsonObj.put("Name", moeda[3]);
                jsonObj.put("Age", moeda[4]);
                jsonObj.put("Value", moeda[5]);
                jsonObj.put("Installment_Number", moeda[6]);

                arrayOfJSONObjects.put(jsonObj);
            }

            try {
                Connection connection = MqConfig.getConnection();
                Channel channel = connection.createChannel();

                for (int i = 0; i < arrayOfJSONObjects.length(); i++) {
                    String message = arrayOfJSONObjects.getJSONObject(i).toString();
                    channel.basicPublish("", "transaction.create", null, message.getBytes());
                }

                channel.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            try (PrintWriter out = new PrintWriter(new FileWriter("dadosJSON.txt"))) {
                out.write(arrayOfJSONObjects.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
