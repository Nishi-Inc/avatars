package inc.nishi.gravatar.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import inc.nishi.gravatar.adapters.GravatarAdapter;
import inc.nishi.gravatar.models.Email;
import inc.nishi.gravatar.models.Profile;
import inc.nishi.gravatar.utils.GravatarUtils;

/**
 * @author Nishi Inc
 * @since v0.0.1
 */
public class CommunicationService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public Profile getProfile(String email) {
        if(GravatarUtils.isValidEmail(email)) {
            return this.getGravatarAdapter().getProfile(new Email(email));
        } else {
            return new Profile(null, null);
        }
    }

    private GravatarAdapter getGravatarAdapter() {
        return GravatarAdapter.getInstance();
    }

}
