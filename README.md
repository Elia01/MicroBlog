# MicroBlog
School project for the creation of a microblog made to web application.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisities

What you need for the operation of the project and how to set it up.
First of all you need to create a Database called **MicroBlogDB**, it must be a database created in Derby.

Inside this database you will need to create several tables, as follows:

-**UTENTI**

```
CREATE TABLE **UTENTI**(
PersonID int,
LastName varchar(255),
FirstName varchar(255),
Address varchar(255),
City varchar(255)
);

```
