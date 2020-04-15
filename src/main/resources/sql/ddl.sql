CREATE TABLE user_details (
					ID BIGINT NOT NULL AUTO_INCREMENT, 
					name VARCHAR(150)NOT NULL,					 
					email VARCHAR(50) NOT NULL,
					email_verified VARCHAR(1) NOT NULL DEFAULT 'N',
					image_url VARCHAR(255),	
					password VARCHAR(255),	
					provider VARCHAR(255) NOT NULL,
					provider_id VARCHAR(255),
    				create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    				modify_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    				update_counter int NOT NULL DEFAULT 0,
    				deleted VARCHAR(1) NOT NULL DEFAULT 'N',
					first_login VARCHAR(1) NOT NULL DEFAULT 'N',
    				PRIMARY KEY (ID));
    				
/*CREATE TABLE login_details (
					ID BIGINT NOT NULL AUTO_INCREMENT, 
					user_name VARCHAR(50) NOT NULL, 
					password VARCHAR(20)NOT NULL,
    				user_id int NOT NULL,
    				create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    				modify_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    				update_counter int NOT NULL DEFAULT 0,
    				deleted VARCHAR(1) NOT NULL DEFAULT 'N',
    				FOREIGN KEY (user_id) REFERENCES user_details(id),
    				PRIMARY KEY (ID));
CREATE TABLE tokens (
					ID BIGINT NOT NULL AUTO_INCREMENT, 
					user_name VARCHAR(50) NOT NULL, 
					token VARCHAR(200)NOT NULL,    				
    				create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    				modify_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    				update_counter int NOT NULL DEFAULT 0,
    				deleted VARCHAR(1) NOT NULL DEFAULT 'N',    				
    				PRIMARY KEY (ID));*/
/*ALTER TABLE user_details ADD active VARCHAR(1) NOT NULL DEFAULT 'N';
ALTER TABLE user_details ADD relation INT NOT NULL DEFAULT 0;
ALTER TABLE user_details ADD occupation INT NOT NULL DEFAULT 0; ;*/

CREATE TABLE relationship (
					ID BIGINT NOT NULL AUTO_INCREMENT, 					 
					name VARCHAR(30)NOT NULL,    	
					value int NOT NULL,  
    				create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    				modify_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    				update_counter int NOT NULL DEFAULT 0,
    				deleted VARCHAR(1) NOT NULL DEFAULT 'N',    				
    				PRIMARY KEY (ID));
CREATE TABLE occupation (
					ID BIGINT NOT NULL AUTO_INCREMENT, 					 
					name VARCHAR(30)NOT NULL,   
					value int NOT NULL,  
    				create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    				modify_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    				update_counter int NOT NULL DEFAULT 0,
    				deleted VARCHAR(1) NOT NULL DEFAULT 'N',    				
    				PRIMARY KEY (ID));
    			 
