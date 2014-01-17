package inc.nishi.avatars.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import inc.nishi.avatars.adapters.GravatarAdapter;
import inc.nishi.avatars.models.Email;
import inc.nishi.avatars.models.Profile;
import inc.nishi.avatars.utils.AvatarsUtils;

/**
 * @author Nishi Inc
 * @since v0.0.1
 */
public class CommunicationService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        // TODO examine intent
        return null;
    }

    /**
     *
     * @param email email
     * @return profile for a given email address
     */
    public Profile getProfile(String email) {
        if(AvatarsUtils.isValidEmail(email)) {
            return this.getGravatarAdapter().getProfile(new Email(email));
        } else {
            return new Profile(null, null);
        }
    }

    private GravatarAdapter getGravatarAdapter() {
        return GravatarAdapter.getInstance();
    }

}
