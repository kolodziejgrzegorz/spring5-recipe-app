# spring5-recipe-app
[![CircleCI](https://circleci.com/gh/kolodziejgrzegorz/spring5-recipe-app.svg?style=svg)](https://circleci.com/gh/kolodziejgrzegorz/spring5-recipe-app)

> Simple Spring Boot app to display in ThyMeleaf recipes saved in database

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Features](#features)
* [Status](#status)
* [Inspiration](#inspiration)

## General info
This app can store recipe in H2 or MySql database and display in ThyMeleaf template.

## Technologies
* Java 1.8
* Maven 3.5.0
* Spring Boot 2.0.0
* Spring Framework 5.0.4
* Spring Data JPA
* H2 database 1.4.196
* Project Lombok 1.16.20
* Bootstrap 3.3.7-1

## Setup
1. Clone github repository <br />
2. Download maven dependencies <br />
3. Hit run button <br />
4. Optional MySql client for run app with MySql

* Run with H2
If there is no specific profile app will use an in-memory database which gets populated at startup with sample data.

* Run with MySql
Copy sql script from /resources/scripts/configure-mysql.sql and execute in MySql client. It will create two empty schemas and accounts, one for "dev" and one for "prod". Active profile "dev" in app will show hibernate action in console and allow to create script with database tables. This script also needs to be execute in MySql client

## Features
* show, add, edit, remove recipes and ingredients
* two database H2 or MySql
* add image to recipe
* three spring profiles: default, prod and dev
* bootstrap data at startup
* tests

## Status
Project is: _in progress_

## Inspiration
This app is based on Spring Framework 5: Beginner to Guru course from udemy.com <br />
https://www.udemy.com/spring-framework-5-beginner-to-guru/