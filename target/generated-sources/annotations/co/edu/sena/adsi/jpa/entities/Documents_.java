package co.edu.sena.adsi.jpa.entities;

import co.edu.sena.adsi.jpa.entities.Alerts;
import co.edu.sena.adsi.jpa.entities.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-28T12:50:09")
@StaticMetamodel(Documents.class)
public class Documents_ { 

    public static volatile SingularAttribute<Documents, Date> date;
    public static volatile SingularAttribute<Documents, String> file;
    public static volatile SingularAttribute<Documents, String> name;
    public static volatile SingularAttribute<Documents, String> format;
    public static volatile SingularAttribute<Documents, Integer> folio;
    public static volatile SingularAttribute<Documents, String> description;
    public static volatile SingularAttribute<Documents, Double> weight;
    public static volatile SingularAttribute<Documents, String> location;
    public static volatile SingularAttribute<Documents, Integer> id;
    public static volatile SingularAttribute<Documents, Users> idUsers;
    public static volatile ListAttribute<Documents, Alerts> alertsList;

}