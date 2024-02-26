// Michael Quon N01565129
package michael.quon.n01565129;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class MichaelFragment extends Fragment {

    private AutoCompleteTextView michaelEmailAutoCompleteEditText;

    public MichaelFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true); // Enable options menu for this fragment
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
        View view = inflater.inflate(R.layout.fragment_michael, container, false);

        String[] emails = getResources().getStringArray(R.array.Michael_emails);
        michaelEmailAutoCompleteEditText = view.findViewById(R.id.MichaelemailAutoCompleteEditText);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_dropdown_item_1line, emails);
        michaelEmailAutoCompleteEditText.setAdapter(adapter);
        michaelEmailAutoCompleteEditText.setHint(getString(R.string.enter_email));

        Button michaelSubmitButton = view.findViewById(R.id.Michaelsubmitbutton);
        michaelSubmitButton.setOnClickListener(v -> onMichaelSubmitButtonClicked());

        return view;
    }

    private void onMichaelSubmitButtonClicked() {
        String enteredEmail = michaelEmailAutoCompleteEditText.getText().toString().trim();

        if (TextUtils.isEmpty(enteredEmail)) {
            michaelEmailAutoCompleteEditText.setError(getString(R.string.cannot_be_empty));
        } else if (!isValidEmail(enteredEmail)) {
            michaelEmailAutoCompleteEditText.setError(getString(R.string.invalid_email));
        } else {
            // Pass to next tab/fragment
            Bundle result = new Bundle();
            result.putString(getString(R.string.emailrequestkey), enteredEmail);
            getParentFragmentManager().setFragmentResult(getString(R.string.emailrequestkey), result);

            // Show a Toast message
            String message = getString(R.string.email) + enteredEmail;
            Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show();

            // Clear user input
            michaelEmailAutoCompleteEditText.setText(R.string.clearinput);
        }
    }

    private boolean isValidEmail(CharSequence validEmail) {
        return !TextUtils.isEmpty(validEmail) && Patterns.EMAIL_ADDRESS.matcher(validEmail).matches();
    }
}
