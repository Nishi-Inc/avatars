package inc.nishi.avatars.adapters;

import inc.nishi.avatars.models.Email;
import inc.nishi.avatars.models.Profile;

/**
 * @author Nishi Inc
 * @since v0.1.0
 */
public interface AvatarWebAdapter {

    /**
     * @param email to get profile of
     * @return Profile associated with the given email
     */
    public Profile getProfile(Email email);

}
