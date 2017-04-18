package ent;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-17T00:55:09")
@StaticMetamodel(Authors.class)
public class Authors_ { 

    public static volatile SingularAttribute<Authors, BigInteger> deathyear;
    public static volatile SingularAttribute<Authors, BigInteger> yearbirthday;
    public static volatile SingularAttribute<Authors, String> authorname;
    public static volatile SingularAttribute<Authors, String> information;
    public static volatile SingularAttribute<Authors, Long> authorid;
    public static volatile SingularAttribute<Authors, String> authorsurname;

}