package edu.umn.d.lab11;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.util.Log;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Random;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements MainView {
    private Presenter presenter;
    private EditText editTextText2;
    private TextView nameOfVertex;
    int counter = 0;

    private static final String TAG = "DemoInitialApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn = (Button) findViewById(R.id.button);

        Random rand = new Random();

        editTextText2 = findViewById(R.id.editTextText2);
        nameOfVertex = findViewById(R.id.nameOfVertex);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("DemoInitialApp", "This button adds a vertex");
                    Toast.makeText(getApplicationContext(), "Added Vertex", Toast.LENGTH_SHORT).show();

                    counter++;
                    TextView text = (TextView) findViewById(R.id.numberVertices);
                    text.setText ("Number Of Vertices: " + counter);

                    String vertexName = editTextText2.getText().toString();
                    presenter.vertexCounter(vertexName);

                    DrawingCanvas drawingCanvas = findViewById(R.id.drawingCanvas);

                    presenter.vertexCounter(vertexName);

                    // Constraining the vertex to be within the "Graph Created" space
                    int maxX = 1000;
                    int maxY = 1500;
                    int minX = 20;
                    int minY = 900;

                    int randomX = rand.nextInt((maxX - minX) + 1) + minX;
                    int randomY = rand.nextInt((maxY - minY) + 1) + minY;

                    VertexVisual vertex = new VertexVisual(vertexName, randomX, randomY, 20);
                    drawingCanvas.addVertex(vertex);

                }

            });

            DrawingCanvas dc = findViewById(R.id.drawingCanvas);
           presenter = new Presenter(this);

            // Drop down menu
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.search_methods,
                android.R.layout.simple_spinner_item
        );
// Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner.
        spinner.setAdapter(adapter);
    }

    @Override
    public void addVertexClick() {

    }

    @Override
    public void recentVertex(String vertexName) {
        nameOfVertex.setText("Name Of Vertex: " + vertexName);
    }

    @Override
    public void addVertex(Vertex vertex) {

    }

}