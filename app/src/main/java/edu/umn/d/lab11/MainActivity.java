package edu.umn.d.lab11;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private EditText editTextText2;
    private TextView nameOfVertex;
    private EditText editTextEdge;
    private EditText editTextEdge2;
    private DrawingCanvas drawingCanvas;
    private List<VertexVisual> vertices = new ArrayList<>();
    private int counter = 0;

    private static final String TAG = "DemoInitialApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            Button createVertexButton = findViewById(R.id.button);
            drawingCanvas = findViewById(R.id.drawingCanvas);

            Random rand = new Random();

            editTextText2 = findViewById(R.id.editTextText2);
            editTextEdge = findViewById(R.id.editTextEdge);
            editTextEdge2 = findViewById(R.id.editTextEdge2);
            nameOfVertex = findViewById(R.id.nameOfVertex);

            createVertexButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Added Vertex", Toast.LENGTH_SHORT).show();

                    String vertexName = editTextText2.getText().toString();

                    counter++;
                    TextView text = (TextView) findViewById(R.id.numberVertices);
                    text.setText("Number Of Vertices: " + counter);

                    int maxX = 1000;
                    int maxY = 1500;
                    int minX = 20;
                    int minY = 900;

                    int randomX = rand.nextInt((maxX - minX) + 1) + minX;
                    int randomY = rand.nextInt((maxY - minY) + 1) + minY;

                    VertexVisual vertex = new VertexVisual(vertexName, randomX, randomY, 20);
                    drawingCanvas.addVertex(vertex);
                    vertices.add(vertex);
                }
            });

            Button btnCreateEdge = findViewById(R.id.createEdge);
            btnCreateEdge.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String vertexName1 = editTextEdge.getText().toString();
                    String vertexName2 = editTextEdge2.getText().toString();

                    VertexVisual vertex1 = findVertexVisualByName(vertexName1);
                    VertexVisual vertex2 = findVertexVisualByName(vertexName2);

                    if (vertex1 != null && vertex2 != null) {
                        float distance = calculateDistance(vertex1, vertex2);

                        EdgeVisual edge = new EdgeVisual(vertex1, vertex2, distance);
                        drawingCanvas.addEdge(edge);
                    } else {
                        Toast.makeText(getApplicationContext(), "Vertices not found", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            Spinner spinner = findViewById(R.id.spinner);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                    MainActivity.this,
                    R.array.search_methods,
                    android.R.layout.simple_spinner_item
            );
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);

            return insets;
        });
    }

    private VertexVisual findVertexVisualByName(String name) {
        for (VertexVisual vertex : vertices) {
            if (vertex.getVertexName().equals(name)) {
                return vertex;
            }
        }
        return null;
    }

    private float calculateDistance(VertexVisual v1, VertexVisual v2) {
        float dx = v2.getX() - v1.getX();
        float dy = v2.getY() - v1.getY();
        return (float) Math.sqrt(dx * dx + dy * dy);
    }
}