CREATE TABLE family_details (
					ID BIGINT NOT NULL AUTO_INCREMENT, 
    				user_id BIGINT NOT NULL,
    				name VARCHAR(150) NOT NULL,	 
    				email VARCHAR(50),
    				birth_date DATE ,
    				mobile_no BIGINT ,
    				relation int NOT NULL,
    				occupation int NOT NULL,
    				create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    				modify_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    				update_counter int NOT NULL DEFAULT 0,
    				deleted VARCHAR(1) NOT NULL DEFAULT 'N',
    				is_user VARCHAR(1) NOT NULL DEFAULT 'N',
    				CONSTRAINT FOREIGN KEY (user_id) REFERENCES user_details(id),    				
    				PRIMARY KEY (ID));
 CREATE TABLE income_source_types (
					ID BIGINT NOT NULL AUTO_INCREMENT, 					 
					name VARCHAR(30)NOT NULL,   
					value int NOT NULL,  
    				create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    				modify_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    				update_counter int NOT NULL DEFAULT 0,
    				deleted VARCHAR(1) NOT NULL DEFAULT 'N',    				
    				PRIMARY KEY (ID));
  CREATE TABLE expense_categories (
					ID BIGINT NOT NULL AUTO_INCREMENT, 					 
					name VARCHAR(30)NOT NULL,   
					value int NOT NULL,  
    				create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    				modify_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    				update_counter int NOT NULL DEFAULT 0,
    				deleted VARCHAR(1) NOT NULL DEFAULT 'N',    				
    				PRIMARY KEY (ID));
  CREATE TABLE expense_sub_categories (
					ID BIGINT NOT NULL AUTO_INCREMENT, 					 
					name VARCHAR(50)NOT NULL,  
					category_id BIGINT NOT NULL,
					value int NOT NULL,  
    				create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    				modify_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    				update_counter int NOT NULL DEFAULT 0,
    				deleted VARCHAR(1) NOT NULL DEFAULT 'N',    
    				FOREIGN KEY (category_id) REFERENCES expense_categories(ID), 
    				PRIMARY KEY (ID));
 CREATE TABLE frequencies (
					ID BIGINT NOT NULL AUTO_INCREMENT, 					 
					name VARCHAR(30)NOT NULL,   
					value int NOT NULL,  
					factor int NOT NULL, 
    				create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    				modify_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    				update_counter int NOT NULL DEFAULT 0,
    				deleted VARCHAR(1) NOT NULL DEFAULT 'N',    				
    				PRIMARY KEY (ID));
CREATE TABLE income_sources (
					ID BIGINT NOT NULL AUTO_INCREMENT, 
					user_id BIGINT NOT NULL,
					type BIGINT NOT NULL,   
					frequency BIGINT NOT NULL,   
					member_id BIGINT NOT NULL,
					income BIGINT NOT NULL,
					annual_income BIGINT NOT NULL,
					remark VARCHAR(100),  
    				create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    				modify_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    				update_counter int NOT NULL DEFAULT 0,
    				deleted VARCHAR(1) NOT NULL DEFAULT 'N', 
    				FOREIGN KEY (member_id) REFERENCES family_details(ID), 
    				CONSTRAINT FOREIGN KEY (user_id) REFERENCES user_details(id), 
    				PRIMARY KEY (ID));
 CREATE TABLE expenses (
					ID BIGINT NOT NULL AUTO_INCREMENT, 
					user_id BIGINT NOT NULL,
					category BIGINT NOT NULL,   
					frequency BIGINT NOT NULL,   
					sub_category BIGINT NOT NULL,
					amount BIGINT NOT NULL,
					annual_amount BIGINT NOT NULL,
					remark VARCHAR(100),  
    				create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    				modify_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    				update_counter int NOT NULL DEFAULT 0,
    				deleted VARCHAR(1) NOT NULL DEFAULT 'N',     				
    				CONSTRAINT FOREIGN KEY (user_id) REFERENCES user_details(id), 
    				PRIMARY KEY (ID));
CREATE TABLE assumptions (
					ID BIGINT NOT NULL AUTO_INCREMENT, 					 
					name VARCHAR(30)NOT NULL,   
					value DECIMAL(4,2) NOT NULL,  
    				create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    				modify_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    				update_counter int NOT NULL DEFAULT 0,
    				deleted VARCHAR(1) NOT NULL DEFAULT 'N',    				
    				PRIMARY KEY (ID));
CREATE TABLE fixed_income (
					ID BIGINT NOT NULL AUTO_INCREMENT, 					 
					name VARCHAR(30)NOT NULL,   
					value DECIMAL(4,2) NOT NULL,  
    				create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    				modify_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    				update_counter int NOT NULL DEFAULT 0,
    				deleted VARCHAR(1) NOT NULL DEFAULT 'N',    				
    				PRIMARY KEY (ID));
CREATE TABLE interest_calc_methods (
					ID BIGINT NOT NULL AUTO_INCREMENT, 					 
					name VARCHAR(30)NOT NULL,   
					value DECIMAL(4,2) NOT NULL,  
    				create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    				modify_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    				update_counter int NOT NULL DEFAULT 0,
    				deleted VARCHAR(1) NOT NULL DEFAULT 'N',    				
    				PRIMARY KEY (ID));    	
