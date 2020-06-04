/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogghino.comment;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Elia
 */
public class BuildComment {

    public static String BuildContent(String cont) {
//        <div class="comment-content">
//                                Questo è il commento principale dell'Admin a cui si potrà dare risposta, più il testo di questo è lungo più il box in cui è contenuto
//                                si allunga perciò continuerò a scrivere per dimostrarvelo anche se l'ho già fatto vedere e quindi ora la smetto.
//                            </div>
//                        </div>
//                    </div>

        String comment = "<div class='comment-content'>" + cont + "</div>\n</div>\n</div>\n\n<!--reply-->\n\n</li>\n\n";
        return comment;
    }

    public static String BuildAuthor(String a) {
//        <ul id="comments-list" class="comments-list">
//
//                <li>
//                    <div class="comment-main-level">
//                        <div class="comment-avatar"><img src="https://i.pinimg.com/originals/7f/1b/2a/7f1b2a67fcb2242c9fcdd865ba9008b2.jpg" alt=""></div>
//                        <div class="comment-box">
//                            <div class="comment-head">
//                                <h6 class="comment-name by-author">Elia Gaole</a></h6>
        if (a == "admin") {
            String ath = "<ul id='comments-list' class='comments-list'>\n<li>\n<div class='comment-main-level'>\n<div class='comment-avatar'>\n<img src='https://i.pinimg.com/originals/7f/1b/2a/7f1b2a67fcb2242c9fcdd865ba9008b2.jpg' alt=''>\n</div>\n"
                    + "<div class='comment-box'>\n<div class='comment-head'>\n<h6 class='comment-name by-author'>" + a + "</a></h6>\n";
            return ath;
        } else {
            int numb = (int) (1 + Math.random() * 5);
            String ath = "<ul id='comments-list' class='comments-list'>\n<li><div class='comment-main-level'>\n<div class='comment-avatar'>\n<img src='" + numb + "' alt=''>\n</div>\n"
                    + "<div class='comment-box'\n><div class='comment-head'\n><h6 class='comment-name by-author'>" + a + "</a></h6>\n";

            return ath;

        }
    }

    public static String BuildDate() {
        //<span>Orario</span>            
//<i class="fa fa-reply"></i>
//<i class="fa fa-heart"></i>
//</div>
//<div class="comment-content">

        Date date = new Date();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        String data = day + "/" + month + "/" + year + " " + hour + ":" + minute;

        String Date = "<span>" + data + "</span>\n<i class='fa fa-reply'></i>\n<i class='fa fa-heart'></i>\n</div>\n<div class='comment-content'>";

        return Date;

    }

}
