

Need Java installed in your machine
There is a java file AddressBookApp.java which contains the whole source code and implementation
mysql-connector.jar is used for connecting to SQL database from Java, search1.png for search button
create-addressbook-data.sql for creating the database and initializing with few values.
1. Run SQL script file in mysql using command
	 source /path/to/sql-file/create-addressbook-data.sql
2. This will create your database ADDRESSBOOK with tables, CONTACT, ADDRESS, PHONE, DATES.
3. Place all the codes, image files and jar files in one folder.
4. Open terminal and access that folder
5. Once inside it:
 	Run following code for compilation:
		javac -cp /home/ajit/DBDesign/Assignment1/mysql-connector.jar: AddressBookApp.java
	This will create the executable class files. It might prompt you for few Warnings, which you can ignore.
6. Execute the following code for runnning the application
	java -cp /home/ajit/DBDesign/Assignment1/mysql-connector.jar: AddressBookApp

And the application is up and running.
Yeahhhh!!!
