/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jersey.domain;

/**
 *
 * @author Elia
 */
import java.util.Objects;
import org.json.JSONObject;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.json.JSONException;


@XmlRootElement
@XmlType(propOrder = { "id", "image", "author", "date", "hours", "tags", "title", "subtitle", "content"  })
public class Post {

      
	public static final String ID_KEY = "id";
        public static final String IMAGE_KEY = "urlImage";
        public static final String AUTHOR_KEY = "userName";
        public static final String DATE_KEY = "dd/MM/yy";
        public static final String HOURS_KEY = "hh:mm";
        public static final String TAGS_KEY = "tags";
        public static final String TITLE_KEY = "postTitle";
        public static final String SUBTITLE_KEY = "postSubtitle";
        public static final String CONTENT_KEY = "postContent";
	
        int id;
	String image;
	String author;
	String date;
	String hours;	
	String tags;
        String title;
	String subtitle;	
	String content;

    Post() {
        //To change body of generated methods, choose Tools | Templates.
    }

    public Post(int id, String image, String author, String date, String hours, String tags, String title, String subtitle, String content) {
        this.id = id;
        this.image = image;
        this.author = author;
        this.date = date;
        this.hours = hours;
        this.tags = tags;
        this.title = title;
        this.subtitle = subtitle;
        this.content = content;
    }


    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public String toJSON() throws Exception{
        JSONObject obj = new JSONObject();
        obj.put(ID_KEY, this.id);
        obj.put(IMAGE_KEY, this.image);
        obj.put(AUTHOR_KEY, this.author);
        obj.put(DATE_KEY, this.date);
        obj.put(HOURS_KEY,this.hours);
        obj.put(TAGS_KEY, this.tags);
        obj.put(TITLE_KEY, this.title);
        obj.put(SUBTITLE_KEY, this.subtitle);
        obj.put(CONTENT_KEY, this.content);
        return obj.toString();
    }
    
    public JSONObject toJSONObject() throws JSONException{
        JSONObject obj = new JSONObject();
        obj.put(ID_KEY, id);
        obj.put(IMAGE_KEY, image);
        obj.put(AUTHOR_KEY, author);
        obj.put(DATE_KEY, date);
        obj.put(HOURS_KEY, hours);
        obj.put(TAGS_KEY, tags);
        obj.put(TITLE_KEY, title);
        obj.put(SUBTITLE_KEY, subtitle);
        obj.put(CONTENT_KEY, content);
        return obj;
    }
	
        

	
        
         @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", image=" + image + ", author=" + author + ", date=" + date + ", hours=" + hours + ", tags=" + tags + ", title=" + title + ", subtitle=" + subtitle + ", content=" + content + '}';
    }

    
    
}
