package smkn4bdg.radhika.com.tugasdatabase.realm;

import android.content.Context;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by root on 27/01/17.
 */

public class RealmController {
    private Realm realm;
    private Context mContext;


    public RealmController(Context context) {
        this.mContext = context;
        realm = Realm.getInstance(context);
    }

    public Realm getRealm() {
        return realm;
    }

    public <T extends RealmObject> T getById(Class<? extends RealmObject> cls, int id) {
        return (T) this.getRealm().where(cls.asSubclass(RealmObject.class)).equalTo("id", id).findFirst();
    }

    public RealmResults<? extends RealmObject> getAllData(Class<? extends RealmObject> cls) {
        return this.getRealm().where(cls.asSubclass(RealmObject.class)).findAll();
    }

    public void add(RealmObject object) {
        this.getRealm().beginTransaction();
        this.getRealm().copyToRealm(object);
        this.getRealm().commitTransaction();
    }

    public void add(List<RealmObject> listObject) {
        this.getRealm().beginTransaction();
        this.getRealm().copyToRealm(listObject);
        this.getRealm().commitTransaction();
    }

    public void delete(Class<? extends RealmObject> cls, int id) {
        RealmResults results = this.getRealm().where(cls.asSubclass(RealmObject.class)).equalTo("id", id).findAll();
        this.getRealm().beginTransaction();
        results.clear();
        this.getRealm().commitTransaction();
    }

    public void update(RealmObject object){
        this.getRealm().copyToRealmOrUpdate(object);
        this.getRealm().commitTransaction();
    }

}
