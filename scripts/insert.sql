insert INTO object_types (objectTypeId, name, description) 
    values (1, 'user', 'no description'), (2, 'book', 'no description'), (3, 'author', 'no description'), (4, 'record', 'no description'),
    (5, 'character', 'no description'), (6, 'comment', 'no description');



insert INTO attributes (attributeId, name, attributeTypeId, description, properties) values (1, 'userId', 1, 'no description', 'no properties'),
    (2, 'login', 2, 'no description', 'no properties'), (3, 'email', 2, 'no description', 'no properties'), (4, 'fullName', 2, 'no description', 'no properties'), 
(5, 'password', 2, 'no description', 'no properties'), (6, 'sex', 1, 'no description', 'no properties'), (7, 'information', 2, 'no description', 'no properties');
insert INTO attributes (attributeId, name, attributeTypeId, description, properties) values (8, 'recordId', 1, 'no description', 'no properties'), 
(9, 'bookId', 1, 'no description', 'no properties'), (10, 'userId', 1, 'no description', 'no properties'), (11, 'date', 3, 'no description', 'no properties'), 
(12, 'rate', 1, 'no description', 'no properties'),(13, 'text', 2, 'no description', 'no properties'), (14, 'status', 1, 'no description', 'no properties'), 
(15, 'progress', 1, 'no description', 'no properties');
insert INTO attributes (attributeId, name, attributeTypeId, description, properties) values (16, 'authorId', 1, 'no description', 'no properties'), 
(17, 'name', 2, 'no description', 'no properties'), (18, 'surname', 2, 'no description', 'no properties'), (19, 'birthday', 1, 'no description', 'no properties'),
(20, 'death', 1, 'no description', 'no properties'), (21, 'information', 2, 'no description', 'no properties');
insert INTO attributes (attributeId, name, attributeTypeId, description, properties) values (22, 'bookId', 1, 'no description', 'no properties'), 
(23, 'authorId', 1, 'no description', 'no properties'), (24, 'yearPublication', 1, 'no description', 'no properties'), 
(25, 'annotation', 2, 'no description', 'no properties'), (26, 'name', 2, 'no description', 'no properties'), (27, 'series', 2, 'no description', 'no properties'), 
(28, 'numInSeries', 1, 'no description', 'no properties'), (29, 'genre', 2, 'no description', 'no properties');
insert INTO attributes (attributeId, name, attributeTypeId, description, properties) values (30, 'bookId', 1, 'no description', 'no properties'), 
(31, 'userId', 1, 'no description', 'no properties'), (32, 'date', 3, 'no description', 'no properties'), (33, 'like', 1, 'no description', 'no properties'),
(34, 'dislike', 1, 'no description', 'no properties'), (35, 'commentId', 1, 'no description', 'no properties');



insert INTO attribute_object_types (objectTypeId, attributeId, description) values (1, 1,  'no description'), (1, 2,  'no description'), 
(1, 3,  'no description'), (1, 4,  'no description'), (1, 5,  'no description'), (1, 6,  'no description'), (1, 7,  'no description'); 
insert INTO attribute_object_types (objectTypeId, attributeId, description) values (4, 8,  'no description'), (4, 9,  'no description'), (4, 10,  'no description'),
(4, 11,  'no description'), (4, 12,  'no description'), (4, 13,  'no description'), (4, 14,  'no description'), (4, 15,  'no description');
insert INTO attribute_object_types (objectTypeId, attributeId, description) values (3, 16,  'no description'), (3, 17,  'no description'), (3, 18,  'no description'),
(3, 19,  'no description'), (3, 20,  'no description'), (3, 21,  'no description');
insert INTO attribute_object_types (objectTypeId, attributeId, description) values (2, 22,  'no description'), (2, 23,  'no description'), (2, 24,  'no description'),
(2, 25,  'no description'), (2, 26,  'no description'), (2, 27,  'no description'), (2, 28,  'no description'), (2, 29,  'no description');
insert INTO attribute_object_types (objectTypeId, attributeId, description) values (6, 30,  'no description'), (6, 31,  'no description'), (6, 32,  'no description'),
(6, 33,  'no description'), (6, 34,  'no description'), (6, 35,  'no description');

