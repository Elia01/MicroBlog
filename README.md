# MicroBlog
School project for the creation of a microblog made to web application.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisities

What you need for the operation of the project and how to set it up.
First of all you need to create a Database called **MicroBlogDB**, it must be a database created in Derby.

Inside this database you will need to create several tables, as follows:

- **UTENTI**

```
CREATE TABLE UTENTI(
USERNAME varchar(500),
PASSWORD varchar(500),
SALT varchar(500),
ROLE varchar(500)
...
);

In this first table there are the three dots because it is still being defined, but for now these are the main data that must be entered inside.
```

- **POST**

```
CREATE TABLE POST(
IMAGE varchar(500),
AUTHOR varchar(500),
DATE varchar(500),
HOURS varchar(500),
TAGS varchar (500),
TITLE varchar(500),
SUBTITLE varchar(500),
CONTENT varchar(5000),
ID varchar (500)
);

At the moment the URL of the image is being saved, but you are trying to upload the images in a separate folder to facilitate the upload.
```

