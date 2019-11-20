create table PHONEBOOK_PhonebookAddress (
	uuid_ VARCHAR(75) null,
	addressId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	email VARCHAR(75) null,
	mobileNr VARCHAR(75) null
);