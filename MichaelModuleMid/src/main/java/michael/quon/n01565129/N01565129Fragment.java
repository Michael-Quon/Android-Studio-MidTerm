// Michael Quon N01565129
package michael.quon.n01565129;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.Toast;


public class N01565129Fragment extends Fragment {

    private int counter = 0;

    public N01565129Fragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_n01565129, container, false);

        ImageView imageView = view.findViewById(R.id.MichaelimageView);
        TextClock textClock = view.findViewById(R.id.MichaeltextClock);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        // start counter when fragment resumes
        startCounter();
    }

    @Override
    public void onPause() {
        super.onPause();
        // stop counter when fragment pauses
        stopCounter();
    }

    private void startCounter() {
        new Thread((new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000); // every second
                        counter++;
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        })).start();
    }

    private void stopCounter() {
        // stops counter, and displays toast with value of counter and name+id
        Toast.makeText(requireContext(), getString(R.string.counter) + counter + " " + getString(R.string.michael_quon_id), Toast.LENGTH_LONG).show();
    }

}