package net.lavacreeper.vote.controller.restcontrollers.test;

/**
 * @projectName: vote
 * @package: net.lavacreeper.vote.controller.restcontrollers.test
 * @className: Test
 * @author: LavaCreeper
 * @description:
 * @date: 11/13/23 10:06 AM
 * @version: 1.0
 */

import net.lavacreeper.vote.domain.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AlarmClockApp extends JFrame {
    public static void main(String[] args) {
        String end_date = "2023-11-14 12:12:12";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(end_date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (date != null && (date.before(new Date()) || date.equals(new Date()))) {
            System.out.println("到了");

        } else {
            System.out.println("没到");
        }
    }

}
