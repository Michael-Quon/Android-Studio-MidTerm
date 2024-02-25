// Michael Quon N01565129
package michael.quon.n01565129;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
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
        String email = michaelEmailAutoCompleteEditText.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            michaelEmailAutoCompleteEditText.setError(getString(R.string.cannot_be_empty));
        } else if (!isValidEmail(email)) {
            michaelEmailAutoCompleteEditText.setError(getString(R.string.invalid_email));
        } else {
            // Pass to next tab/fragment
            String message = getString(R.string.email) + email;
            Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show();

            // Clear user input
            michaelEmailAutoCompleteEditText.setText("");
        }
    }

    private boolean isValidEmail(CharSequence validEmail) {
        return !TextUtils.isEmpty(validEmail) && Patterns.EMAIL_ADDRESS.matcher(validEmail).matches();
    }
}
