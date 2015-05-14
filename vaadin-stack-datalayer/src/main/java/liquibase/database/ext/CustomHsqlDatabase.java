package liquibase.database.ext;

import liquibase.database.core.HsqlDatabase;
import liquibase.structure.DatabaseObject;

/**
 * Created by thomas on 14.05.15.
 */
public class CustomHsqlDatabase extends HsqlDatabase {
    @Override
    public String escapeObjectName(String objectName, Class<? extends DatabaseObject> objectType) {
        return super.escapeObjectName(objectName, objectType);
    }
}
