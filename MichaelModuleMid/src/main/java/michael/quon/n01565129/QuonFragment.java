// Michael Quon N01565129
package michael.quon.n01565129;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.google.android.material.snackbar.Snackbar;

public class QuonFragment extends Fragment {

    private TextView textView;
    private RatingBar ratingBar;
    private Button button;

    public QuonFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true); // Enable options menu for this fragment

        // Setting up fragment result listener to receive email data
        getParentFragmentManager().setFragmentResultListener(getString(R.string.emailrequestkey), this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                // Retrieve the email from the result bundle
                String email = bundle.getString(getString(R.string.emailrequestkey));
                // Update the UI with the email
                updateEmail(email);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.Michaelaction_map) {
            // Handle map menu item click specific to this fragment
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quon, container, false);

        // Initialize views
        textView = view.findViewById(R.id.MichaeltextView);
        ratingBar = view.findViewById(R.id.MichaelratingBar);
        button = view.findViewById(R.id.Michaelratingbutton);

        // Set click listener for button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float stars = ratingBar.getRating();
                String message = getString(R.string.rating) + stars;
                Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    // Method to update email TextView
    private void updateEmail(String email) {
        if (textView != null) {
            textView.setText(email);
        }
    }
}
