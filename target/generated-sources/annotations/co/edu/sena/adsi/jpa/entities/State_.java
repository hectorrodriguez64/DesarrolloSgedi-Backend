package co.edu.sena.adsi.jpa.entities;

import co.edu.sena.adsi.jpa.entities.Alerts;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-28T12:50:09")
@StaticMetamodel(State.class)
public class State_ { 

    public static volatile SingularAttribute<State, String> name;
    public static volatile SingularAttribute<State, Integer> id;
    public static volatile ListAttribute<State, Alerts> alertsList;

}