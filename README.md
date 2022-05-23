# Java Cafeteria
This project is based on the university cafeteria. 

## Project Outline

The project creates a administrator and customer interface. It allows the administrator to add, update and delete items in the cafeteria. It also provides the customer access to add, and delete items into their cart.

## Project Objective

The objective of the project to make the whole process from item listing to purchasing easier for both the customers and the administrator. 

## Project Description

In this project, the customers (students or the faculties) can select various dishes from the menu displayed by the user. The customer can make an order by adding the item to the cart and deleting the item from the cart. 

The administrator can make any changes in the menu, which means that they can add or delete an item as well as update the details of the item with ease. The cashier can also display any items by name.

## System Design

In this project, we have implemented a hierachical inheritance. This application has ‘edible’ as the main class, in which, ‘meal’ class and ‘drink’ class are inherited. The classes are located in different packages and the cafe class (the class that implements all the functions) is located in a separate package. Each function in the implementation has its own methods for easier access. We have also performed exceptions in this project. 

## User Experience

There will be two options provided in the interface, where we can select the admin or the customer. 

In order to keep the details of the cafeteria secure, the administration menu provides the admin permission to log in . In the administration menu, the administrator can add, delete, update and display items. 

In the User menu, the customers can add, delete and display items in their cart. They will also be able to print the bill.

## Conclusion

With this application, the administrator can add, delete and update the items in the cafeteria. The customer can add and delete the items in the cart. Hence, The objective of this project is achieved.
