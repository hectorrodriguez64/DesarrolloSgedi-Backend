package co.edu.sena.adsi.jpa.entities;

import co.edu.sena.adsi.jpa.entities.Packages;
import co.edu.sena.adsi.jpa.entities.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-28T12:50:09")
@StaticMetamodel(Formalities.class)
public class Formalities_ { 

    public static volatile SingularAttribute<Formalities, Date> dateStart;
    public static volatile SingularAttribute<Formalities, String> id;
    public static volatile SingularAttribute<Formalities, Date> dateEnd;
    public static volatile SingularAttribute<Formalities, Users> idUsers;
    public static volatile SingularAttribute<Formalities, Packages> idPackages;

}