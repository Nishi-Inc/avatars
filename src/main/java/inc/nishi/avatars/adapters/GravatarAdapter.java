package inc.nishi.avatars.adapters;

import inc.nishi.avatars.models.Email;
import inc.nishi.avatars.models.Profile;
import inc.nishi.avatars.utils.AvatarsUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Nishi Inc
 * @since v0.1.0
 */
public class GravatarAdapter implements AvatarWebAdapter {

    private static GravatarAdapter instance;
    private static String NEW_LINE_CHARACTER = "\n";

    // Singleton
    private GravatarAdapter(){}

    public static GravatarAdapter getInstance() {
        GravatarAdapter.instance = GravatarAdapter.instance == null ? new GravatarAdapter() : GravatarAdapter.instance;
        return GravatarAdapter.instance;
    }

    /**
     * Calls Gravatar API
     */
    @Override
    public Profile getProfile(Email email) {
        URL url = GravatarAdapter.getUrlForEmail(email);
        StringBuilder response = new StringBuilder();
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(AvatarsUtils.GET_REQUEST);
            OutputStreamWriter request = new OutputStreamWriter(connection.getOutputStream());
            request.flush();
            request.close();

            InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line).append(GravatarAdapter.NEW_LINE_CHARACTER);
            }

            inputStreamReader.close();;
            reader.close();

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        if(response.length() > 0) {
            return GravatarAdapter.getProfileFromResponse(response.toString());
        } else {
            // TODO check if http status was 200 else throw exception
            return null;
        }

    }

    /**
     *
     * @param response response from gravatar
     * @return Profile
     */
    private static Profile getProfileFromResponse(String response) {
        // TODO inspect response once
        return null;
    }

    /**
     *
     * @param email email
     * @return URL
     */
    private static URL getUrlForEmail(Email email) {
        return null;
    }



}
