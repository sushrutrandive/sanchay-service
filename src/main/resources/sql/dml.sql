
-- occupation
INSERT INTO occupation (name,value) values('Private Sector Service',1);
INSERT INTO occupation (name,value) values('Public Sector Service',2);
INSERT INTO occupation (name,value) values('Government Service',3);
INSERT INTO occupation (name,value) values('Business',4);
INSERT INTO occupation (name,value) values('Professional',5);
INSERT INTO occupation (name,value) values('Agriculturist',6);
INSERT INTO occupation (name,value) values('Housewife',7);
INSERT INTO occupation (name,value) values('Retired',8);
INSERT INTO occupation (name,value) values('Student',9);
INSERT INTO occupation (name,value) values('Infant',10);
INSERT INTO occupation (name,value) values('Others',11);

-- relationship
INSERT INTO relationship (name,value) values('Self',1);
INSERT INTO relationship (name,value) values('Spouse',2);
INSERT INTO relationship (name,value) values('Son',3);
INSERT INTO relationship (name,value) values('Daughter',4);
INSERT INTO relationship (name,value) values('Father',5);
INSERT INTO relationship (name,value) values('Mother',6);
INSERT INTO relationship (name,value) values('Sibling',7);
INSERT INTO relationship (name,value) values('Other',8);

-- income sources

INSERT INTO income_source_types (name,value) values('Salary -Post Tax',1);
INSERT INTO income_source_types (name,value) values('Income From Investments',2);
INSERT INTO income_source_types (name,value) values('Rental Income',3);
INSERT INTO income_source_types (name,value) values('Business Income',4);
INSERT INTO income_source_types (name,value) values('Bonus',5);
INSERT INTO income_source_types (name,value) values('Incentives',6);
INSERT INTO income_source_types (name,value) values('Agricultural Income',7);
INSERT INTO income_source_types (name,value) values('Others',8);

-- Expense category

INSERT INTO expense_categories (name,value) values('Household',1);
INSERT INTO expense_categories (name,value) values('Lifestyle',2);
INSERT INTO expense_categories (name,value) values('Dependent',3);
INSERT INTO expense_categories (name,value) values('Insurance Premiums',4);
INSERT INTO expense_categories (name,value) values('Loan Servicing',5);
INSERT INTO expense_categories (name,value) values('Others',6);

-- Expense Sub Category

insert into expense_sub_categories (name,value,category_id) values ('Grocery & Toiletries',1,1);
insert into expense_sub_categories (name,value,category_id) values ('House - Rent, Maintenance, Repair',2,1);
insert into expense_sub_categories (name,value,category_id) values ('Conveyance, Fuel & Maintenance',3,1);
insert into expense_sub_categories (name,value,category_id) values ('Medicines / Doctor / Healthcare',4,1);
insert into expense_sub_categories (name,value,category_id) values ('Electricity / Water / Labour / AMCs',5,1);
insert into expense_sub_categories (name,value,category_id) values ('Mobile / Telephone / Internet',6,1);

insert into expense_sub_categories (name,value,category_id) values ('Clothes & Accessories',7,2);
insert into expense_sub_categories (name,value,category_id) values ('Shopping, Gifts, Whitegoods, Gadgets',8,2);
insert into expense_sub_categories (name,value,category_id) values ('Dining / Movies / Sports',9,2);
insert into expense_sub_categories (name,value,category_id) values ('Personal Care / Others',10,2);
insert into expense_sub_categories (name,value,category_id) values ('Coach - Financial, Fitness, Personal',11,2);
insert into expense_sub_categories (name,value,category_id) values ('Travel & Annual Vacations',12,2);

insert into expense_sub_categories (name,value,category_id) values ('Children''s Schooling/College',13,3);
insert into expense_sub_categories (name,value,category_id) values ('Contribution to Parents, Siblings etc',14,3);
insert into expense_sub_categories (name,value,category_id) values ('Life Insurance (Term)',15,4);
insert into expense_sub_categories (name,value,category_id) values ('General Insurance',16,4);
insert into expense_sub_categories (name,value,category_id) values ('Home Loan EMI',17,5);
insert into expense_sub_categories (name,value,category_id) values ('Vehicle Loan EMI',18,5);
insert into expense_sub_categories (name,value,category_id) values ('Personal Loan EMI',19,5);
insert into expense_sub_categories (name,value,category_id) values ('Other',20,6);
insert into expense_sub_categories (name,value,category_id) values ('Other Loan EMI',21,5);

--frequencies
INSERT INTO frequencies (name,value,factor) values('Monthly',1,12);
INSERT INTO frequencies (name,value,factor) values('Quarterly',2,4);
INSERT INTO frequencies (name,value,factor) values('Semi Annually',3,2);
INSERT INTO frequencies (name,value,factor) values('Annually',4,1);