CREATE TABLE interest_payout_options (
					ID BIGINT NOT NULL AUTO_INCREMENT, 					 
					name VARCHAR(30)NOT NULL,   
					value DECIMAL(4,2) NOT NULL,  
    				create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    				modify_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    				update_counter int NOT NULL DEFAULT 0,
    				deleted VARCHAR(1) NOT NULL DEFAULT 'N',    				
    				PRIMARY KEY (ID));  
CREATE TABLE investment_mode (
					ID BIGINT NOT NULL AUTO_INCREMENT, 					 
					name VARCHAR(30)NOT NULL,   
					value DECIMAL(4,2) NOT NULL,  
    				create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    				modify_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    				update_counter int NOT NULL DEFAULT 0,
    				deleted VARCHAR(1) NOT NULL DEFAULT 'N',    				
    				PRIMARY KEY (ID));  
CREATE TABLE interest_rate_change (
					ID BIGINT NOT NULL AUTO_INCREMENT, 		
					start_date DATE NOT NULL,
					end_date DATE NOT NULL,
					ppf_rate DECIMAL(4,2) NOT NULL,  
					epf_rate DECIMAL(4,2) NOT NULL,  
					ssy_rate DECIMAL(4,2) NOT NULL,  
					kvp_rate DECIMAL(4,2) NOT NULL,  
    				create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    				modify_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    				update_counter int NOT NULL DEFAULT 0,
    				deleted VARCHAR(1) NOT NULL DEFAULT 'N',    				
    				PRIMARY KEY (ID));  

CREATE TABLE options_list (
					ID BIGINT NOT NULL AUTO_INCREMENT, 
					option_name VARCHAR(30) NOT NULL,					 
					name VARCHAR(50) NOT NULL,   
					value DECIMAL(4,2) NOT NULL,  
    				create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    				modify_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    				update_counter int NOT NULL DEFAULT 0,
    				deleted VARCHAR(1) NOT NULL DEFAULT 'N',    				
    				PRIMARY KEY (ID));    	
					
/*CREATE TABLE stock_details (
					ID BIGINT NOT NULL AUTO_INCREMENT, 
					SYMBOL VARCHAR(50)NOT NULL, 
					company_name VARCHAR(50) NOT NULL, 
					series VARCHAR(50) NOT NULL,
    				listing_date DATE NOT NULL,
    				paid_up_value INT NOT NULL ,
					market_lot INT NOT NULL ,
					ISIN VARCHAR(50) NOT NULL, 
					face_value INT NOT NULL ,
    				create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    				modify_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,    				
    				PRIMARY KEY (ID));
    				
CREATE TABLE stock_prices (
					ID BIGINT NOT NULL AUTO_INCREMENT, 
					SYMBOL VARCHAR(50)NOT NULL, 	
					series VARCHAR(50) NOT NULL,
					open DECIMAL(18,2) NOT NULL,  
					high DECIMAL(18,2) NOT NULL,  
					low DECIMAL(18,2) NOT NULL,  
					close DECIMAL(18,2) NOT NULL,  
					last DECIMAL(18,2) NOT NULL,  
					PREVCLOSE DECIMAL(18,2) NOT NULL, 
					TOTTRDQTY BIGINT NOT NULL,
					TOTTRDVAL DECIMAL(38,2) NOT NULL, 
    				TIMESTAMP DATE NOT NULL,
    				TOTALTRADES BIGINT NOT NULL ,					
					ISIN VARCHAR(50) NOT NULL, 					
    				create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    				modify_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,    				
    				PRIMARY KEY (ID));
load data local infile 'file.csv' into table stock_details
 fields terminated by ','
 lines terminated by '\n'
 (SYMBOL, company_name, series, listing_date,paid_up_value,market_lot,ISIN,face_value )
 */   				
    				


 