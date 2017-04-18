package ent;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-11T21:49:57")
@StaticMetamodel(Comments.class)
public class Comments_ { 

    public static volatile SingularAttribute<Comments, String> date;
    public static volatile SingularAttribute<Comments, Long> dislike;
    public static volatile SingularAttribute<Comments, Long> commentId;
    public static volatile SingularAttribute<Comments, String> text;
    public static volatile SingularAttribute<Comments, Long> userId;
    public static volatile SingularAttribute<Comments, Long> bookId;
    public static volatile SingularAttribute<Comments, Long> likes;

}