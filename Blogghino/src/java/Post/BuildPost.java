/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Post;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 *
 * @author Elia
 * @version 1.0
 */
public class BuildPost {

    public static String BuildTitle(String ttl) {
        //<div class="description">
        //<h1>Mastering the Language</h1>

        String Title = "<div class='description'><h1>" + ttl + "<h1>";

        return Title;

    }

    public static String BuildSubTitle(String subttl) {
        //<h2>Java is not the same as JavaScript</h2>

        String SubTitle = "<h2>" + subttl + "</h2>";

        return SubTitle;

    }

    public static String BuildContent(String cont) {
        //<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad eum dolorum architecto obcaecati enim dicta praesentium, quam nobis! Neque ad aliquam facilis numquam. Veritatis, sit.</p>
        //<p class="read-more">
        //<a href="#">Read More</a>
        //</p>
        //</div>
        //</div>
        //<!--This is the end line-->

        String Content = "<p>" + cont + "</p><p class='read-more'><a href='#'>Read More</a></p></div></div>" + "\n" + "<!--This is the end line-->";

        return Content;

    }

    public static String BuildImage(String link) {
        //<div class="blog-card alt">
        //<div class="meta">
        //<div class="photo" style="background-image: url(https://storage.googleapis.com/chydlx/codepen/blog-cards/image-2.jpg)">
        //</div>
        int range = (int) (Math.random() * 1);
        if (range == 0) {
            String Image = "<div class='blog-card alt'><div class='meta'>"
                    + "<div class='photo' style='background-image: url(" + link + ")'></div>";
            return Image;
        } else {
            String Image = "<div class='blog-card'><div class='meta'>"
                    + "<div class='photo' style='background-image: url(" + link + ")'></div>";
            return Image;
        }

    }

    public static String BuildAuthor(String a) {
        //<ul class="details">
        //<li class="author"><a href="#">Admin</a></li>
        String ath = "<ul class='details'><li class='author'><a href='#'>" + a + "</a></li>";

        return ath;

    }

    public static String BuildDate() {
        //<li class="date">July. 15, 2015</li>

        Date date = new Date();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        String data = day + "/" + month + "/" + year;

        String Date = "<li class='date'>" + data + "</li>";

        return Date;

    }

    public static String BuildHour() {
        //<li class="hour">13:12</li>

        Date date = new Date();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        String ch = hour + ":" + minute;

        String h = "<li class='hour'>" + ch + "</li>";

        return h;
    }

    public static String BuildTags(String tag) {
        //<li class="tags"></li>
        //</ul>
        //</div>

        String Tags = "<li class='tags'>" + tag + "</li></ul></div>";

        return Tags;

    }

}
