package co.edu.sena.adsi.jpa.entities;

import co.edu.sena.adsi.jpa.entities.Alerts;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-28T12:50:09")
@StaticMetamodel(RetentionTables.class)
public class RetentionTables_ { 

    public static volatile SingularAttribute<RetentionTables, String> subSerie;
    public static volatile SingularAttribute<RetentionTables, Date> date;
    public static volatile SingularAttribute<RetentionTables, String> procediments;
    public static volatile SingularAttribute<RetentionTables, String> documentType;
    public static volatile SingularAttribute<RetentionTables, String> serie;
    public static volatile SingularAttribute<RetentionTables, Integer> id;
    public static volatile SingularAttribute<RetentionTables, String> totalConservation;
    public static volatile ListAttribute<RetentionTables, Alerts> alertsList;

}