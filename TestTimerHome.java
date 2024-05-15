package ru.itis.inf304.lab9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimerHome {
    public static void main(String[] args) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Время пришло");
                PlayWAV.playWavFromFile(new File("rocket.wav"));
                cancel();
            }
        };

        Timer timer = new Timer();

        try {
            String time = args[0] + "." + args[1] + "." + args[2] + " " + args[3] + ":" + args[4] + ":" + args[5];
            Date date = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(time);
            timer.schedule(task, date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        /*try (BufferedReader test = new BufferedReader(new FileReader("C:\\javaprojects\\firstyear\\2 chapter\\2) class\\lab9\\alarm_params.txt"))) {
            Date date = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(test.readLine());
            timer.schedule(task, date);
        } catch (Exception e) {
            e.printStackTrace();

        } */
    }
}
