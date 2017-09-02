package co.edu.sena.adsi.jpa.entities;

import co.edu.sena.adsi.jpa.entities.Formalities;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-28T12:50:09")
@StaticMetamodel(Packages.class)
public class Packages_ { 

    public static volatile SingularAttribute<Packages, String> price;
    public static volatile SingularAttribute<Packages, String> name;
    public static volatile SingularAttribute<Packages, Integer> id;
    public static volatile ListAttribute<Packages, Formalities> formalitiesList;

}