package ent;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-11T21:49:57")
@StaticMetamodel(Records.class)
public class Records_ { 

    public static volatile SingularAttribute<Records, Long> recordId;
    public static volatile SingularAttribute<Records, String> date;
    public static volatile SingularAttribute<Records, Long> rate;
    public static volatile SingularAttribute<Records, Long> progress;
    public static volatile SingularAttribute<Records, String> text;
    public static volatile SingularAttribute<Records, Long> userId;
    public static volatile SingularAttribute<Records, Long> bookId;
    public static volatile SingularAttribute<Records, Long> status;

}