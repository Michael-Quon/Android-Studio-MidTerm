// Michael Quon N01565129
package michael.quon.n01565129;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


public class N01565129Fragment extends Fragment {

    private int counter = 0;
    private boolean isCounterRunning = false;
    private Handler handler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true); // Enable options menu for this fragment
        handler = new Handler(Looper.getMainLooper()); // Handler to update UI from background thread
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.Micaction_map) {
            // Handle map menu item click specific to this fragment
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_n01565129, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        startCounter();
    }

    @Override
    public void onPause() {
        super.onPause();
        stopCounter();
    }

    private void startCounter() {
        isCounterRunning = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (isCounterRunning) {
                    try {
                        Thread.sleep(1000); // every second
                        counter++;
                        // Update UI with counter value
                        handler.post(new Runnable() {
                            @Override
                            public void run() {

                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void stopCounter() {
        isCounterRunning = false;
        // Display toast with the final value of the counter
        Toast.makeText(requireContext(), getString(R.string.counter) + counter + getString(R.string.spacebar) + getString(R.string.michael_quon_id), Toast.LENGTH_LONG).show();
    }
}
