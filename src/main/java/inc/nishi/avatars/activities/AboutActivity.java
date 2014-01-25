package inc.nishi.avatars.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import inc.nishi.avatars.R;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Nishi Inc
 * @since v0.1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AboutActivity extends AvatarsActivitySupport {

    private TextView licenseText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.about);

        this.setLicenseText((TextView) this.findViewById(R.id.license));

        this.getLicenseText().setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.license) {
            // Show Apache license v2.0 in browser
            this.openBrowser(this.getString(R.string.licenseUrl));
        }

    }

    @Override
    public boolean onLongClick(View view) {
        if(view.getId() == R.id.license) {
            return AvatarsActivitySupport.propagateEvent;
        }
        return AvatarsActivitySupport.propagateEvent;
    }

}
