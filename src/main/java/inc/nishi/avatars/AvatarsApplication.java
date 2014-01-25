package inc.nishi.avatars;

import android.app.Application;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author Nishi Inc
 * @since v0.1.0
 */
public class AvatarsApplication extends Application {

    private SQLiteOpenHelper repositoryHelper;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public SQLiteOpenHelper getRepositoryHelper() {
        return repositoryHelper;
    }

    public void setRepositoryHelper(SQLiteOpenHelper repositoryHelper) {
        this.repositoryHelper = repositoryHelper;
    }


}
