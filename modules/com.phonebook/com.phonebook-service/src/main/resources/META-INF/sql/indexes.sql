create index IX_F11295BF on PHONEBOOK_PhonebookAddress (groupId);
create index IX_2267F9C5 on PHONEBOOK_PhonebookAddress (userId, groupId);
create index IX_4228C87F on PHONEBOOK_PhonebookAddress (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_9BF762C1 on PHONEBOOK_PhonebookAddress (uuid_[$COLUMN_LENGTH:75$], groupId);