--assumptions

INSERT INTO assumptions (name,value) values('Inflation(%)',8);
INSERT INTO assumptions (name,value) values('Education Inflation(%)',10);
INSERT INTO assumptions (name,value) values('Equity(%)',12);
INSERT INTO assumptions (name,value) values('Mutual Funds(%)',12);
INSERT INTO assumptions (name,value) values('Debt(%)',9);
INSERT INTO assumptions (name,value) values('Real Estate(%)',9);
INSERT INTO assumptions (name,value) values('ULIP(%)',7);
INSERT INTO assumptions (name,value) values('Endowment(%)',5);
INSERT INTO assumptions (name,value) values('Gold(%)',8);

--fixed_income
INSERT INTO fixed_income (name,value) values('Fixed Deposit',1);
INSERT INTO fixed_income (name,value) values('Recurring Deposit',2);
INSERT INTO fixed_income (name,value) values('National Saving Certificate',3);
INSERT INTO fixed_income (name,value) values('Kisan Vikas Patra',4);
INSERT INTO fixed_income (name,value) values('PPF',5);
INSERT INTO fixed_income (name,value) values('EPF',6);
INSERT INTO fixed_income (name,value) values('Sukanya Samridhi Yojana',7);
INSERT INTO fixed_income (name,value) values('NPS',8);
INSERT INTO fixed_income (name,value) values('Tax Free Bonds',9);

-- Interest Calc Methods
--INSERT INTO interest_calc_methods (name,value) values('Simple Interest',1);
INSERT INTO interest_calc_methods (name,value) values('Compound Monthly',2);
INSERT INTO interest_calc_methods (name,value) values('Compound Quarterly',3);
INSERT INTO interest_calc_methods (name,value) values('Compound Semi Annually',4);
INSERT INTO interest_calc_methods (name,value) values('Compound Annually',5);

-- Interest Payout options
INSERT INTO interest_payout_options (name,value) values('Monthly',1);
INSERT INTO interest_payout_options (name,value) values('Quarterly',2);
INSERT INTO interest_payout_options (name,value) values('Semi Annually',3);
INSERT INTO interest_payout_options (name,value) values('Annually',4);
INSERT INTO interest_payout_options (name,value) values('cumulative',5);

-- Investment_mode
INSERT INTO investment_mode (name,value) values('One Time',1);
INSERT INTO investment_mode (name,value) values('SIP/Monthly',2);
INSERT INTO investment_mode (name,value) values('Adhoc',3);
INSERT INTO investment_mode (name,value) values('Yearly',4);

-- Interest Rate change
INSERT INTO interest_rate_change (start_date,end_date,ppf_rate,epf_rate,ssy_rate,kvp_rate) values(STR_TO_DATE('01-04-2016', '%d-%m-%Y'),STR_TO_DATE('30-06-2016', '%d-%m-%Y'),8.1,8.65,8.6,7.8);
INSERT INTO interest_rate_change (start_date,end_date,ppf_rate,epf_rate,ssy_rate,kvp_rate) values(STR_TO_DATE('01-07-2016', '%d-%m-%Y'),STR_TO_DATE('30-09-2016', '%d-%m-%Y'),8.1,8.65,8.6,7.8);
INSERT INTO interest_rate_change (start_date,end_date,ppf_rate,epf_rate,ssy_rate,kvp_rate) values(STR_TO_DATE('01-10-2016', '%d-%m-%Y'),STR_TO_DATE('31-12-2016', '%d-%m-%Y'),8,8.65,8.5,7.7);
INSERT INTO interest_rate_change (start_date,end_date,ppf_rate,epf_rate,ssy_rate,kvp_rate) values(STR_TO_DATE('01-01-2017', '%d-%m-%Y'),STR_TO_DATE('31-03-2017', '%d-%m-%Y'),8,8.65,8.5,7.7);
INSERT INTO interest_rate_change (start_date,end_date,ppf_rate,epf_rate,ssy_rate,kvp_rate) values(STR_TO_DATE('01-04-2017', '%d-%m-%Y'),STR_TO_DATE('30-06-2017', '%d-%m-%Y'),7.9,8.55,8.4,7.6);
INSERT INTO interest_rate_change (start_date,end_date,ppf_rate,epf_rate,ssy_rate,kvp_rate) values(STR_TO_DATE('01-07-2017', '%d-%m-%Y'),STR_TO_DATE('30-09-2017', '%d-%m-%Y'),7.8,8.55,8.3,7.5);
INSERT INTO interest_rate_change (start_date,end_date,ppf_rate,epf_rate,ssy_rate,kvp_rate) values(STR_TO_DATE('01-10-2017', '%d-%m-%Y'),STR_TO_DATE('31-12-2017', '%d-%m-%Y'),7.8,8.55,8.3,7.5);
INSERT INTO interest_rate_change (start_date,end_date,ppf_rate,epf_rate,ssy_rate,kvp_rate) values(STR_TO_DATE('01-01-2018', '%d-%m-%Y'),STR_TO_DATE('31-03-2018', '%d-%m-%Y'),7.6,8.55,8.1,7.3);


