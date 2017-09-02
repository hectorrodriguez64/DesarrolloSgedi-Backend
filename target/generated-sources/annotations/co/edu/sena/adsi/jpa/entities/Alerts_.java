package co.edu.sena.adsi.jpa.entities;

import co.edu.sena.adsi.jpa.entities.Documents;
import co.edu.sena.adsi.jpa.entities.RetentionTables;
import co.edu.sena.adsi.jpa.entities.State;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-28T12:50:09")
@StaticMetamodel(Alerts.class)
public class Alerts_ { 

    public static volatile SingularAttribute<Alerts, Documents> idDocuments;
    public static volatile SingularAttribute<Alerts, Date> dateStart;
    public static volatile SingularAttribute<Alerts, RetentionTables> idRetentionTables;
    public static volatile SingularAttribute<Alerts, Integer> id;
    public static volatile SingularAttribute<Alerts, Date> dateEnd;
    public static volatile SingularAttribute<Alerts, State> idState;

}