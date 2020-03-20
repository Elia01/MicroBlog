/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Post;

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

        String Content = "<p>" + cont + "</p><p class='read-more'><a href='#'>Read More</a></p></div></div>";

        return Content;

    }

    public static String BuildImage(String link) {
        //<div class="blog-card alt">
        //<div class="meta">
        //<div class="photo" style="background-image: url(https://storage.googleapis.com/chydlx/codepen/blog-cards/image-2.jpg)">
        //</div>
        String Image = "<div class='blog-card alt'><div class='meta'>"
                + "<div class='photo' style='background-image: url(" + link + ")'>";

        return Image;
    }

    public static String BuildAuthor(String a) {
        //<ul class="details">
        //<li class="author"><a href="#">Admin</a></li>
        String ath = "<ul class='details'><li class='author'><a href='#'>" + a + "</a></li>";

        return ath;

    }

    public static String BuildDate() {
        //<li class="date">July. 15, 2015</li>

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	LocalDate localDate = LocalDate.now(); //20/03/2020

        String Date = "<li class='date'>" + localDate+ "</li>";
        
        return Date;

    }

    public static String BuildHour() {
        //<li class="hour">13:12</li>

        Date date = new Date(); 
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        int ch = calendar.get(Calendar.HOUR_OF_DAY);

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