-- PPF options

INSERT INTO options_list (option_name,name,value) values('PPF_CONTRIBUTION_FREQUENCY','Monthly - On or before 5th of every month',1);
INSERT INTO options_list (option_name,name,value) values('PPF_CONTRIBUTION_FREQUENCY','Monthly - After 5th of every month',2);
INSERT INTO options_list (option_name,name,value) values('PPF_CONTRIBUTION_FREQUENCY','Annually -Start of the financial year',3);
INSERT INTO options_list (option_name,name,value) values('PPF_CONTRIBUTION_FREQUENCY','Annually -End of the financial year',4);

INSERT INTO options_list (option_name,name,value) values('PPF_EXTENSION_OPTIONS','No extension',1);
INSERT INTO options_list (option_name,name,value) values('PPF_EXTENSION_OPTIONS','Extension with fresh contributions',2);
INSERT INTO options_list (option_name,name,value) values('PPF_EXTENSION_OPTIONS','Extension without fresh contributions',3);

INSERT INTO options_list (option_name,name,value) values('PPF_EXTENSION_PERIOD','5 Years',5);
INSERT INTO options_list (option_name,name,value) values('PPF_EXTENSION_PERIOD','10 Years',10);
INSERT INTO options_list (option_name,name,value) values('PPF_EXTENSION_PERIOD','15 Years',15);
INSERT INTO options_list (option_name,name,value) values('PPF_EXTENSION_PERIOD','20 Years',20);
INSERT INTO options_list (option_name,name,value) values('PPF_EXTENSION_PERIOD','25 Years',25);
INSERT INTO options_list (option_name,name,value) values('PPF_EXTENSION_PERIOD','30 Years',30);
INSERT INTO options_list (option_name,name,value) values('PPF_EXTENSION_PERIOD','35 Years',35);
INSERT INTO options_list (option_name,name,value) values('PPF_EXTENSION_PERIOD','40 Years',40);
INSERT INTO options_list (option_name,name,value) values('PPF_EXTENSION_PERIOD','45 Years',45);

INSERT INTO options_list (option_name,name,value) values('SSY_DEPOSIT_FREQUENCY_OPTIONS','Monthly - On or before 10th of every month',1);
INSERT INTO options_list (option_name,name,value) values('SSY_DEPOSIT_FREQUENCY_OPTIONS','Monthly - After 10th of every month',2);
INSERT INTO options_list (option_name,name,value) values('SSY_DEPOSIT_FREQUENCY_OPTIONS','Annually -Start of the financial year',3);
INSERT INTO options_list (option_name,name,value) values('SSY_DEPOSIT_FREQUENCY_OPTIONS','Annually -End of the financial year',4);


-- Test Data
/*INSERT INTO user_details(first_name,last_name,email,birth_date,mobile_no) 
values ('Sushrut','Randive','sushrandive@gmail.com',STR_TO_DATE('16-10-1982', '%d-%m-%Y'),8888109952 );
INSERT INTO login_details(user_name,password,user_id) values
('sushrandive@gmail.com','sush@123',1);
INSERT INTO family_details(user_id,first_name,last_name,email,birth_date,mobile_no,relation,occupation,is_user) 
values (1,'Sushrut','Randive','sushrandive@gmail.com',STR_TO_DATE('16-10-1982', '%d-%m-%Y'),8888109952,1,1,'Y' );
INSERT INTO family_details(user_id,first_name,last_name,email,birth_date,mobile_no,relation,occupation,is_user) 
values (1,'Priyanka','Randive','priya.phalle@gmail.com',STR_TO_DATE('18-08-1986', '%d-%m-%Y'),8888110879,2,1,'N' );
INSERT INTO family_details(user_id,first_name,last_name,email,birth_date,mobile_no,relation,occupation,is_user) 
values (1,'Shravya','Randive',NULL,STR_TO_DATE('08-11-2012', '%d-%m-%Y'),NULL,4,10,'N' );
INSERT INTO income_sources(user_id,type,frequency,member_id,income,annual_income,remark)
values(1,1,1,1,200000,2400000,'');*/