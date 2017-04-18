package ent;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-11T21:49:57")
@StaticMetamodel(Books.class)
public class Books_ { 

    public static volatile SingularAttribute<Books, Long> date;
    public static volatile SingularAttribute<Books, String> annotation;
    public static volatile SingularAttribute<Books, String> series;
    public static volatile SingularAttribute<Books, String> genre;
    public static volatile SingularAttribute<Books, Long> authorId;
    public static volatile SingularAttribute<Books, String> bookName;
    public static volatile SingularAttribute<Books, Long> seriesNumber;
    public static volatile SingularAttribute<Books, Long> bookId;

}