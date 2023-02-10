<p align="center">
<a href="https://pp-namias.github.io/Java-GUI/" target="blank"><img src="./Java-Rice-GUI-Plan/Java-Rice-Logo-3.png" alt="Java GUI Banner"/></a>
<a href="https://github.com/PP-Namias/Java-GUI/blob/master/LICENSE" target="blank"><img src="https://img.shields.io/github/license/PP-Namias/Java-GUI?style=flat-square" alt="Java-GUI license" /></a>
<a href="https://github.com/PP-Namias/Java-GUI/fork" target="blank"><img src="https://img.shields.io/github/forks/PP-Namias/Java-GUI?style=flat-square" alt="Java-GUI forks"/></a>
<a href="https://github.com/PP-Namias/Java-GUI/stargazers" target="blank"><img src="https://img.shields.io/github/stars/PP-Namias/Java-GUI?style=flat-square" alt="Java-GUI stars"/></a>
<a href="https://github.com/PP-Namias/Java-GUI/issues" target="blank"><img src="https://img.shields.io/github/issues/PP-Namias/Java-GUI?style=flat-square" alt="Java-GUI issues"/></a>
<a href="https://github.com/PP-Namias/Java-GUI/pulls" target="blank"><img src="https://img.shields.io/github/issues-pr/PP-Namias/Java-GUI?style=flat-square" alt="Java-GUI pull-requests"/></a>
</p>
<br>

# __Title: Java Rice__ - _An Interactive Food Ordering System_
## __Introduction__
Java Rice is a food ordering system designed to make the process of ordering food easier for users. The system is built using Java and Maven GUI, which provides an interactive and user-friendly experience. The purpose of this system is to allow users to order their favorite meals with ease and convenience.

## __Objectives__
  * To provide a platform where users can order food with just a few clicks.
  *	To make the process of food ordering fast and efficient.
  *	To provide users with an interactive and user-friendly experience.
  *	To provide a secure and reliable platform for food ordering.

## __Methodology__
*	The system will be built using Java programming language and Maven GUI for the front-end interface.
*	A database will be used to store all the information about the food items and orders.
*	The system will provide a user-friendly interface for users to place their orders.
*	The system will use secure payment methods to process the transactions.

## __Timeline__
- [x] Planning and Design Phase: 2 weeks
- [ ] Development Phase: 4 weeks
- [ ] Testing and Debugging Phase: 2 weeks
- [ ] Deployment Phase: 1 week

## __Limitations__
*	The system will only be available for use on devices with Java and Maven GUI installed.
*	The system will only support online payment methods.
*	The system will not provide delivery services.

## __Criteria__
*	Usability
*	Availability
*	Reliability
*	Maintainability
*	Security

## __Conclusion__
Java Rice is a food ordering system designed to provide users with a fast and convenient way to order food. The system is built using Java and Maven GUI, which provides an interactive and user-friendly experience. The system will provide a secure platform for food ordering and will be accessible on devices with Java and Maven GUI installed. The estimated timeline is 9 weeks.

## __References__
*	Java Programming Language Reference: Oracle Corporation
*	Maven GUI Reference: Apache Software Foundation

## __Appendix__
*	Detailed project plan
*	Technical specifications
*	UI Design
*	Database

## __Flowchart__
## __About Us__
<table border="hidden" align="center">
  <tr>
    <th><img align="center" src="./Java-Rice-GUI-Plan/cano.png" width="400" height="400" alt="Cano Rizz Pic"/><p align="center">Kurt Daniel S. Cano</p></th>
    <th><img align="center" src="./Java-Rice-GUI-Plan/caram.png" width="400" height="400" alt="Caram Rizz Pic"/><p align="center">Mike Rufino J. Caram II</p></th>
    <th><img align="center" src="./Java-Rice-GUI-Plan/lonoza.png" width="400" height="400" alt="Lonoza Rizz Pic"/><p align="center">Joshua O. Lonoza</p></th>
  </tr>  
</table>
<table border="hidden" align="center">
  <tr>
    <th><img align="center" src="./Java-Rice-GUI-Plan/llanes.png" width="400" height="400" alt="Llanes Rizz Pic"/><p align="center">Kevin A. Llanes</p></th>
    <th><img align="center" src="./Java-Rice-GUI-Plan/namias.png" width="400" height="400" alt="Namias Rizz Pic"/><p align="center">Jhon Keneth Ryan B. Namias</p></th>
  </tr>
</table>


## __Changelog__
This is compilation and record of development progress and notable changes made from inside-out and start-to-finish of the program or also known as changelogs.

