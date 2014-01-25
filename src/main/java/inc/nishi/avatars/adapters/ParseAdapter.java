package inc.nishi.avatars.adapters;

import android.content.Context;
import com.parse.FunctionCallback;
import com.parse.Parse;
import com.parse.ParseCloud;
import com.parse.ParseException;
import inc.nishi.avatars.models.Email;
import inc.nishi.avatars.models.Profile;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

/**
 * @author Nishi Inc
 * @since v0.1.0
 */
@Data
public class ParseAdapter implements AvatarWebAdapter {

    private static ParseAdapter instance;
    private static List<Profile> profileList;

    private Context applicationContext;
    private String applicationId;
    private String apiKey;

    // Singleton
    private ParseAdapter(Context appContext, String parseApplicationId, String parseApiKey) {
        this.setApplicationContext(appContext);
        this.setApplicationId(parseApplicationId);
        this.setApiKey(parseApiKey);

        Parse.initialize(this.getApplicationContext(), this.getApplicationId(), this.getApiKey());
    }

    public static ParseAdapter getInstance(Context appContext, String parseApplicationId, String parseApiKey) {
        ParseAdapter.instance = ParseAdapter.instance == null ? new ParseAdapter(appContext, parseApplicationId, parseApiKey) : ParseAdapter.instance;
        return ParseAdapter.instance;
    }

    @Override
    public List<Profile> getProfile(Email... emails) {
        HashMap<String, Email> params = new HashMap<String, Email>();
        int counter = 1;
        for(Email email : emails) {
            params.put("email" + counter, email);
            counter++;
        }

        ParseCloud.callFunctionInBackground("hello", params, new FunctionCallback<Profile>() {
            public void done(Profile fetchedProfile, ParseException e) {
                if (e == null) {
                    if(ParseAdapter.profileList == null) {
                        ParseAdapter.profileList.add(fetchedProfile);
                    }
                }
            }
        });

        return ParseAdapter.profileList;
    }

}
