package be.bstorm.akimts.utils;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public final class EMFSharer {

    private final EntityManagerFactory emf;

    private EMFSharer(String persistenceUnit) {
        this.emf = Persistence.createEntityManagerFactory(persistenceUnit);
    }


    private EMFSharer(String persistenceUnit, Map<String, Object> props) {
        this.emf = Persistence.createEntityManagerFactory(persistenceUnit);
    }

    public static Builder builder(String persistenceUnit){
        return new Builder(persistenceUnit);
    }

    public static EMFSharer forUnit(String persistenceUnit){
        return new EMFSharer(persistenceUnit);
    }

    public static class Builder{

        private final String persistenceUnit;
        private final Map<String, Object> properties = new HashMap<>();

        public Builder(String persistenceUnit) {
            this.persistenceUnit = persistenceUnit;
        }

        public Builder withProperties(String key, Object value){
            properties.put(key, value);
            return this;
        }

        public EMFSharer build(){
            return new EMFSharer(persistenceUnit, properties);
        }

    }



}
