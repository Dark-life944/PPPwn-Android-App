package com.example.yourprojectname; // Replace with your package name

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Process;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerFirmware;
    private Button buttonRunScript;
    private List<String> firmwareOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerFirmware = findViewById(R.id.spinnerFirmware);
        buttonRunScript = findViewById(R.id.buttonRunScript);

        // Initialize firmware options
        firmwareOptions = new ArrayList<>();
        firmwareOptions.add("900");
        firmwareOptions.add("903");
        firmwareOptions.add("960");
        firmwareOptions.add("1000");
        firmwareOptions.add("1001");
        firmwareOptions.add("1071");
        firmwareOptions.add("1100");

        // Populate firmware spinner with data
        ArrayAdapter<String> firmwareAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                firmwareOptions);
        firmwareAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFirmware.setAdapter(firmwareAdapter);

        spinnerFirmware.setOnItemSelectedListener(this);

        buttonRunScript.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Run script based on selected firmware
                String selectedFirmware = spinnerFirmware.getSelectedItem().toString();
                String pythonScriptPath = "pppwn" + selectedFirmware + ".py"; // Adjust path as needed

                try {
                    // Get the current process
                    String command = String.format("python %s --fw=%s --interface=eth0", pythonScriptPath, selectedFirmware);
                    Process process = Runtime.getRuntime().exec(command);

                    // Read process output
                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        // Process output line here
                        // You can update UI elements or log the output
                        // Example:
                        TextView outputTextView = findViewById(R.id.outputTextView);
                        outputTextView.setText(outputTextView.getText() + "\n" + line);
                    }

                    reader.close();

                    // Check process exit code
                    int exitCode = process.waitFor();
                    if (exitCode != 0) {
                        // Handle error case
                        TextView outputTextView = findViewById(R.id.outputTextView);
                        outputTextView.setText(outputTextView.getText() + "\nError: Script exited with code " + exitCode);
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                    // Handle exceptions
                    TextView outputTextView = findViewById(R.id.outputTextView);
                    outputTextView.setText(outputTextView.getText() + "\nError: " + e.getMessage());
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // Handle spinner item selection if needed
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Do nothing if needed
    }
}
