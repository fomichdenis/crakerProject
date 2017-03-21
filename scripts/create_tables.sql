create table object_types (
    objectTypeId integer not null primary key,
    name varchar(50) not null,
    description varchar(300)   
);
create table attributes (
    attributeId integer not null primary key,
    attributeTypeId integer not null,
    name varchar(50),
    description varchar(300),
    properties varchar(300)
);
create table objects (
    objectId integer not null primary key,
    objectTypeId integer not null,
    name varchar(50) not null,
    description varchar(300)
);
create table parameters (
    paramId integer not null primary key,
    attributeId integer not null,
    objectId integer not null,
    textValue varchar(3000),
    numValue integer,
    date varchar(300),
    referenceId integer
);
create table attribute_object_types (
    objectTypeID integer not null,
    attributeID integer not null,
    description varchar(300)
);