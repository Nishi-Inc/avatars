package inc.nishi.avatars.models;

import inc.nishi.avatars.utils.AvatarsUtils;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Nishi Inc
 * @since v0.1.0
 */
@Data
public class Email implements Serializable {

    private String username;
    private String domain;

    public Email(){}

    public Email(String email) {
        if(AvatarsUtils.isValidEmail(email)) {
            this.setUsername(email.split(AvatarsUtils.AT)[0]);
            this.setDomain(email.split(AvatarsUtils.AT)[1]);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return this.getUsername() + AvatarsUtils.AT + this.getDomain();
    }

}