## __Alpha Build:__ _February 3, 2023 - February 10, 2023_
__Planning and Designing Phase__, this week's development progress will be focused on finding references, brainstorming, and planning for program design, as well as making the most of available time to ensure efficient and progressive coding in subsequent weeks.

The Plan is to make a structure of what program will be created, it includes the design of possible future User Interface of the program that will be used for referencing and on top of that is to brainstorm a plan as well as Logo Designing. Created four initial databases named as: Products, Carts, Order, Sales.

## __UI and Logo Design__
<br>
<p align="center">
  <img src="./Java-Rice-GUI-Plan/Java-Rice-Logo.png" width="300" height="400" alt="Java GUI Banner"/>
  <br>
  <b>Java Rice Logo [Transparent]</b>
  <br>
  <br>  
  <img src="./Java-Rice-GUI-Plan/Java-Rice-Logo-3.png" alt="Java GUI Banner"/>
  <br>
  <b>Java Rice Banner with Logo [Transparent]</b>
  <br>
  <br>
  <img src="./Java-Rice-GUI-Plan/Java-Rice-Logo-5.png" alt="Java GUI Banner"/>
  <br>
  <b>Java Rice Banner [Transparent]</b>
  <br>
  <br>
  <img src="./Java-Rice-GUI-Plan/Java-Rice-5.jpg" alt="Java GUI Banner"/>
  <br>
  <b>Java Rice Main Form [Regular]</b>
  <br>
  <br>
  <img src="./Java-Rice-GUI-Plan/Java-Rice-Max-1.jpg" alt="Java GUI Banner"/>
  <br>
  <b>Java Rice Main Form [Maximize]</b>
  <br>
  <br>
  <img src="./Java-Rice-GUI-Plan/Java-Receipt-Default.jpg" width="500" height="800" alt="Java GUI Banner"/>
  <br>
  <b>Java Rice Receipt [Default]</b>
  <br>
  <br>
  <img src="./Java-Rice-GUI-Plan/Java-Receipt.jpg" width="500" height="800" alt="Java GUI Banner"/>
  <br>
  <b>Java Rice Receipt [Example]</b>
  <br>
</p>

## __Database__
```sql
CREATE TABLE IF NOT EXISTS Products (
	Product_ID SERIAL NOT NULL PRIMARY KEY,
	Name TEXT NOT NULL,
	Category TEXT NOT NULL,
	Store_num TEXT NOT NULL,
	Price DOUBLE PRECISION NOT NULL,
	Image OBJ NOT NULL,
	Popular BOOL NOT NULL
);
CREATE TABLE IF NOT EXISTS Cart (
	Product_ID SERIAL NOT NULL PRIMARY KEY,
	Name TEXT NOT NULL,
	Category TEXT NOT NULL,
	Store_num TEXT NOT NULL,
	Price DOUBLE PRECISION NOT NULL,
	Image OBJ NOT NULL,
	Quantity INT NOT NULL,
	Voucher TEXT NOT NULL,
	Discount DOUBLE NOT NULL
);
CREATE TABLE IF NOT EXISTS Order (
	Order_ID SERIAL NOT NULL PRIMARY KEY,
	Product_ID SERIAL NOT NULL,
	Name TEXT NOT NULL,
	Category TEXT NOT NULL,
	Store_num TEXT NOT NULL,
	Price DOUBLE PRECISION NOT NULL,
	Image OBJ NOT NULL,
	Quantity INT NOT NULL,
	Voucher TEXT NOT NULL,
	Discount DOUBLE NOT NULL
);
CREATE TABLE IF NOT EXISTS Sales (
	Order_ID SERIAL NOT NULL PRIMARY KEY,
	Product_ID SERIAL NOT NULL,
	Category TEXT NOT NULL,
	Store_num TEXT NOT NULL,
	Quantity INT NOT NULL,
	Date_processed DATE NOT NULL,
	Profit DOUBLE NOT NULL
);
```
<p align="center">
  <img src="./Java-Rice-GUI-Plan/Database.png" alt="Java GUI Banner"/>
  <br>
  <b>Java Rice Database [Relationship]</b>
  <br>
</p>

## __Forms__
- MainForm
- Cashier
- Receipt

## __Functions__
- Ordering system [multiple selections]
- Auto-generated search bar
- Receipt 
- Order logs
- Items order
- Order number
- QR Code [generator] [reader]
- Voucher Discounts

## __Color Palette__
- Main Background: #36414d
- Foreground: #898b8e
- Text (Dark): #36414d // Light Background
- Text (Light): #bcc7c4 // Dark Background
- Other:
  - #333333
  - #5182a1
- Cart: #808080
  - #63656a
- Footer: #0d0d0d
- Logo:
  - #cc3300 // Java
  - #cc6600 // Rice
