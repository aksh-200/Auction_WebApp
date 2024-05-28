first we need to fill database in following order to create admin account .






INSERT INTO `user_type` VALUES (1,'Admin'),(3,'Bidder'),(2,'Seller');



INSERT INTO `question_table` VALUES (4,' What was your first car?'),(6,'In which year you completed your graduation?'),(5,'What elementary school did you attend?'),(3,'What is the name of your favourite movie?'),(1,'What is the name of your first pet?'),(2,'What is your favourite color?'),(7,'What is your mother\'s maiden name?'),(8,'Which  is your favourite vacation spot?');


INSERT INTO `category` VALUES (1,'antique'),(2,'painting'),(3,'artefact'),(4,'furniture'),(5,'comics or cards limited edition'),
(6,'sports memorabilia'),(7,'Signed Memorabilia'),(8,'Other');




INSERT INTO `user_table` VALUES (1,1,'Random','Person','random@gmail.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'approved',4,'audi','admin','admin@123');


INSERT INTO user_table (user_id,user_type_id ,fname,lname,
email,mobile,state,city,pincode,address,gender,pan_card_number,
pan_card_image,account_status,q_id,answer,username,password

) VALUES (1,1,'Rohan','Wagh','random@gmail.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'approved',4,'audi','admin','THfcvhwawA07xdEONcABpQYXRyH4g0Zr1p8mjZBY6is=');




users
we need admin password encrypted so we copy sellers encrypted password



admin  root123**

ENCRYPT(Encryption of root123**) PASSWORD FOR ADMMIN   THfcvhwawA07xdEONcABpQYXRyH4g0Zr1p8mjZBY6is=

