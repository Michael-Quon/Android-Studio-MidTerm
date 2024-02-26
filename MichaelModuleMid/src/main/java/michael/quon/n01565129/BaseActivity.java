// Michael Quon N01565129
package michael.quon.n01565129;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.Manifest;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class BaseActivity extends AppCompatActivity {

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 100;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate menu; adds items to action bar if present
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.Michaelaction_map) {
            // Check for location permission
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                // Permission already granted, launch map
                launchMap();
            } else {
                // Request location permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        LOCATION_PERMISSION_REQUEST_CODE);
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, launch map
                launchMap();
            } else {
                // Permission denied, show toast
                Toast.makeText(this, (R.string.access_denied), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void launchMap() {
        // Humber College latitude and longitude
        double latitude = 43.7288;
        double longitude = 79.6066;

        Uri gmmIntentUri = Uri.parse(getString(R.string.location) + latitude + getString(R.string.comma) + longitude);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

            startActivity(mapIntent);
    }
}
