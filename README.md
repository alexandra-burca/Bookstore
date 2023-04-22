# Bookstore
My first Java application, connected to a MySQL database, designed for a bookstore where a costumer can browse the products, leave reviews for books and place an order. The owner can view client and order information and export the database tables.


## Use Case Diagram

A simple diagram displaying the main functions of the app offer for the users.


![bs5](https://user-images.githubusercontent.com/127431550/233774616-86f91dda-7cdd-469f-9080-aebbaf3bc1b4.png)


## Login & Register


![bs1](https://user-images.githubusercontent.com/127431550/233771449-18980526-61db-449d-997e-7ca0cfa399ce.png)


In order to use the app, the user needs an account. For this, they can register by filling in the registration form and immediately create an account. 


![bs2](https://user-images.githubusercontent.com/127431550/233771452-1070667c-a39d-408c-b692-71e725fae93c.png)


## User Page

After login, the main user page is displayed, the the user can choose to browse the available books, read book reviews from other users, place an order or write a review.

The most complet page is the one for ordering.


![bs3](https://user-images.githubusercontent.com/127431550/233771896-e4a1355f-df69-40f1-93f8-4be626249f7f.png)


A window displaying the books available, connected to the database table. The user can search for a title, select the book and the quantity, then click the Add button. It will be added to the receipt made in the lower part of the window. The receipt can be saved from the print button. After add all the books, the order will be sent to the store owner with the Send! button.


## Admin Page

The store owner window has two pages, one for managing the products sold, and one for the users and their orders.


![bs4](https://user-images.githubusercontent.com/127431550/233772206-90b4877b-1f75-4c93-8353-317704d69714.png)


By filling in the details and clicking Add, a new item will be added to the table of books. When selecting an entry from the table, the details will be replaced with that, which can be easily changed from Edit. At any point, the owner can export the table into a .xls file. Similarly, the Manage orders contains a table of all the users that have registered, as well as all the orders placed.

