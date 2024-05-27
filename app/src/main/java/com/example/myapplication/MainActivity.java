package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText nameField, emailField, phoneField, addressField, usernameField, passwordField;
    private Spinner citySpinner, stateSpinner;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameField = findViewById(R.id.nameField);
        emailField = findViewById(R.id.emailField);
        phoneField = findViewById(R.id.phoneField);
        addressField = findViewById(R.id.addressField);
        usernameField = findViewById(R.id.usernameField);
        passwordField = findViewById(R.id.passwordField);
        citySpinner = findViewById(R.id.citySpinner);
        stateSpinner = findViewById(R.id.stateSpinner);
        submitButton = findViewById(R.id.submitButton);

        ArrayAdapter<CharSequence> cityAdapter = ArrayAdapter.createFromResource(this,
                R.array.cities_array, android.R.layout.simple_spinner_item);
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinner.setAdapter(cityAdapter);

        ArrayAdapter<CharSequence> stateAdapter = ArrayAdapter.createFromResource(this,
                R.array.states_array, android.R.layout.simple_spinner_item);
        stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stateSpinner.setAdapter(stateAdapter);

        submitButton.setOnClickListener(view -> submitForm());
    }

    private void submitForm() {
        String name = nameField.getText().toString();
        String email = emailField.getText().toString();
        String phone = phoneField.getText().toString();
        String address = addressField.getText().toString();
        String city = citySpinner.getSelectedItem().toString();
        String state = stateSpinner.getSelectedItem().toString();
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();

        if (!ValidationHelper.isNotEmpty(name)) {
            showToast("Nome é obrigatório!");
            return;
        }
        if (!ValidationHelper.isValidEmail(email)) {
            showToast("Email inválido!");
            return;
        }
        if (!ValidationHelper.isValidPhone(phone)) {
            showToast("Telefone inválido! Deve conter 10 dígitos.");
            return;
        }
        if (!ValidationHelper.isNotEmpty(address)) {
            showToast("Endereço é obrigatório!");
            return;
        }
        if (!ValidationHelper.isNotEmpty(city)) {
            showToast("Cidade é obrigatória!");
            return;
        }
        if (!ValidationHelper.isNotEmpty(state)) {
            showToast("Estado é obrigatório!");
            return;
        }
        String zipCode = null;
        if (!ValidationHelper.isValidZipCode(zipCode)) {
            showToast("CEP inválido! Deve estar no formato 12345-678.");
            return;
        }
        String country = null;
        if (!ValidationHelper.isNotEmpty(country)) {
            showToast("País é obrigatório!");
            return;
        }
        if (!ValidationHelper.isNotEmpty(username)) {
            showToast("Nome de usuário é obrigatório!");
            return;
        }
        if (!ValidationHelper.isValidPassword(password)) {
            showToast("Senha inválida! Deve ter pelo menos 8 caracteres.");
            return;
        }

        User user = new User(name, email, phone, address, city, state, zipCode, country, username, password);
        // Aqui você pode salvar o usuário no banco de dados ou executar outras ações necessárias.
        showToast("Usuário cadastrado com sucesso!");
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
